package org.gof.behavioral.patterns9.template1.migrate.app;

import org.gof.behavioral.patterns9.template1.migrate.template.MySqlConnector;
import org.gof.behavioral.patterns9.template1.migrate.template.OracleConnector;
import org.gof.behavioral.patterns9.template1.migrate.engine.MigrateEngine1;

public class Main1 {
    public static void main(String[] args) {
        MigrateEngine1.migrate(new MySqlConnector(), new OracleConnector());
    }
}
