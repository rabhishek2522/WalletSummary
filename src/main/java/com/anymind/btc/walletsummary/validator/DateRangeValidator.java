package com.anymind.btc.walletsummary.validator;

import com.anymind.btc.walletsummary.vo.DateRange;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, DateRange> {

    @Override
    public boolean isValid(DateRange value, ConstraintValidatorContext context) {
        if(null == value.getStartDatetime() || null == value.getEndDatetime()){
            return false;
        }
            return value.getStartDatetime().before(value.getEndDatetime());
    }
}
