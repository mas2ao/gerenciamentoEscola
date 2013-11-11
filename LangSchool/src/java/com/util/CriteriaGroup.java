package com.util;

import javax.faces.event.ActionEvent;

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

    public CriteriaGroup(String eq, int turmId, int id, ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
