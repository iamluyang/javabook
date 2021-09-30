package online.javabook.design.gof.behavioral10.visitor.validation.app;

import online.javabook.design.gof.behavioral10.visitor.validation.app.annotations.IsFalse;
import online.javabook.design.gof.behavioral10.visitor.validation.app.annotations.IsNotEmpty;
import online.javabook.design.gof.behavioral10.visitor.validation.app.annotations.IsNumber;
import online.javabook.design.gof.behavioral10.visitor.validation.app.annotations.IsTrue;

public class User {

    @IsNotEmpty(error = "name is empty")
    private String name;

    @IsTrue(error = "isTrue is not true")
    private boolean isTrue;

    @IsFalse(error = "isFalse is not false")
    private boolean isFalse;

    @IsNumber(min = 1, max = 200, error = "age is not valid")
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
