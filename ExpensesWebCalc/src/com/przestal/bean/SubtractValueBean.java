package com.przestal.bean;

public class SubtractValueBean {

    private String value;

    public SubtractValueBean() {
    }

    public String getValue() {
        return "-"+value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
