package online.javabook.flink.demo.word;

import online.javabook.flink.framework.data.mapper.WordFlatMapperFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;

import java.io.File;

public class WordCountDataSet {
    public static void main(String[] args) throws Exception {

        // env
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(4);

        // input
        String inputPath = "javabook.apache/javabook.apache.flink/mock/word.txt";
        File file = new File(inputPath);
        DataSet<String> inputDataSet = env.readTextFile(file.getAbsolutePath());

        // transform
        DataSet<Tuple2<String, Integer>> transformDataSet = inputDataSet
                .flatMap(new WordFlatMapperFunction())
                .groupBy(0)
                .sum(1);

        // sink
        transformDataSet.print();
    }
}
