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
 * 测试对象属性校验
 *
 * 通过在CarWithField类当中的属性
 * 打上注解进行校验
 *
 *
 */
public class FieldTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    /**
     * 测试manufacturer是否为空
     */
    @Test
    public void manufacturerIsNull() {

        CarWithField car = new CarWithField( null, "DD-AB-123", 4 );

        Set<ConstraintViolation<CarWithField>> constraintViolations =
                validator.validate( car );

        assertEquals( 1, constraintViolations.size() );
        assertEquals( "不能为null", constraintViolations.iterator().next().getMessage());

    }


    /**
     * 测试参数是否在符合范围当中
     */
    @Test
    public void licensePlateTooShort() {

        CarWithField car = new CarWithField("Morris", "D", 4);

        Set<ConstraintViolation<CarWithField>> constraintViolations =
                validator.validate(car);

        assertEquals(1, constraintViolations.size());
        assertEquals(
                "车牌号要为  'D' 要 在2 和 14 之间",
                constraintViolations.iterator().next().getMessage()
        );

    }


    /**
     * 测试座位是否低于设定值
     */
    @Test
    public void seatCountTooLow() {

        CarWithField car = new CarWithField( "Morris", "DD-AB-123", 1 );

        Set<ConstraintViolation<CarWithField>> constraintViolations =
                validator.validate( car );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "最小不能小于2",
                constraintViolations.iterator().next().getMessage()
        );

    }


    /**
     * 检测car实例参数是否通过校验
     */
    @Test
    public void carIsValid() {

        CarWithField car = new CarWithField("Morris", "DD-AB-123", 2);

        Set<ConstraintViolation<CarWithField>> constraintViolations =
                validator.validate(car);

        assertEquals(0, constraintViolations.size());

    }

}