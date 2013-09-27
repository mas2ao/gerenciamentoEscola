package com.util;

public class CriteriaGroup {
    public String attribute;
    public Object valueFrom;
    public Object valueTo;
    public String type;

    public CriteriaGroup(String type, String attribute, Object valueFrom, Object valueTo) {
        this.attribute = attribute;
        this.valueFrom = valueFrom;
        this.valueTo = valueTo;
        this.type = type;
    }
}
