package org.gof.behavioral.patterns11.intercepting.http.app;

import org.gof.behavioral.patterns10.visitor.validation.app.annotations.*;
import org.gof.behavioral.patterns10.visitor.validation.other.HttpStatusCode;

public class User {

    @IsNotEmpty(error = "name is empty", code = HttpStatusCode.BadRequest)
    private String name;

    @IsInetAddress(error = "ip is not ip format", code = HttpStatusCode.BadRequest)
    private String ip;

    @IsEmail(error = "email is not email format", code = HttpStatusCode.BadRequest)
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
