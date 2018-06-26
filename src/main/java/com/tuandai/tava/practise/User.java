package com.tuandai.tava.practise;

/**
 * @author Jef
 */
public class User {

    /** 姓名 */
    private String name;
    /** 年龄 */
    private int age;
    /** 是否已婚 */
    private boolean married;

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
