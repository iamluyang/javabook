package online.javabook.design.gof.behavioral9.template1.migrate.app;

import online.javabook.design.gof.behavioral9.template1.migrate.engine.MigrateEngine1;
import online.javabook.design.gof.behavioral9.template1.migrate.template.MySqlConnector;
import online.javabook.design.gof.behavioral9.template1.migrate.template.OracleConnector;

public class Main1 {
    public static void main(String[] args) {
        MigrateEngine1.migrate(new MySqlConnector(), new OracleConnector());
    }
}
