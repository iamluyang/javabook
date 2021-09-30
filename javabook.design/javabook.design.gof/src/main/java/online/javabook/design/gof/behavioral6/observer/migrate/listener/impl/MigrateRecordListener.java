package online.javabook.design.gof.behavioral6.observer.migrate.listener.impl;

import online.javabook.design.gof.behavioral6.observer.migrate.event.MigrateEvent;
import online.javabook.design.gof.behavioral6.observer.migrate.listener.api.DefaultMigrateAdapterListener;

public class MigrateRecordListener extends DefaultMigrateAdapterListener {

    @Override
    public void onPrepMigrateRecord(MigrateEvent event) {
        System.out.println("onPrepMigrateRecord -> migrate row:" + event.getCurrentRow() + " to mysql");
    }

    @Override
    public void onPostMigrateRecord(MigrateEvent event) {
        System.out.println("onPostMigrateRow -> migrate row:" + event.getCurrentRow() + " to mysql");
    }
}
