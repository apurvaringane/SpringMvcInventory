package org.jspiders.SpringMvcInventory.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.Positive;
import org.jspiders.SpringMvcInventory.domain.Item;

public class DiscountValidator implements ConstraintValidator<Discount,Double> {


      Item item=new  Item();

    @Override
    public boolean isValid(Double aDouble, ConstraintValidatorContext constraintValidatorContext) {
        if (item.getDiscount()>item.getPrice()){
            return true;
        }
        return false;
    }
}
