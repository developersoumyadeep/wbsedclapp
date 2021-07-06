package com.falconworks.wbsedclapp.admin.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy=OfficeCodeExistsValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OfficeCodeExists {
    String message() default "Office with give office code does not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
