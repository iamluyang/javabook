package org.gof.behavioral.patterns10.visitor.validation.other;

public class ValidatorResponse {

    private boolean valid = true;

    private String error;

    private String propertyName;

    private Object propertyValue;

    private HttpStatusCode code = HttpStatusCode.OK;

    public ValidatorResponse() {

    }

    public ValidatorResponse(boolean valid, String propertyName, Object propertyValue) {
        this.valid = valid;
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
    }

    public ValidatorResponse(boolean valid, String propertyName, Object propertyValue, String error, HttpStatusCode code) {
        this.valid = valid;
        this.error = error;
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
        this.code = code;
    }

    public boolean isValid() {
        return valid;
    }

    public String getError() {
        return error;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Object getPropertyValue() {
        return propertyValue;
    }

    public HttpStatusCode getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ValidatorResponse{" +
                "valid=" + valid +
                ", error='" + error + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", propertyValue=" + propertyValue +
                ", code=" + code +
                '}';
    }
}
