package online.javabook.design.gof.behavioral6.observer.migrate.listener.impl;

import online.javabook.design.gof.behavioral6.observer.migrate.event.MigrateEvent;
import online.javabook.design.gof.behavioral6.observer.migrate.listener.api.DefaultMigrateAdapterListener;

public class MigrateMessageListener extends DefaultMigrateAdapterListener {

    @Override
    public void onStartMigrateTask(MigrateEvent event) {
        System.out.println("onStartMigrate -> start migrate email notification");
    }

    @Override
    public void onFinishMigrateTask(MigrateEvent event) {
        System.out.println("onFinishMigrate -> finish migrate email notification");
    }
}
