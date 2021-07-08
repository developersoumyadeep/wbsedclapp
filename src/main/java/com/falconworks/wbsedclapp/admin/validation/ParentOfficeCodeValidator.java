package com.falconworks.wbsedclapp.admin.validation;

import com.falconworks.wbsedclapp.admin.entities.Office;
import com.falconworks.wbsedclapp.admin.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ParentOfficeCodeValidator implements ConstraintValidator<ValidParentOfficeCode, String> {
   private OfficeService officeService;

   @Autowired
   public ParentOfficeCodeValidator(OfficeService officeService) {
      this.officeService = officeService;
   }

   public void initialize(ValidParentOfficeCode constraint) {
   }

   public boolean isValid(String officeCodeToValidate, ConstraintValidatorContext context) {
      if (officeCodeToValidate == null){
         return true;
      } else {
         Office office = officeService.findByOfficeCode(officeCodeToValidate);
         return (office != null);
      }
   }
}
