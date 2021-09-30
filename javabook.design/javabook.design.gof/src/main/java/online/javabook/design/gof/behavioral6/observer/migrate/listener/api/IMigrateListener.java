package online.javabook.design.gof.behavioral6.observer.migrate.listener.api;

import online.javabook.design.gof.behavioral6.observer.migrate.event.MigrateEvent;

public interface IMigrateListener {

    void onStartMigrateTask(MigrateEvent event);

    void onPrepMigrateRecord(MigrateEvent event);

    void onPostMigrateRecord(MigrateEvent event);

    void onFailMigrateRecord(MigrateEvent event);

    void onFinishMigrateTask(MigrateEvent event);

}
