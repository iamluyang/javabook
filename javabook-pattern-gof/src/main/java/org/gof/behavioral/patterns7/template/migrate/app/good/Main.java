package org.gof.behavioral.patterns7.template.migrate.app.good;

import org.gof.behavioral.patterns7.template.migrate.connector.MySqlConnector;
import org.gof.behavioral.patterns7.template.migrate.connector.OracleConnector;
import org.gof.behavioral.patterns7.template.migrate.context.MigrateEngine;

public class Main {
    public static void main(String[] args) {
        MigrateEngine.migrate(new MySqlConnector(), new OracleConnector());
    }
}
