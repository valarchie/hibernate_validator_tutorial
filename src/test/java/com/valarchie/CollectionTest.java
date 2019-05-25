package com.valarchie;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

import static junit.framework.TestCase.assertEquals;


/**
 * 通过在类中的集合类型的泛型上打上注解
 * 可自动校验集合当中的类
 *
 */
public class CollectionTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    /**
     * 校验part当中的元素是否为空
     */
    @Test
    public void partsIsNull() {

        Set<String> parts = new HashSet<>();

        parts.add(null);
        parts.add("part A");

        CarWithCollection CarWithCollection = new CarWithCollection();

        CarWithCollection.setParts(parts);

        Set<ConstraintViolation<CarWithCollection>> constraintViolations =
                validator.validate(CarWithCollection);

        assertEquals(1, constraintViolations.size());

        ConstraintViolation<CarWithCollection> constraintViolation =
                constraintViolations.iterator().next();

        assertEquals(
                "不能为null",
                constraintViolation.getMessage()
        );

    }


    /**
     * 检测names当中的元素是否为空串
     */
    @Test
    public void namesIsBlank() {

        List<String> names = new ArrayList<>();

        names.add("name A");
        names.add("");

        CarWithCollection robot = new CarWithCollection();
        robot.setNames(names);

        Set<ConstraintViolation<CarWithCollection>> constraintViolations =
                validator.validate(robot);

        assertEquals(1, constraintViolations.size());

        ConstraintViolation<CarWithCollection> constraintViolation =
                constraintViolations.iterator().next();

        assertEquals(
                "names[1].<list element>不能为空",
                // 指出哪个集合中哪个元素校验失败
                constraintViolation.getPropertyPath().toString() + constraintViolation.getMessage()
        );

    }

}