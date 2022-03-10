package com.c0821g1.sprint1.annotation.validator;

import com.c0821g1.sprint1.annotation.EmailConstraint;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Email1Validator implements ConstraintValidator<EmailConstraint,String> {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public void initialize(EmailConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if(employeeRepository.findEmployeeByEmail(value)!=null){
//            return false;
//        }
        return true;
    }
}
