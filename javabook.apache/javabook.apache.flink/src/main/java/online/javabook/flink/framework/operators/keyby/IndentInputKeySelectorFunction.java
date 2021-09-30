package online.javabook.flink.framework.operators.keyby;

import online.javabook.flink.framework.data.domain.IndentInput;
import org.apache.flink.api.java.functions.KeySelector;

public class IndentInputKeySelectorFunction implements KeySelector<IndentInput, String> {
    @Override
    public String getKey(IndentInput indent) {
        return indent.getName();
    }
}
