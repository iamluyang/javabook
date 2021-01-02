package online.javabook.pattern.gof.behavioral.patterns11.intercepting.http.app;

import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.annotations.*;
import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.other.HttpStatusCode;

public class User {

    @IsNotEmpty(error = "name is empty", code = HttpStatusCode.BadRequest)
    private String name;

    @IsTrue(error = "isTrue is not true", code = HttpStatusCode.BadRequest)
    private boolean isTrue;

    @IsFalse(error = "isFalse is not false", code = HttpStatusCode.BadRequest)
    private boolean isFalse;

    @IsNumber(min = 1, max = 200, error = "age is not valid", code = HttpStatusCode.BadRequest)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public boolean isFalse() {
        return isFalse;
    }

    public void setFalse(boolean aFalse) {
        isFalse = aFalse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
