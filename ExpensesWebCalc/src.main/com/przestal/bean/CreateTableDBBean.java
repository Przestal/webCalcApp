package com.przestal.bean;

import java.io.Serializable;

public class CreateTableDBBean implements Serializable{


    private String name;
    private int value;
    private int sum;

    public CreateTableDBBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
