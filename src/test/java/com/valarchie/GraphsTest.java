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
 * 测试对象中嵌套对象校验
 */
public class GraphsTest {




    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }




    @Test
    public void testGraphs() {

        GraphsCar car = new GraphsCar();

        Person driver = new Person();

        driver.setName(null);

        car.setDriver(driver);

        Set<ConstraintViolation<GraphsCar>> constraintViolations = validator.validate( car );

        assertEquals( 1, constraintViolations.size() );

        ConstraintViolation<GraphsCar> constraintViolation =
                constraintViolations.iterator().next();

        assertEquals(
                "不能为null",
                constraintViolation.getMessage()
        );

    }

}
