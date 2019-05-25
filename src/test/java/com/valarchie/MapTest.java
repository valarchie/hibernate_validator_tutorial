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
 * 校验类当中Map属性其中的键值对
 *
 *
 */
public class MapTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    /**
     * 校验key是否为空
     */
    @Test
    public void fuelConsumptionIsNull() {

        CarWithMap car = new CarWithMap();
        car.setFuelConsumption( null, 1 );

        Set<ConstraintViolation<CarWithMap>> constraintViolations = validator.validate( car );

        assertEquals( 1, constraintViolations.size() );

        ConstraintViolation<CarWithMap> constraintViolation =
                constraintViolations.iterator().next();

        assertEquals(
                "不能为null",
                constraintViolation.getMessage()
        );
        assertEquals(
                "fuelConsumption<K>[].<map key>",
                constraintViolation.getPropertyPath().toString()
        );


    }


    /**
     * 检测value的值是否在设定范围
     */
    @Test
    public void consumptionMax() {

        CarWithMap car = new CarWithMap();
        car.setFuelConsumption( CarWithMap.FuelConsumption.HIGHWAY, 20 );

        Set<ConstraintViolation<CarWithMap>> constraintViolations = validator.validate( car );

        assertEquals( 1, constraintViolations.size() );

        ConstraintViolation<CarWithMap> constraintViolation =
                constraintViolations.iterator().next();
        assertEquals(
                "最大不能超过2",
                constraintViolation.getMessage()
        );
        assertEquals(
                "fuelConsumption[HIGHWAY].<map value>",
                constraintViolation.getPropertyPath().toString()
        );


    }












}
