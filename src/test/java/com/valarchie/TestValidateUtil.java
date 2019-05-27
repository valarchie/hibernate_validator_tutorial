package com.valarchie;

import com.alibaba.fastjson.JSON;
import org.hibernate.validator.HibernateValidator;
import org.junit.Test;
import validate.GetParamBean;
import validate.HibernateValidateUtil;
import validate.PostParamBean;
import validate.ValidateResult;

import javax.validation.constraints.Min;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author archie
 * @Date 2019-05-25-16:23
 */
public class TestValidateUtil {


    /**
     * 测试查询操作的请求参数校验
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Test
    public void testGetParams() throws InstantiationException, IllegalAccessException {

        Map getParamMap = new HashMap();

        getParamMap.put("page_size","99999");
        getParamMap.put("page_num","0");
        getParamMap.put("condition_a", "3");
        getParamMap.put("condition_b","");
        getParamMap.put("condition_c", "");
        getParamMap.put("condition_d", Arrays.asList(1,2));


        ValidateResult<GetParamBean> valid = HibernateValidateUtil.valid(getParamMap, GetParamBean.class);

        if(valid.isError()) {

            System.out.println(valid.getErrorMsg());

        }


    }


    /**
     * 查询更新操作的请求参数校验
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Test
    public void testPostParams() throws InstantiationException, IllegalAccessException {

        Map postParamsMap = new HashMap();

//        postParamsMap.put("post_id", "1");
        postParamsMap.put("post_field_a","");
        postParamsMap.put("post_field_b", "s");
        postParamsMap.put("post_field_c", Arrays.asList(1,2));

        Map subParamsMap = new HashMap();

        subParamsMap.put("sub_id","1");
        subParamsMap.put("sub_field_a","2");

        postParamsMap.put("sub", subParamsMap);

        ValidateResult<PostParamBean> valid = HibernateValidateUtil.valid(postParamsMap, PostParamBean.class);

        if(valid.isError()) {

            System.out.println(valid.getErrorMsg());

        }


    }

























    /**
     * 测试Map注入Bean的时候的异常
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void testMapToObject() throws InvocationTargetException, IllegalAccessException {

        Map map = new HashMap();

        map.put("wheels","a");
        map.put("weight","1.3");
        map.put("manufaturer","Volk");
        map.put("brand", "benz");

        Benz benz = null;

        try {
            benz = JSON.parseObject(JSON.toJSONString(map), Benz.class);
        }catch (Exception e) {

            String message = e.getMessage();

            String field = message.substring(message.indexOf("field : "));

            System.out.println(field + "格式错误！");
        }


    }


}


class Car {

    @Min(-1)
    private Integer wheels;

    private String weight;

    private String manufaturer;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getWheels() {
        return wheels;
    }

    public void setWheels(Integer wheels) {
        this.wheels = wheels;
    }

    public String getManufaturer() {
        return manufaturer;
    }

    public void setManufaturer(String manufaturer) {
        this.manufaturer = manufaturer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "wheels='" + wheels + '\'' +
                ", weight='" + weight + '\'' +
                ", manufaturer='" + manufaturer + '\'' +
                '}';
    }
}



class Benz extends Car {

    private String brand;

    public String getBrand() {

        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    @Override
    public String toString() {
        return "Benz{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
