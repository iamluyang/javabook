package online.javabook.design.gof.behavioral9.template1.migrate.engine;

import online.javabook.design.gof.behavioral9.template1.migrate.template.IConnector;
import online.javabook.design.gof.behavioral6.observer.migrate.provider.MigrateListenerProvider;

import java.util.List;

public class MigrateEngine2 {

    private MigrateListenerProvider provider = new MigrateListenerProvider();

    public MigrateListenerProvider getProvider() {
        return provider;
    }

    public void migrate(IConnector sourceConnector, IConnector targetConnector) {

        // onStartMigrate
        provider.onStartMigrate(sourceConnector, targetConnector);

        List<String> sourceDatas = sourceConnector.queryData();
        for (String sourceData : sourceDatas){

            try {
                // onPrepMigrateRow
                provider.onPrepMigrateRow(sourceConnector, targetConnector, sourceData);

                // -----------------------------------------------------------
                if(!targetConnector.isExist(sourceData)) {
                    provider.onFinishMigrate(sourceConnector, targetConnector);
                    targetConnector.createData(sourceData);
                }else{
                    targetConnector.updateData(sourceData);
                }
                // -----------------------------------------------------------

                // onPostMigrateRow
                provider.onPostMigrateRow(sourceConnector, targetConnector, sourceData);

            }catch (Exception e){

                // onFailMigrateRow
                provider.onFailMigrateRow(sourceConnector, targetConnector, sourceData, e);
            }

        }

        // onFinishMigrate
        provider.onFinishMigrate(sourceConnector, targetConnector);
    }
}
