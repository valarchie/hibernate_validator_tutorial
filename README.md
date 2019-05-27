

### Hibernate Validator 简明教程



##### 新建一个Maven工程


1. 首先添加以下依赖

```
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.0.16.Final</version>
</dependency>
```

2. 在需要自定义错误信息的话，需要EL表达式相关的依赖


```
<dependency>
    <groupId>org.glassfish</groupId>
    <artifactId>javax.el</artifactId>
    <version>3.0.1-b09</version>
</dependency>
```




3. 需要添加运行时依赖


Tomcat运行时依赖
```
<dependency>
  <groupId>org.apache.tomcat</groupId>
  <artifactId>tomcat-el-api</artifactId>
  <version>8.5.24</version>
  <scope>provided</scope>
</dependency>
<dependency>
  <groupId>org.apache.tomcat</groupId>
  <artifactId>tomcat-jasper-el</artifactId>
  <version>8.5.24</version>
  <scope>provided</scope>
</dependency>
```
或者

CDI
```
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator-cdi</artifactId>
    <version>6.0.16.Final</version>
</dependency>
```

##### 添加好以上依赖之后，环境就准备好了



##### Hibernate工作流程


##### 1. 先获取校验器实例

```
ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
Validator validator = factory.getValidator();
```
- validator从ValidatorFactory中获取，它是==线程安全==的，所以它可以保存在一个==静态域==当中，并多线程的校验不同的模型。 validate()返回的是约束违反的一个集合，可遍历获取结果。

##### 2. 调用校验器的validate方法

```
 // 校验某个实体
 Set<ConstraintViolation<GraphsCar>> constraintViolations = validator.validate( instance );
 
```


```
// 校验某个实体里面的一个属性
validator.validateProperty(car, "fieldA");
// 校验某个实体里面的一个属性 包括值
validator.validateValue( Car.class, "fieldA", null);
```


- 如果校验成功的话，validate返回的是一个空集合。
- 类的静态域是不能校验的。
- 不建议配置重复校验。（如注解在field,又注解在getter方法中）


##### 3. 校验注解可应用的地方


- 注解在filed上。
- 注解在getter方法。
- 注解在集合中的泛型参数。
- 注解在Map中的key或者value。
- 注解在父类的属性。（可继承）。
- 多级注解校验。
- 嵌套对象校验。
- 组策略校验。


##### 4. 校验器方法


- getMessage()<br>
  获取校验信息<br>
eg. "参数不能为空"


- getMessageTemplate()<br>
  错误信息模板<br>
eg. "{…${username} NotNull.message}"

- getRootBean()<br>
获取校验根实体<br>
eg. car(最外层的校验实体)


- getRootBeanClass()<br>
校验实体类对象<br>
eg. Car.class

- getLeafBean()<br>
获取所校验的属性的上层bean。<br>
eg. 


- getPropertyPath()<br>
获取属性的路径<br>
eg.
打印所校验属性的路径。例如类当中的集合属性中的第二个元素。

- getInvalidValue()<br>
获取错误的值<br>
eg.
null
- getConstraintDescriptor()<br>
约束描述<br>
eg.
descriptor for @NotNull




##### 5. 校验规则


```
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

```

还有一些比较特殊的校验规则就不列举进来了。


##### 5. 具体demo请看代码。

