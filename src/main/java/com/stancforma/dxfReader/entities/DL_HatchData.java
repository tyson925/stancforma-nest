package com.stancforma.dxfReader.entities;

public class DL_HatchData {


    public DL_HatchData() {
    }

    public DL_HatchData(int numLoops, boolean solid, double scale, double angle, String pattern, double originX, double originY) {
        this.numLoops = numLoops;
        this.solid = solid;
        this.scale = scale;
        this.angle = angle;
        this.pattern = pattern;
        this.originX = originX;
        this.originY = originY;
    }

    /*! Number of boundary paths (loops). */
    int numLoops;
    /*! Solid fill flag (true=solid, false=pattern). */
    boolean solid;
    /*! Pattern scale or spacing */
    double scale;
    /*! Pattern angle in degrees */
    double angle;
    /*! Pattern name. */
    String pattern;
    /*! Pattern origin */
    double originX;
    double originY;
}
