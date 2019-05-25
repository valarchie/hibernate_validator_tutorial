package com.valarchie;

import javax.validation.constraints.*;

public class ValidatePattern {


    /**
     * 判断是否为 true
     */
    @AssertTrue
    private String field1;

    /**
     * 判断是否为 false
     */
    @AssertFalse
    private String field2;


    /**
     * 判断是否小于这个最大实数   inclusive = true的话  包含等于关系
     */
    @DecimalMax(value="333", inclusive=true)
    private String field3;


    /**
     * 判断是否大于这个最大实数   inclusive = true的话  包含等于关系
     */
    @DecimalMin(value="333", inclusive=false)
    private String field4;


    /**
     * 判断数字类型   integer整数位数，fraction小数位数
     */
    @Digits(integer=3, fraction=3)
    private String field5;


    /**
     * 校验邮箱地址
     */
    @Email
    private String field6;


    /**
     * 校验未来时间
     */
    @Future
    private String field7;


    /**
     * 校验值是否小于等于这个值
     */
    @Max(value=100)
    private String field8;



    /**
     * 校验值是否大于等于这个值
     */
    @Min(value=100)
    private String field9;


    /**
     * 判断值是否为空串
     */
    @NotEmpty
    private String field10;


    /**
     * 判断值不能为空
     */
    @NotNull
    private String field11;


    /**
     * 判断值是否为负
     */
    @Negative
    private String field12;


    /**
     * 判断值是否为0，或者负数。
     */
    @NegativeOrZero
    private String field13;


    /**
     * 判断值是否为空
     */
    @Null
    private String field14;


    /**
     * 判断是否为过去的时间
     */
    @Past
    private String field15;


    /**
     * 判断是否是当前或者过去的时间
     */
    @PastOrPresent
    private String field16;


    /**
     * 判断是否符合正则表达式   flag代表模式   具体模式要查阅文档
     */
    @Pattern(regexp="dd",flags = Pattern.Flag.CASE_INSENSITIVE)
    private String field17;


    /**
     * 检测是否为正数
     */
    @Positive
    private String field18;


    /**
     * 检测是否为正数或者0
     */
    @PositiveOrZero
    private String field19;


    /**
     * 校验大小   可校验字符串、数组、Map
     */
    @Size(min=1, max=3)
    private String field20;







}
