package online.javabook.jvm.thread.samethread;

import com.google.gson.Gson;

public class MediumTask implements Runnable {

    @Override
    public void run() {
        Gson gson = new Gson();

        // Serialization
        gson.toJson(1);
        gson.toJson("abcd");
        gson.toJson(new Long(10));
        int[] values = { 1 };
        gson.toJson(values);

        // Deserialization
        int one = gson.fromJson("1", int.class);
        Integer two = gson.fromJson("2", Integer.class);
        Long three = gson.fromJson("3", Long.class);
        Boolean fales = gson.fromJson("false", Boolean.class);
        String str = gson.fromJson("\"abc\"", String.class);
        String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);
    }
}
