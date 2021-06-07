package online.javabook.gof.behavioral.patterns6.observer.migrate.listener.impl;

import online.javabook.gof.behavioral.patterns6.observer.migrate.event.MigrateEvent;
import online.javabook.gof.behavioral.patterns6.observer.migrate.listener.api.DefaultMigrateAdapterListener;

public class MigrateLoggerListener extends DefaultMigrateAdapterListener {

    @Override
    public void onStartMigrateTask(MigrateEvent event) {
        System.out.println("onStartMigrate -> log start migrate task");
    }

    @Override
    public void onPrepMigrateRecord(MigrateEvent event) {
        System.out.println("onPrepMigrateRow -> log prep migrate record:" + event.getCurrentRow());
    }

    @Override
    public void onPostMigrateRecord(MigrateEvent event) {
        System.out.println("onPostMigrateRow -> log post migrate record:" + event.getCurrentRow());
    }

    @Override
    public void onFailMigrateRecord(MigrateEvent event) {
        System.out.println("onFailMigrateRow -> log fail migrate record:" + event.getCurrentRow());
    }

    @Override
    public void onFinishMigrateTask(MigrateEvent event) {
        System.out.println("onFinishMigrate -> log finish migrate task");
    }
}
