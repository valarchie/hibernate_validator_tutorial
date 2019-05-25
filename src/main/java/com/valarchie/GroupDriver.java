package com.valarchie;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;

public class GroupDriver extends Person {

    @Min(
            value = 18,
            message = "驾驶年龄必须超过18！",
            groups = GroupDriverChecks.class
    )
    public int age;

    @AssertTrue(
            message = "司机必须通过驾照测试！",
            groups = GroupDriverChecks.class
    )
    public boolean hasDrivingLicense;

    public GroupDriver(String name) {
        super();
    }

    public void passedDrivingTest(boolean b) {
        hasDrivingLicense = b;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
