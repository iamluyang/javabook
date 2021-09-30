package online.javabook.flink.tableapi;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.bridge.java.BatchTableEnvironment;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

/**
 * Keyed Windows
 * <p>
 * stream
 * .keyBy(...)               <-  keyed versus non-keyed windows
 * .window(...)              <-  required: "assigner"
 * [.trigger(...)]            <-  optional: "trigger" (else default trigger)
 * [.evictor(...)]            <-  optional: "evictor" (else no evictor)
 * [.allowedLateness(...)]    <-  optional: "lateness" (else zero)
 * [.sideOutputLateData(...)] <-  optional: "output tag" (else no side output for late data)
 * .reduce/aggregate/apply()      <-  required: "function"
 * [.getSideOutput(...)]      <-  optional: "output tag"
 * <p>
 * ---------------------------------------------------------------
 * <p>
 * Non-Keyed Windows
 * <p>
 * stream
 * .windowAll(...)           <-  required: "assigner"
 * [.trigger(...)]            <-  optional: "trigger" (else default trigger)
 * [.evictor(...)]            <-  optional: "evictor" (else no evictor)
 * [.allowedLateness(...)]    <-  optional: "lateness" (else zero)
 * [.sideOutputLateData(...)] <-  optional: "output tag" (else no side output for late data)
 * .reduce/aggregate/apply()      <-  required: "function"
 * [.getSideOutput(...)]      <-  optional: "output tag"
 */
public class OrderSimpleTable_1_1_CreateTableEnvironmentByFlink {
    public static void main(String[] args) throws Exception {

        // flink的流处理
        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        streamExecutionEnvironment.setParallelism(1);
        StreamTableEnvironment.create(streamExecutionEnvironment);

        // flink的流处理
        EnvironmentSettings flinkStreamEnvironmentSettings = EnvironmentSettings.newInstance()
                .useOldPlanner()
                .inStreamingMode()
                .build();
        StreamTableEnvironment flinkStreamTableEnvironment = StreamTableEnvironment.create(streamExecutionEnvironment, flinkStreamEnvironmentSettings);

        // flink的批处理
        ExecutionEnvironment batchExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment();
        BatchTableEnvironment flinkBatchTableEnvironment = BatchTableEnvironment.create(batchExecutionEnvironment);
    }
}