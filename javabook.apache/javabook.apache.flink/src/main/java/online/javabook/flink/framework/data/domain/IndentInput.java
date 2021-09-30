package online.javabook.flink.framework.data.domain;

import java.io.Serializable;
import java.util.Date;

public class IndentInput implements Serializable {

    public IndentInput() {

    }

    public IndentInput(String name, String location, int price, Date timestamp) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.timestamp = timestamp;
    }

    private String name;

    private String location;

    private int price;

    private Date timestamp;

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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Indent{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", date=" + timestamp +
                '}';
    }
}
