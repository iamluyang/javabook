package org.gof.behavioral.patterns9.template1.migrate.engine;

import org.gof.behavioral.patterns9.template1.migrate.template.IConnector;

import java.util.List;

public class MigrateEngine {

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
