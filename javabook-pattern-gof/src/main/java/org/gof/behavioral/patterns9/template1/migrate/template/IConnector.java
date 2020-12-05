package org.gof.behavioral.patterns9.template1.migrate.template;

import java.util.List;

public interface IConnector {

    List queryData();

    boolean isExist(Object object);

    void createData(Object object);

    void updateData(Object object);
}
