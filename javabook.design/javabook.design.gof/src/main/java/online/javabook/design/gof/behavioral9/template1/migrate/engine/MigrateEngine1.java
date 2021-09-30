package online.javabook.design.gof.behavioral9.template1.migrate.engine;

import online.javabook.design.gof.behavioral9.template1.migrate.template.IConnector;

import java.util.List;

public class MigrateEngine1 {

    public static void migrate(IConnector sourceConnector, IConnector targetConnector) {

        List sourceDatas = sourceConnector.queryData();
        for (Object sourceData : sourceDatas){
            if(!targetConnector.isExist(sourceData)) {
                targetConnector.createData(sourceData);
            }else{
                targetConnector.updateData(sourceData);
            }
        }
    }
}
