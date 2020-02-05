package edu.mum.cs.cs544.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.mum.cs.cs544.model.TimeSlot;

public class TimeslotValidator implements ConstraintValidator<ValidTime, TimeSlot> {

    @Override
    public boolean isValid(TimeSlot value, ConstraintValidatorContext context) {

        return value.getEndTime().isAfter(value.getBeginTime());

    }

}