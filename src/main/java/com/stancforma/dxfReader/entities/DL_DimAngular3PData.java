package com.stancforma.dxfReader.entities;

public class DL_DimAngular3PData {

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

    /*! X Coordinate of definition point 3. */
    double dpx3;
    /*! Y Coordinate of definition point 3. */
    double dpy3;
    /*! Z Coordinate of definition point 3. */
    double dpz3;

    public DL_DimAngular3PData(double dpx1, double dpy1, double dpz1, double dpx2, double dpy2, double dpz2, double dpx3, double dpy3, double dpz3) {
        this.dpx1 = dpx1;
        this.dpy1 = dpy1;
        this.dpz1 = dpz1;
        this.dpx2 = dpx2;
        this.dpy2 = dpy2;
        this.dpz2 = dpz2;
        this.dpx3 = dpx3;
        this.dpy3 = dpy3;
        this.dpz3 = dpz3;
    }
}
