package online.javabook.flink.demo.word;

import online.javabook.flink.framework.data.mapper.WordFlatMapperFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.io.File;

public class WordCountStreamSet {
    public static void main(String[] args) throws Exception {

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(4);

        // input
        String inputPath = "javabook.apache/javabook.apache.flink/mock/word.txt";
        File file = new File(inputPath);
        DataStream<String> inputDataStream = env.readTextFile(file.getAbsolutePath());

        // transform
        DataStream<Tuple2<String, Integer>> transformDataStream = inputDataStream.flatMap(new WordFlatMapperFunction())
                .keyBy(0)
                .sum(1);

        // sink
        transformDataStream.print();

        // execute
        env.execute();
    }
}
