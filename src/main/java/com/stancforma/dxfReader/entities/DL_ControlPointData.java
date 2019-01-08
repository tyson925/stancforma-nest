package com.stancforma.dxfReader.entities;

public class DL_ControlPointData {
    /*! X coordinate of the control point. */
    double x;
    /*! Y coordinate of the control point. */
    double y;
    /*! Z coordinate of the control point. */
    double z;
    /*! Weight of control point. */
    double w;

    public DL_ControlPointData(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
}
