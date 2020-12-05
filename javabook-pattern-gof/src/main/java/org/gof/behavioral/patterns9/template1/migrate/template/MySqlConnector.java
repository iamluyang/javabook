package org.gof.behavioral.patterns9.template1.migrate.template;

import java.util.ArrayList;
import java.util.List;

public class MySqlConnector implements IConnector {
    @Override
    public List queryData() {
        System.out.println("query mysql data......");
        List data = new ArrayList();
        data.add("mysql data1");
        data.add("mysql data2");
        return data;
    }

    @Override
    public boolean isExist(Object object) {
        System.out.println("exist mysql " + object);
        return false;
    }

    @Override
    public void createData(Object object) {
        System.out.println("create mysql " + object);
    }

    @Override
    public void updateData(Object object) {
        System.out.println("update mysql " + object);
    }
}
