package org.gof.behavioral.patterns6.observer.migrate.listener.impl;

import org.gof.behavioral.patterns6.observer.migrate.event.MigrateEvent;
import org.gof.behavioral.patterns6.observer.migrate.listener.api.DefaultMigrateAdapterListener;

public class LoggerMigrateListener extends DefaultMigrateAdapterListener {

    @Override
    public void onStartMigrate(MigrateEvent event) {
        System.out.println("onStartMigrate -> log start migrate");
    }

    @Override
    public void onPrepMigrateRow(MigrateEvent event) {
        System.out.println("onPrepMigrateRow -> log prep migrate row:" + event.getCurrentRow());
    }

    @Override
    public void onPostMigrateRow(MigrateEvent event) {
        System.out.println("onPostMigrateRow -> log post migrate row:" + event.getCurrentRow());
    }

    @Override
    public void onFailMigrateRow(MigrateEvent event) {
        System.out.println("onFailMigrateRow -> log fail migrate row:" + event.getCurrentRow());
    }

    @Override
    public void onFinishMigrate(MigrateEvent event) {
        System.out.println("onFinishMigrate -> log finish migrate");
    }
}
