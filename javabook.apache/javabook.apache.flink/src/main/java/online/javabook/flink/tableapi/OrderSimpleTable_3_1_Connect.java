package online.javabook.flink.tableapi;

import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.OrderInputProcessTimeMapperFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.TableSchema;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.data.StringData;
import org.apache.flink.table.descriptors.*;
import org.apache.flink.table.types.DataType;
import org.apache.flink.table.types.logical.DateType;
import org.apache.flink.types.Row;

public class OrderSimpleTable_3_1_Connect {
    public static void main(String[] args) throws Exception {

        // blinkStreamEnvironmentSettings
        EnvironmentSettings blinkStreamEnvironmentSettings = EnvironmentSettings.newInstance()
                .useBlinkPlanner().inStreamingMode().build();

        // streamExecutionEnvironment
        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        streamExecutionEnvironment.setParallelism(1);

        // blinkStreamTableEnvironment
        StreamTableEnvironment blinkStreamTableEnvironment = StreamTableEnvironment.create(streamExecutionEnvironment, blinkStreamEnvironmentSettings);

        // connect
        String inputPath = "javabook.apache/javabook.apache.flink/mock/csv.txt";
        String outputPath = "D:/csv-out.txt";
        blinkStreamTableEnvironment
                .connect(new FileSystem().path(inputPath))
                .withFormat(new Csv().fieldDelimiter(';'))
                .withSchema(new Schema()
                .field("name", DataTypes.STRING())
                .field("location", DataTypes.STRING())
                .field("price", DataTypes.DOUBLE())
                .field("timestamp", DataTypes.BIGINT())
                .rowtime(new Rowtime()
                .timestampsFromField("timestamp")
                .watermarksPeriodicBounded(1000)))
                .createTemporaryTable("inputmytable");


        // selectTable
        Table selectTable1 = blinkStreamTableEnvironment.sqlQuery("select name, location, price, timestamp from inputmytable where name = 'A'");
        //blinkStreamTableEnvironment.toAppendStream(selectTable1, Row.class).print("selectTable1");

        Table selectTable2 = blinkStreamTableEnvironment.sqlQuery("select name, location, price, timestamp from inputmytable where name = 'A'");
        blinkStreamTableEnvironment.toAppendStream(selectTable2, Row.class).print("selectTable2");

        // aggreTable
        Table aggreTable = blinkStreamTableEnvironment.sqlQuery("select name, count(name) as namecount, sum(price) sumprice from inputmytable where name = 'A' group by name");
        //blinkStreamTableEnvironment.toRetractStream(aggreTable, Row.class).print("aggreTable");

        // output
        //selectTable1.insertInto("outputmytable");

        // execute
        streamExecutionEnvironment.execute();
    }
}