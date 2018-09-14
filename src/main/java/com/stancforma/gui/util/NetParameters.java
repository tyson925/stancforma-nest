package com.stancforma.gui.util;

public class NetParameters {
    private double minAreaSize = 0;
    private double parameter2 = 0;

    public NetParameters() {
    }

    public NetParameters(double minAreaSize, double parameter2) {
        this.minAreaSize = minAreaSize;
        this.parameter2 = parameter2;
    }

    public double getMinAreaSize() {
        return minAreaSize;
    }

    public void setMinAreaSize(double minAreaSize) {
        this.minAreaSize = minAreaSize;
    }

    public double getParameter2() {
        return parameter2;
    }

    public void setParameter2(double parameter2) {
        this.parameter2 = parameter2;
    }

    @Override
    public String toString() {
        return "NetParameters{" +
                "minAreaSize=" + minAreaSize +
                ", parameter2=" + parameter2 +
                '}';
    }
}
