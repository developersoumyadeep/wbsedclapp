package com.falconworks.wbsedclapp.admin.validation;

import com.falconworks.wbsedclapp.admin.entities.Employee;
import com.falconworks.wbsedclapp.admin.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ExistingUsernameValidator implements ConstraintValidator<ExistingUsername,String> {

    private EmployeeService employeeService;

    @Autowired
    public ExistingUsernameValidator(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void initialize(ExistingUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(String usernameToValidate, ConstraintValidatorContext constraintValidatorContext) {
        Employee employee= employeeService.getEmployeeByUsername(usernameToValidate);
        return (employee != null);

    }
}
