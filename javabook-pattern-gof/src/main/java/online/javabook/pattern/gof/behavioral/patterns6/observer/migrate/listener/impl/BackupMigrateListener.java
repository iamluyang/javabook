package online.javabook.pattern.gof.behavioral.patterns6.observer.migrate.listener.impl;

import online.javabook.pattern.gof.behavioral.patterns6.observer.migrate.event.MigrateEvent;
import online.javabook.pattern.gof.behavioral.patterns6.observer.migrate.listener.api.DefaultMigrateAdapterListener;

public class BackupMigrateListener extends DefaultMigrateAdapterListener {

    @Override
    public void onPostMigrateRow(MigrateEvent event) {
        System.out.println("onPostMigrateRow -> backup migrate row:" + event.getCurrentRow() + " to mongodb");
    }
}
