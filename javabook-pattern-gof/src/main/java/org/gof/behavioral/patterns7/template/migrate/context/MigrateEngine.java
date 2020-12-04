package org.gof.behavioral.patterns7.template.migrate.context;

import org.gof.behavioral.patterns7.template.migrate.connector.IConnector;

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
