package online.javabook.gof.behavioral.patterns9.template1.migrate.app;

import online.javabook.gof.behavioral.patterns6.observer.migrate.listener.impl.*;
import online.javabook.gof.behavioral.patterns9.template1.migrate.engine.MigrateEngine2;
import online.javabook.gof.behavioral.patterns9.template1.migrate.template.MySqlConnector;
import online.javabook.gof.behavioral.patterns9.template1.migrate.template.OracleConnector;

public class Main2 {
    public static void main(String[] args) {
        MigrateEngine2 migrateEngine = new MigrateEngine2();
        migrateEngine.getProvider().addListener(new MigrateTaskListener());
        migrateEngine.getProvider().addListener(new MigrateRecordListener());
        migrateEngine.getProvider().addListener(new MigrateMessageListener());
        migrateEngine.getProvider().addListener(new MigrateExceptionListener());
        migrateEngine.getProvider().addListener(new MigrateLoggerListener());

        migrateEngine.migrate(new MySqlConnector(), new OracleConnector());
    }
}
