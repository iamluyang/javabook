package online.javabook.pattern.gof.behavioral.patterns6.observer.migrate.listener.impl;

import online.javabook.pattern.gof.behavioral.patterns6.observer.migrate.event.MigrateEvent;
import online.javabook.pattern.gof.behavioral.patterns6.observer.migrate.listener.api.DefaultMigrateAdapterListener;

public class ExceptionMigrateListener extends DefaultMigrateAdapterListener {

    @Override
    public void onFailMigrateRow(MigrateEvent event) {
        System.out.println("onFailMigrateRow -> handler exception:" + event.getException());
    }
}
