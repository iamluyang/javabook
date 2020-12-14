package org.gof.behavioral.patterns10.visitor.validation.other;

public enum HttpStatusCode {

    OK(200, "OK", "The request sent by the client was successful."),
    BadRequest(400, "Bad Request", "The request could not be understood by the server."),
    InternalServerError(500, "Internal Server Error", "The request was unsuccessful because the server encountered an unexpected error."),
    ;

    private final int code;
    private final String name;
    private final String description;

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    private HttpStatusCode(int code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }
}
