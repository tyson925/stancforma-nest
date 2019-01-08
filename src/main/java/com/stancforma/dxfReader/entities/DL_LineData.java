package com.stancforma.dxfReader.entities;

public class DL_LineData {


    /*! X Start coordinate of the point. */
    double x1;
    /*! Y Start coordinate of the point. */
    double y1;
    /*! Z Start coordinate of the point. */
    double z1;

    /*! X End coordinate of the point. */
    double x2;
    /*! Y End coordinate of the point. */
    double y2;
    /*! Z End coordinate of the point. */
    double z2;

    public DL_LineData(double x1, double y1, double z1, double x2, double y2, double z2) {
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
    }
}
