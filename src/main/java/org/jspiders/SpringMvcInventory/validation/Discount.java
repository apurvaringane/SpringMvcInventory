package org.jspiders.SpringMvcInventory.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)



@Constraint(validatedBy = DiscountValidator.class)
public @interface Discount {
    String message() default "Discount should be less than price";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
