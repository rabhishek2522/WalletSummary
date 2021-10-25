package com.anymind.btc.walletsummary.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateRangeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateRange {

    String message() default "Start date must be before end date";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
