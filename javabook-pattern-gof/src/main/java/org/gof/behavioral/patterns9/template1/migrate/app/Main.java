package org.gof.behavioral.patterns9.template1.migrate.app;

import org.gof.behavioral.patterns9.template1.migrate.template.MySqlConnector;
import org.gof.behavioral.patterns9.template1.migrate.template.OracleConnector;
import org.gof.behavioral.patterns9.template1.migrate.engine.MigrateEngine;

public class Main {
    public static void main(String[] args) {
        MigrateEngine.migrate(new MySqlConnector(), new OracleConnector());
    }
}
