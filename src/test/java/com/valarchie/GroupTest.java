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
 * 按照组进行校验
 */
public class GroupTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    /**
     * 按照特定的组进行校验
     */
    @Test
    public void testGroup() {

        GroupCar groupCar = new GroupCar();

        groupCar.setName(null);

        GroupDriver john = new GroupDriver( "John Doe" );

        john.setAge( 17 );
        john.passedDrivingTest(true);

        groupCar.setDriver(john);
        Set<ConstraintViolation<GroupCar>> constraintViolations = validator.validate( groupCar, GroupDriverChecks.class);

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "驾驶年龄必须超过18！",
                constraintViolations.iterator().next().getMessage()
        );

    }



}
