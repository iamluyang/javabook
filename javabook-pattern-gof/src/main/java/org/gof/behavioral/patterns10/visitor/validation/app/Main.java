package org.gof.behavioral.patterns10.visitor.validation.app;

import org.gof.behavioral.patterns10.visitor.validation.other.ValidatorResponse;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        ValidatorUtils dataValidator = new ValidatorUtils();
        User user = new User();
        user.setName("xxx");
        user.setAge(44488);
        user.setTrue(true);
        user.setFalse(false);
        user.setEmail("xxx@email.com");
        user.setIp("255.22.22.22");

        List<ValidatorResponse> responses = dataValidator.validate(user);
        for (ValidatorResponse response : responses) {
            System.out.println(response);
        }
    }
}
