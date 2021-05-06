package online.javabook.pattern.gof.behavioral.patterns6.observer.migrate.provider;

import online.javabook.pattern.gof.behavioral.patterns6.observer.migrate.event.MigrateEvent;
import online.javabook.pattern.gof.behavioral.patterns6.observer.migrate.listener.api.IMigrateListener;
import online.javabook.pattern.gof.behavioral.patterns9.template1.migrate.template.IConnector;

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
                listener.onStartMigrate(new MigrateEvent(sourceConnector, targetConnector));
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public void onPrepMigrateRow(IConnector sourceConnector, IConnector targetConnector, String row) {
        for (IMigrateListener listener : listeners){
            try {
                listener.onPrepMigrateRow(new MigrateEvent(sourceConnector, targetConnector, row));
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public void onPostMigrateRow(IConnector sourceConnector, IConnector targetConnector, String row) {
        for (IMigrateListener listener : listeners){
            try {
                listener.onPostMigrateRow(new MigrateEvent(sourceConnector, targetConnector, row));
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public void onFailMigrateRow(IConnector sourceConnector, IConnector targetConnector, String row, Exception exception) {
        for (IMigrateListener listener : listeners){
            try {
                listener.onFailMigrateRow(new MigrateEvent(sourceConnector, targetConnector, row, exception));
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public void onFinishMigrate(IConnector sourceConnector, IConnector targetConnector) {
        for (IMigrateListener listener : listeners){
            try {
                listener.onFinishMigrate(new MigrateEvent(sourceConnector, targetConnector));
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

}
