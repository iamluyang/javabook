package online.javabook.flink.framework.data.mapper;

import online.javabook.flink.framework.data.domain.IndentInput;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.util.Collector;

import java.util.Calendar;

public class IndentInputProcessTimeMapperFunction extends RichFlatMapFunction<String, IndentInput> {
    public void flatMap(String value, Collector<IndentInput> out) {
        String[] values = value.split(" ");
        out.collect(new IndentInput(values[0], values[1], Integer.parseInt(values[2]), Calendar.getInstance().getTime()));
    }
}