package online.javabook.pattern.gof.behavioral.patterns6.observer.migrate.listener.api;

import online.javabook.pattern.gof.behavioral.patterns6.observer.migrate.event.MigrateEvent;

public interface IMigrateListener {

    void onStartMigrate(MigrateEvent event);

    void onPrepMigrateRow(MigrateEvent event);

    void onPostMigrateRow(MigrateEvent event);

    void onFailMigrateRow(MigrateEvent event);

    void onFinishMigrate(MigrateEvent event);

}
