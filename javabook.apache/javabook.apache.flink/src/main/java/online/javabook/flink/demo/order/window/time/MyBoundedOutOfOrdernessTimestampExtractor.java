package online.javabook.flink.demo.order.window.time;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;
import org.apache.flink.streaming.api.windowing.time.Time;

public abstract class MyBoundedOutOfOrdernessTimestampExtractor<T>
        implements AssignerWithPeriodicWatermarks<T> {

    private static final long serialVersionUID = 1L;

    /** The current maximum timestamp seen so far. */
    private long currentMaxTimestamp;

    /** The timestamp of the last emitted watermark. */
    private long lastEmittedWatermark = Long.MIN_VALUE;

    /**
     * The (fixed) interval between the maximum seen timestamp seen in the records and that of the
     * watermark to be emitted.
     */
    private final long maxOutOfOrderness;

    public MyBoundedOutOfOrdernessTimestampExtractor(Time maxOutOfOrderness) {
        if (maxOutOfOrderness.toMilliseconds() < 0) {
            throw new RuntimeException(
                    "Tried to set the maximum allowed "
                            + "lateness to "
                            + maxOutOfOrderness
                            + ". This parameter cannot be negative.");
        }
        this.maxOutOfOrderness = maxOutOfOrderness.toMilliseconds();
        this.currentMaxTimestamp = Long.MIN_VALUE + this.maxOutOfOrderness;
    }

    public long getMaxOutOfOrdernessInMillis() {
        return maxOutOfOrderness;
    }

    /**
     * Extracts the timestamp from the given element.
     *
     * @param element The element that the timestamp is extracted from.
     * @return The new timestamp.
     */
    public abstract long extractTimestamp(T element);

    @Override
    public final Watermark getCurrentWatermark() {
        // this guarantees that the watermark never goes backwards.
        long potentialWM = currentMaxTimestamp - maxOutOfOrderness;
        if (potentialWM >= lastEmittedWatermark) {
            lastEmittedWatermark = potentialWM;
        }
        //System.out.println("当前水线位置：" + lastEmittedWatermark);
        return new Watermark(lastEmittedWatermark);
    }

    @Override
    public final long extractTimestamp(T element, long previousElementTimestamp) {
        long timestamp = extractTimestamp(element);

        System.out.println("上一最大事件时间戳：" + format(currentMaxTimestamp) +";当前消息的事件时间戳：" + format(timestamp) );
        if (timestamp > currentMaxTimestamp) {
            currentMaxTimestamp = timestamp;
        }
        System.out.println("最近一次水位线位置：" + format(lastEmittedWatermark) + ";当前的最大事件时间戳：" + format(currentMaxTimestamp));
        System.out.println();
        return timestamp;
    }

    private String format(long timestamp) {
        return DateFormatUtils.format(timestamp, "yy-mm-dd:hh-mm-ss");
    }
}
