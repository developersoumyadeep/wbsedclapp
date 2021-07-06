package com.falconworks.wbsedclapp.admin.validation;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ConstraintComposition(CompositionType.ALL_FALSE)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistingUsernameValidator.class)
public @interface ExistingUsername {
    String message() default "Username does not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
