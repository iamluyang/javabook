package org.gof.behavioral.patterns6.observer.migrate.listener.impl;

import org.gof.behavioral.patterns6.observer.migrate.event.MigrateEvent;
import org.gof.behavioral.patterns6.observer.migrate.listener.api.DefaultMigrateAdapterListener;

public class ExceptionMigrateListener extends DefaultMigrateAdapterListener {

    @Override
    public void onFailMigrateRow(MigrateEvent event) {
        System.out.println("onFailMigrateRow -> handler exception:" + event.getException());
    }
}
