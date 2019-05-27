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
 * 通过在类的getter方法上
 * 打上校验注解
 * 进行校验
 */
public class GetterTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * 校验manufacturer是否为空
     */
    @Test
    public void manufacturerIsNull() {

        CarWithGetter carWithGetter = new CarWithGetter( null, true);

        Set<ConstraintViolation<CarWithGetter>> constraintViolations =
                validator.validate( carWithGetter );

        assertEquals(1, constraintViolations.size());

        System.out.println(constraintViolations.iterator().next().getPropertyPath());

        assertEquals("不能为null", constraintViolations.iterator().next().getMessage());

    }


    /**
     * 校验registed是否为true
     */
    @Test
    public void registeredIsTrue() {
        CarWithGetter carOnSetGet = new CarWithGetter( "manufactruer A", false);

        Set<ConstraintViolation<CarWithGetter>> constraintViolations =
                validator.validate( carOnSetGet );

        assertEquals( 1, constraintViolations.size() );
        assertEquals( "只能为true", constraintViolations.iterator().next().getMessage() );
    }




}
