package com.stancforma.dxf;

public class DxfValue {

    public int getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(int groupcode) {
        this.groupcode = groupcode;
    }

    enum Type {
        UNDEFINED,
        STRING,
        INT,
        DOUBLE,
        VECTOR
    }

    int hexToInt(String value) {
        return Integer.parseInt(value, 16);
    }

    private Type type;

    private int groupcode;
    private String stringValue;
    private int intValue;
    private double vectorValue[];


    public DxfValue() {
        type = Type.UNDEFINED;
        setGroupcode(0);
        stringValue = "";
        intValue = 0;
        vectorValue = new double[3];
    }

    public DxfValue(int groupcode, Boolean value) {
        type = Type.INT;
        this.setGroupcode(groupcode);
        this.intValue = Integer.parseInt(value.toString());
        stringValue = value.toString();
        vectorValue = new double[3];
    }

    public DxfValue(int groupcode, Integer value) {
        type = Type.INT;
        this.setGroupcode(groupcode);
        this.intValue = value;
        stringValue = value.toString();
        vectorValue = new double[3];
    }
    public DxfValue(int groupcode, double value) {
        type = Type.DOUBLE;
        this.setGroupcode(groupcode);
        this.intValue = 0;
        stringValue = ""+value;
        vectorValue = new double[]{value};
    }
    public DxfValue(int groupcode, double[] vectorValue) {
        type = Type.VECTOR;
    this.setGroupcode(groupcode);
    this.vectorValue = vectorValue;
    this.stringValue = "vector";
    this.intValue = 0;
    }

    public DxfValue(int groupcode, double x, double y, double z) {
        type = Type.VECTOR;
        this.setGroupcode(groupcode);
        this.vectorValue = new double[]{ x,y,z };
        stringValue = ("vector");
        intValue = 0;
    }

    public DxfValue(int groupcode, String value, boolean isHex) {
        type = (isHex ? Type.INT : Type.STRING);
        this.setGroupcode(groupcode);
        this.stringValue = value;
        vectorValue = new double[3];
        intValue = (isHex ? hexToInt(value) : 0);
    }

    public DxfValue(int groupcode, String value) {
        type = Type.STRING;
        this.setGroupcode(groupcode);
        this.stringValue = value;
        vectorValue = new double[3];
        intValue = 0;
    }

    public String asString() {
        return stringValue;
    }

    public int asHex() {
        return type == Type.INT ? intValue : hexToInt(stringValue);
    }

    public int asInt() {
        return type == Type.INT ? intValue : Integer.parseInt(stringValue);
    }

    public double asDouble() {
        return type == Type.DOUBLE ? vectorValue[0] : Double.parseDouble(stringValue);
    }

    public double[] asVector() {
        return vectorValue;

    }

    public void set(String value) {
        type = Type.STRING;
        stringValue = value;
        vectorValue = new double[3];
        intValue = 0;
    }

    public void setHex(Integer value) {
        type = Type.INT;
        stringValue = value.toString();
        vectorValue = new double[3];
        intValue = value;
    }

    public void set(Integer value) {
        type = Type.INT;
        stringValue = value.toString();
        vectorValue = new double[3];
        intValue = value;
    }

    public void set(double value) {
        type = Type.DOUBLE;
        vectorValue = new double[]{value};
        stringValue = ""+value;
        intValue = 0;
    }

    public void set(double[] value) {
        type = Type.DOUBLE;
        vectorValue =  value;
        stringValue = "vector";
        intValue = 0;
    }



    void set(double x, double y,double z) {
        set(new double[]{x,y,z});
    }

}
