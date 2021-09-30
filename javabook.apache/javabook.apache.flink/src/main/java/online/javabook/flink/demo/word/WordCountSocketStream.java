package online.javabook.flink.demo.word;

import online.javabook.flink.framework.data.mapper.WordFlatMapperFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * nc -lkv -np 7777
 */
public class WordCountSocketStream {
    public static void main(String[] args) throws Exception{

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        ParameterTool parameterTool = ParameterTool.fromArgs(args);

        // paras
        String host = parameterTool.get("host");
        int port = parameterTool.getInt("port");

        // inputDataStream
        DataStream<String> inputDataStream = env.socketTextStream(host, port);

        // outputDataStream
        DataStream<Tuple2<String, Integer>> outputDataStream = inputDataStream.flatMap( new WordFlatMapperFunction())
                .keyBy(0)
                .sum(1);

        // sink
        outputDataStream.print();

        // execute
        env.execute();
    }
}
