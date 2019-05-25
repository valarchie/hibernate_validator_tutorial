package com.valarchie;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;


/**
 * 测试串联多级校验
 *
 * 通过在类属性上打上多个注解进行校验
 *
 *
 */
public class CascadeTest {


    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    /**
     * 测试串联多级注解
     */
    @Test
    public void testCascade() {

        CascadedCar cascadedCar = new CascadedCar();

        List<Person> passengers = new ArrayList<>();;

        Person p1 = new Person();

        p1.setName("A");

        Person p2 = new Person();

        p2.setName(null);

        passengers.add(p1);
        passengers.add(p2);

        cascadedCar.setPassengers(passengers);

        Set<ConstraintViolation<CascadedCar>> constraintViolations = validator.validate( cascadedCar );

        assertEquals( 1, constraintViolations.size() );

        ConstraintViolation<CascadedCar> constraintViolation =
                constraintViolations.iterator().next();

        assertEquals(
                "不能为null",
                constraintViolation.getMessage()
        );
        assertEquals(
                "passengers[1].name",
                constraintViolation.getPropertyPath().toString()
        );

    }


}
