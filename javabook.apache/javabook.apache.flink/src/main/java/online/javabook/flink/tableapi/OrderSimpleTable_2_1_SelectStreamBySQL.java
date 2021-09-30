package online.javabook.flink.tableapi;

import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.OrderInputProcessTimeMapperFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;

public class OrderSimpleTable_2_1_SelectStreamBySQL {
    public static void main(String[] args) throws Exception {

        // blinkStreamEnvironmentSettings
        EnvironmentSettings blinkStreamEnvironmentSettings = EnvironmentSettings.newInstance()
                .useBlinkPlanner().inStreamingMode().build();

        // streamExecutionEnvironment
        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        streamExecutionEnvironment.setParallelism(1);

        // blinkStreamTableEnvironment
        StreamTableEnvironment blinkStreamTableEnvironment = StreamTableEnvironment.create(streamExecutionEnvironment, blinkStreamEnvironmentSettings);

        // stream
        DataStream<OrderInput> stream = streamExecutionEnvironment
                .addSource(new OrderSimpleTableSoruce())
                .flatMap(new OrderInputProcessTimeMapperFunction());

        // stream->table
        Table table1 = blinkStreamTableEnvironment.fromDataStream(stream, "name, location, price, pt.proctime as pt");
        blinkStreamTableEnvironment.createTemporaryView("table1", table1);

        // selectTable
        Table selectTable = blinkStreamTableEnvironment.sqlQuery("select name, location, price, pt from table1 where name = 'A'");
        blinkStreamTableEnvironment.toAppendStream(selectTable, Row.class).print("sqlTable");

        // aggreTable
        Table aggreTable = blinkStreamTableEnvironment.sqlQuery("select name, count(name) as namecount, sum(price) sumprice from table1 where name = 'A' group by name");
        blinkStreamTableEnvironment.toRetractStream(aggreTable, Row.class).print("aggreTable");

        // execute
        streamExecutionEnvironment.execute();
    }
}