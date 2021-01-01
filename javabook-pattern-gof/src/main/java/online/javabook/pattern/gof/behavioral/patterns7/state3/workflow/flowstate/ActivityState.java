package online.javabook.pattern.gof.behavioral.patterns7.state3.workflow.flowstate;

public enum  ActivityState {
    Initialize,
    Committing,
    Committed,
    Canceled,
    Approved,
    Reviewing
}
