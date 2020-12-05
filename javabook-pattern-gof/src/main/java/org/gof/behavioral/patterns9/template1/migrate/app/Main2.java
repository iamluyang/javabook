package org.gof.behavioral.patterns9.template1.migrate.app;

import org.gof.behavioral.patterns6.observer.migrate.listener.impl.BackupMigrateListener;
import org.gof.behavioral.patterns6.observer.migrate.listener.impl.ExceptionMigrateListener;
import org.gof.behavioral.patterns6.observer.migrate.listener.impl.LoggerMigrateListener;
import org.gof.behavioral.patterns6.observer.migrate.listener.impl.NotificationMigrateListener;
import org.gof.behavioral.patterns9.template1.migrate.engine.MigrateEngine2;
import org.gof.behavioral.patterns9.template1.migrate.template.MySqlConnector;
import org.gof.behavioral.patterns9.template1.migrate.template.OracleConnector;

public class Main2 {
    public static void main(String[] args) {
        MigrateEngine2 migrateEngine = new MigrateEngine2();
        migrateEngine.getProvider().addListener(new LoggerMigrateListener());
        migrateEngine.getProvider().addListener(new BackupMigrateListener());
        migrateEngine.getProvider().addListener(new ExceptionMigrateListener());
        migrateEngine.getProvider().addListener(new NotificationMigrateListener());

        migrateEngine.migrate(new MySqlConnector(), new OracleConnector());
    }
}
