package com.c0821g1.sprint1.annotation;

import com.c0821g1.sprint1.annotation.validator.Email1Validator;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = Email1Validator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstraint {
    String message() default  "Email đã tồn tại";
    Class<?>[] groups() default {};
    Class<?extends Payload>[] payload() default {};

}
