package validate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * 基于hibernate-validate封装的一个工具类
 *
 * @Author archie
 * @Date 2019-05-25-14:20
 */
public class HibernateValidateUtil {

    private static Validator validator;

    static {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }


    public static <T> ValidateResult<T> valid(Map inputData, Class<T> clazz) throws IllegalAccessException, InstantiationException {

        ValidateResult<T> result = new ValidateResult<>();

        T instance = clazz.newInstance();

        Map errorMsg = new HashMap();
        result.setErrorMsgMap(errorMsg);
        result.setError(true);

        String s = JSON.toJSONString(inputData);

        try {

            instance = JSON.parseObject(JSON.toJSONString(inputData), clazz);

        } catch (Exception e) {

//            e.printStackTrace();

            String message = e.getMessage();

            int fieldNameIndex = message.indexOf("field : ");

            if (fieldNameIndex > 0) {
                errorMsg.put(message.substring(fieldNameIndex), "格式错误！");
            }else {
                errorMsg.put("JSON", "解析错误！");
            }

            result.setErrorMsgMap(errorMsg);
            result.setError(true);

            return result;

        }


        Set<ConstraintViolation<T>> constraintViolations = validator.validate(instance);

        // 没有校验错误的话
        if(constraintViolations.size() == 0) {

            result.setParamData(instance);
            result.setError(false);

            return result;

        }else {

            for (ConstraintViolation violation : constraintViolations) {

                errorMsg.put(violation.getPropertyPath(),violation.getMessage());

            }

            result.setError(true);
            result.setErrorMsgMap(errorMsg);

            return result;

        }


    }


}
