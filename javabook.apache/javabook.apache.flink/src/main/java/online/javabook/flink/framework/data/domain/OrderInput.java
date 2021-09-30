package online.javabook.flink.framework.data.domain;

import java.io.Serializable;
import java.util.Date;

public class OrderInput implements Serializable {

    public OrderInput() {

    }

    public OrderInput(String name, String location, int price, String timestamp) {
        this.name = name;
        this.location = location;
        this.price = price;
        String[] times = timestamp.split("-");
        this.timestamp = new Date(
                Integer.parseInt(times[0]), Integer.parseInt(times[1]), Integer.parseInt(times[2]),
                Integer.parseInt(times[3]), Integer.parseInt(times[4]), Integer.parseInt(times[5])).getTime();
    }

    public OrderInput(String name, String location, int price, long timestamp) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.timestamp = timestamp;
    }


    private String name;

    private String location;

    private int price;

    private long timestamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", date=" + timestamp +
                '}';
    }
}
