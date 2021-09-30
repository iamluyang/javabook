package online.javabook.flink.tableapi;

import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.OrderInputProcessTimeMapperFunction;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;

public class OrderSimpleTable_2_1_SelectStreamByTable {
    public static void main(String[] args) throws Exception {

        // blinkStreamEnvironmentSettings
        EnvironmentSettings blinkStreamEnvironmentSettings = EnvironmentSettings.newInstance()
                .useBlinkPlanner().inStreamingMode().build();

        // streamExecutionEnvironment
        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        streamExecutionEnvironment.setParallelism(1);
        streamExecutionEnvironment.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        // blinkStreamTableEnvironment
        StreamTableEnvironment blinkStreamTableEnvironment = StreamTableEnvironment
                .create(streamExecutionEnvironment, blinkStreamEnvironmentSettings);

        // stream
        DataStream<OrderInput> stream = streamExecutionEnvironment
                .addSource(new OrderSimpleTableSoruce())
                .flatMap(new OrderInputProcessTimeMapperFunction());

        // stream->table
        Table table = blinkStreamTableEnvironment.fromDataStream(stream, "name,location,price,timestamp.rowtime");

        // run
        Table selectedTable = table.select("name,location, price").where("name='A'");
        blinkStreamTableEnvironment.toAppendStream(selectedTable, Row.class).print("selectedTable");

        // execute
        streamExecutionEnvironment.execute();
    }
}