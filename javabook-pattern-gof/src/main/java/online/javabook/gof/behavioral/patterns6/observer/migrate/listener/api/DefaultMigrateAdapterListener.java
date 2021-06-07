package online.javabook.gof.behavioral.patterns6.observer.migrate.listener.api;

import online.javabook.gof.behavioral.patterns6.observer.migrate.event.MigrateEvent;

public class DefaultMigrateAdapterListener implements IMigrateListener {

    @Override
    public void onStartMigrateTask(MigrateEvent event) {

    }

    @Override
    public void onPrepMigrateRecord(MigrateEvent event) {

    }

    @Override
    public void onPostMigrateRecord(MigrateEvent event) {

    }

    @Override
    public void onFailMigrateRecord(MigrateEvent event) {

    }

    @Override
    public void onFinishMigrateTask(MigrateEvent event) {

    }
}
