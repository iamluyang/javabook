package org.gof.behavioral.patterns7.template.migrate.connector;

import java.util.List;

public interface IConnector {

    List queryData();

    boolean isExist(Object object);

    void createData(Object object);

    void updateData(Object object);
}
