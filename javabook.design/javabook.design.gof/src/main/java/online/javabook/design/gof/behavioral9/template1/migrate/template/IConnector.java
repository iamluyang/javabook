package online.javabook.design.gof.behavioral9.template1.migrate.template;

import java.util.List;

public interface IConnector {

    List<String> queryData();

    boolean isExist(Object object);

    void createData(Object object);

    void updateData(Object object);
}
