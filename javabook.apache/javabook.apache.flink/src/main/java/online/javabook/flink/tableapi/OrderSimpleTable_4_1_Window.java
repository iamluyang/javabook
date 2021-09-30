package online.javabook.flink.tableapi;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.descriptors.Csv;
import org.apache.flink.table.descriptors.FileSystem;
import org.apache.flink.table.descriptors.Rowtime;
import org.apache.flink.table.descriptors.Schema;
import org.apache.flink.types.Row;

public class OrderSimpleTable_4_1_Window {
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
                .field("rt.rowtime", DataTypes.TIMESTAMP(3)).rowtime(new Rowtime()))
                .createTemporaryTable("inputmytable");

        blinkStreamTableEnvironment
                .connect(new FileSystem().path(outputPath))
                .withFormat(new Csv().fieldDelimiter(';'))
                .inAppendMode()
                .withSchema(new Schema()
                        .field("name", DataTypes.STRING())
                        .field("location", DataTypes.STRING())
                        .field("price", DataTypes.DOUBLE()))
                .createTemporaryTable("outputmytable");


        // selectTable
        Table selectTable = blinkStreamTableEnvironment.sqlQuery("select name, location, price, rt from inputmytable where name = 'A'");
        blinkStreamTableEnvironment.toAppendStream(selectTable, Row.class).print("selectTable");

        // aggreTable
        Table aggreTable = blinkStreamTableEnvironment.sqlQuery("select name, count(name) as namecount, sum(price) sumprice from inputmytable where name = 'A' group by name");
        blinkStreamTableEnvironment.toRetractStream(aggreTable, Row.class).print("aggreTable");

        // output
        selectTable.insertInto("outputmytable");

        // execute
        streamExecutionEnvironment.execute();
    }
}