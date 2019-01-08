package com.stancforma.dxfReader.entities;

public class DL_DimOrdinateData {

    /*! X Coordinate of definition point 1. */
    double dpx1;
    /*! Y Coordinate of definition point 1. */
    double dpy1;
    /*! Z Coordinate of definition point 1. */
    double dpz1;

    /*! X Coordinate of definition point 2. */
    double dpx2;
    /*! Y Coordinate of definition point 2. */
    double dpy2;
    /*! Z Coordinate of definition point 2. */
    double dpz2;

    /*! True if the dimension indicates the X-value, false for Y-value */
    boolean xtype;

    public DL_DimOrdinateData(double dpx1, double dpy1, double dpz1, double dpx2, double dpy2, double dpz2, boolean xtype) {
        this.dpx1 = dpx1;
        this.dpy1 = dpy1;
        this.dpz1 = dpz1;
        this.dpx2 = dpx2;
        this.dpy2 = dpy2;
        this.dpz2 = dpz2;
        this.xtype = xtype;
    }
}
