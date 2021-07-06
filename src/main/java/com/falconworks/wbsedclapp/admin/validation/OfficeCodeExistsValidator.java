package com.falconworks.wbsedclapp.admin.validation;

import com.falconworks.wbsedclapp.admin.entities.Office;
import com.falconworks.wbsedclapp.admin.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class OfficeCodeExistsValidator implements ConstraintValidator<OfficeCodeExists, String> {


    private OfficeService officeService;

    @Autowired
    public OfficeCodeExistsValidator(OfficeService officeService) {
        this.officeService = officeService;
    }

    @Override
    public void initialize(OfficeCodeExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String officeCodeToValidate, ConstraintValidatorContext constraintValidatorContext) {
        Office office = officeService.findByOfficeCode(officeCodeToValidate);
        return (office != null);
    }
}
