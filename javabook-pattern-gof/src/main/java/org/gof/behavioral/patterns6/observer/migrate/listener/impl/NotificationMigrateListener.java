package org.gof.behavioral.patterns6.observer.migrate.listener.impl;

import org.gof.behavioral.patterns6.observer.migrate.event.MigrateEvent;
import org.gof.behavioral.patterns6.observer.migrate.listener.api.DefaultMigrateAdapterListener;

public class NotificationMigrateListener extends DefaultMigrateAdapterListener {

    @Override
    public void onStartMigrate(MigrateEvent event) {
        System.out.println("onStartMigrate -> start migrate email notification");
    }

    @Override
    public void onFinishMigrate(MigrateEvent event) {
        System.out.println("onFinishMigrate -> finish migrate email notification");
    }
}
