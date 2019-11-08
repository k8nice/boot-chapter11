package com.nice.enumeration;

/**
 * @author ningh
 */

public enum SexEnum {
    MALE(1,"男"),
    FEMALE(2,"女");

    private Integer id;
    private String name;

    SexEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static SexEnum getEnumById(Integer id) {
        for (SexEnum sex : SexEnum.values()) {
            if (sex.getId().equals(id)) {
                return sex;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
