package online.javabook.design.gof.behavioral10.visitor.validation.app;

import online.javabook.design.gof.behavioral10.visitor.validation.other.ValidatorResponse;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        ValidatorUtils dataValidator = new ValidatorUtils();
        User user = new User();
        user.setName("xxx");
        user.setAge(44488);
        user.setTrue(false);
        user.setFalse(true);

        List<ValidatorResponse> responses = dataValidator.validate(user);
        for (ValidatorResponse response : responses) {
            System.out.println(response);
        }
    }
}
