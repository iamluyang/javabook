package online.javabook.pattern.gof.behavioral.patterns9.template1.migrate.template;

import java.util.ArrayList;
import java.util.List;

public class SqlServerConnector implements IConnector {
    @Override
    public List<String> queryData() {
        System.out.println("query mysql data......");
        List data = new ArrayList();
        data.add("SqlServer data1");
        data.add("SqlServer data2");
        return data;
    }

    @Override
    public boolean isExist(Object object) {
        System.out.println("exist SqlServer " + object);
        return false;
    }

    @Override
    public void createData(Object object) {
        System.out.println("create SqlServer " + object);
    }

    @Override
    public void updateData(Object object) {
        System.out.println("update SqlServer " + object);
    }
}
