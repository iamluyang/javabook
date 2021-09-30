package online.javabook.flink.framework.data.domain;

public class OrderOutput {

    private String name;
    private double total;
    private double average;
    private long count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderOutput{" +
                "name='" + name + '\'' +
                ", total=" + total +
                ", average=" + average +
                ", count=" + count +
                '}';
    }
}
