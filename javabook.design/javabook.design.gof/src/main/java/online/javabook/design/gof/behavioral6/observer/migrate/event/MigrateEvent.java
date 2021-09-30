package online.javabook.design.gof.behavioral6.observer.migrate.event;

import online.javabook.design.gof.behavioral9.template1.migrate.template.IConnector;

public class MigrateEvent {

    private IConnector sourceConnector;

    private IConnector targetConnector;

    private String currentRow;

    private Exception exception;

    public MigrateEvent(IConnector sourceConnector, IConnector targetConnector) {
        this.sourceConnector = sourceConnector;
        this.targetConnector = targetConnector;
    }

    public MigrateEvent(IConnector sourceConnector, IConnector targetConnector, String currentRow) {
        this.sourceConnector = sourceConnector;
        this.targetConnector = targetConnector;
        this.currentRow = currentRow;
    }

    public MigrateEvent(IConnector sourceConnector, IConnector targetConnector, String currentRow, Exception exception) {
        this.sourceConnector = sourceConnector;
        this.targetConnector = targetConnector;
        this.currentRow = currentRow;
        this.exception = exception;
    }
    public IConnector getSourceConnector() {
        return sourceConnector;
    }

    public IConnector getTargetConnector() {
        return targetConnector;
    }

    public String getCurrentRow() {
        return currentRow;
    }

    public Exception getException() {
        return exception;
    }
}
