package online.javabook.gof.behavioral.patterns9.template1.migrate.app;

import online.javabook.gof.behavioral.patterns9.template1.migrate.engine.MigrateEngine1;
import online.javabook.gof.behavioral.patterns9.template1.migrate.template.MySqlConnector;
import online.javabook.gof.behavioral.patterns9.template1.migrate.template.OracleConnector;

public class Main1 {
    public static void main(String[] args) {
        MigrateEngine1.migrate(new MySqlConnector(), new OracleConnector());
    }
}
