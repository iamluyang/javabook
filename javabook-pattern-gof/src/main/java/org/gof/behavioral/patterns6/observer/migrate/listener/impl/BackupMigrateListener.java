package org.gof.behavioral.patterns6.observer.migrate.listener.impl;

import org.gof.behavioral.patterns6.observer.migrate.event.MigrateEvent;
import org.gof.behavioral.patterns6.observer.migrate.listener.api.DefaultMigrateAdapterListener;

public class BackupMigrateListener extends DefaultMigrateAdapterListener {

    @Override
    public void onPostMigrateRow(MigrateEvent event) {
        System.out.println("onPostMigrateRow -> backup migrate row:" + event.getCurrentRow() + " to mongodb");
    }
}
