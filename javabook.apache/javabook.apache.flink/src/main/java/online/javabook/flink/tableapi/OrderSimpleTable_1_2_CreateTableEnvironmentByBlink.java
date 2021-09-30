package online.javabook.flink.tableapi;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableEnvironment;
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
public class OrderSimpleTable_1_2_CreateTableEnvironmentByBlink {
    public static void main(String[] args) throws Exception {

        // streamExecutionEnvironment
        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        streamExecutionEnvironment.setParallelism(1);

        // blink的流处理
        EnvironmentSettings blinkStreamEnvironmentSettings = EnvironmentSettings.newInstance()
                .useBlinkPlanner()
                .inStreamingMode()
                .build();

        StreamTableEnvironment blinkStreamTableEnvironment = StreamTableEnvironment
                .create(streamExecutionEnvironment, blinkStreamEnvironmentSettings);

        // blink的批处理
        EnvironmentSettings blinkBatchEnvironmentSettings = EnvironmentSettings.newInstance()
                .useBlinkPlanner()
                .inBatchMode()
                .build();

        TableEnvironment blinkBatchTableEnvironment = TableEnvironment.create(blinkBatchEnvironmentSettings);
    }
}