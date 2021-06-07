package online.javabook.gof.behavioral.patterns6.observer.migrate.listener.impl;

import online.javabook.gof.behavioral.patterns6.observer.migrate.event.MigrateEvent;
import online.javabook.gof.behavioral.patterns6.observer.migrate.listener.api.DefaultMigrateAdapterListener;

public class MigrateExceptionListener extends DefaultMigrateAdapterListener {

    @Override
    public void onFailMigrateRecord(MigrateEvent event) {
        System.out.println("onFailMigrateRecord -> migrate row:" + event.getCurrentRow() + " to mysql fail:" + event.getException());
    }
}
