package com.stancforma.dxfReader.entities;

public class DL_DimLinearData {
    /*! X Coordinate of Extension point 1. */
    double dpx1;
    /*! Y Coordinate of Extension point 1. */
    double dpy1;
    /*! Z Coordinate of Extension point 1. */
    double dpz1;

    /*! X Coordinate of Extension point 2. */
    double dpx2;
    /*! Y Coordinate of Extension point 2. */
    double dpy2;
    /*! Z Coordinate of Extension point 2. */
    double dpz2;

    /*! Rotation angle (angle of dimension line) in degrees. */
    double angle;
    /*! Oblique angle in degrees. */
    double oblique;

    public DL_DimLinearData(double dpx1, double dpy1, double dpz1, double dpx2, double dpy2, double dpz2, double angle, double oblique) {
        this.dpx1 = dpx1;
        this.dpy1 = dpy1;
        this.dpz1 = dpz1;
        this.dpx2 = dpx2;
        this.dpy2 = dpy2;
        this.dpz2 = dpz2;
        this.angle = angle;
        this.oblique = oblique;
    }
}
