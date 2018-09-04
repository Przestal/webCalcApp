package com.przestal.bean;

public class SubtractValueBean {

    private Double value;

    public SubtractValueBean() {
    }

    public Double getValue() {
        return -value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
