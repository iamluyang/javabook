package online.javabook.flink.framework.data.mapper;

import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class WordFlatMapperFunction extends RichFlatMapFunction<String, Tuple2<String, Integer>> {
    public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
        String[] words = value.split(" ");
        for (String word : words) {
            out.collect(new Tuple2<>(word, 1));
        }
    }
}