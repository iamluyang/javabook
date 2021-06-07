package online.javabook.gof.behavioral.patterns9.template1.migrate.template;

import java.util.ArrayList;
import java.util.List;

public class OracleConnector implements IConnector {
    @Override
    public List<String> queryData() {
        System.out.println("query oracle data......");
        List data = new ArrayList();
        data.add("oracle data1");
        data.add("oracle data2");
        return data;
    }

    @Override
    public boolean isExist(Object object) {
        System.out.println("exist oracle " + object);
        return false;
    }

    @Override
    public void createData(Object object) {
        System.out.println("create oracle " + object);
    }

    @Override
    public void updateData(Object object) {
        System.out.println("update oracle " + object);
    }
}
