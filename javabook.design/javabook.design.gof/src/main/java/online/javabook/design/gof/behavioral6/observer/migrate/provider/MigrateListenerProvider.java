package online.javabook.design.gof.behavioral6.observer.migrate.provider;

import online.javabook.design.gof.behavioral9.template1.migrate.template.IConnector;
import online.javabook.design.gof.behavioral6.observer.migrate.event.MigrateEvent;
import online.javabook.design.gof.behavioral6.observer.migrate.listener.api.IMigrateListener;

import java.util.ArrayList;
import java.util.List;

public class MigrateListenerProvider {

    private List<IMigrateListener> listeners = new ArrayList<>();

    public void addListener(IMigrateListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IMigrateListener listener) {
        listeners.remove(listener);
    }

    public void onStartMigrate(IConnector sourceConnector, IConnector targetConnector) {
        for (IMigrateListener listener : listeners){
            try {
                listener.onStartMigrateTask(new MigrateEvent(sourceConnector, targetConnector));
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public void onPrepMigrateRow(IConnector sourceConnector, IConnector targetConnector, String row) {
        for (IMigrateListener listener : listeners){
            try {
                listener.onPrepMigrateRecord(new MigrateEvent(sourceConnector, targetConnector, row));
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public void onPostMigrateRow(IConnector sourceConnector, IConnector targetConnector, String row) {
        for (IMigrateListener listener : listeners){
            try {
                listener.onPostMigrateRecord(new MigrateEvent(sourceConnector, targetConnector, row));
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public void onFailMigrateRow(IConnector sourceConnector, IConnector targetConnector, String row, Exception exception) {
        for (IMigrateListener listener : listeners){
            try {
                listener.onFailMigrateRecord(new MigrateEvent(sourceConnector, targetConnector, row, exception));
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public void onFinishMigrate(IConnector sourceConnector, IConnector targetConnector) {
        for (IMigrateListener listener : listeners){
            try {
                listener.onFinishMigrateTask(new MigrateEvent(sourceConnector, targetConnector));
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

}
