package com.falconworks.wbsedclapp.admin.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy= ParentOfficeCodeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidParentOfficeCode {
    String message() default "Parent office code must be null or a valid office code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
