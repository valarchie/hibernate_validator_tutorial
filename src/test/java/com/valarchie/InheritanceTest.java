package com.valarchie;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;


/**
 * 测试继承类的属性校验
 */
public class InheritanceTest {


    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void testInheritance() {

        InheritanceRentalCar inheritanceRentalCar = new InheritanceRentalCar();

        inheritanceRentalCar.setManufacturer(null);
        inheritanceRentalCar.setRentalStation("哈哈哈");

        Set<ConstraintViolation<InheritanceRentalCar>> constraintViolations = validator.validate(inheritanceRentalCar);

        assertEquals(1, constraintViolations.size());

        ConstraintViolation<InheritanceRentalCar> constraintViolation =
                constraintViolations.iterator().next();

        assertEquals(
                "不能为null",
                constraintViolation.getMessage()
        );
        assertEquals(
                "manufacturer",
                constraintViolation.getPropertyPath().toString()
        );
    }


}
