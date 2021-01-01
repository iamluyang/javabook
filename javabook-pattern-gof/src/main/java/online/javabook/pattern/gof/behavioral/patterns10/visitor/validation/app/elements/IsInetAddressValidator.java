package online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.elements;

import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.annotations.IsInetAddress;
import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.visitor.IValidatorAccept;
import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.visitor.ValidatorVisitor;
import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.other.ValidatorResponse;
import org.apache.commons.validator.routines.InetAddressValidator;

import java.lang.annotation.Annotation;

public class IsInetAddressValidator implements IValidator, IValidatorAccept {
    @Override
    public ValidatorResponse isVerify(Annotation annotation, String propertyName, Object propertyValue) {
        boolean isValid = propertyValue!=null && InetAddressValidator.getInstance().isValid((String)propertyValue);

        IsInetAddress isInetAddressAnnotation = (IsInetAddress) annotation;
        return isValid?
                new ValidatorResponse(true, propertyName, propertyValue) :
                new ValidatorResponse(false, propertyName, propertyValue, isInetAddressAnnotation.error(), isInetAddressAnnotation.code());
    }

    @Override
    public ValidatorResponse Accept(ValidatorVisitor validatorVisitor, Annotation attribute, String propertyName, Object propertyValue) {
        return validatorVisitor.Visit(this, attribute, propertyName, propertyValue);
    }
}
