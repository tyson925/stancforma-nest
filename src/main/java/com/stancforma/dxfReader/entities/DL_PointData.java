package com.stancforma.dxfReader.entities;

public class DL_PointData {
    public DL_PointData(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /*! X Coordinate of the point. */
    double x;
    /*! Y Coordinate of the point. */
    double y;
    /*! Z Coordinate of the point. */
    double z;
}
