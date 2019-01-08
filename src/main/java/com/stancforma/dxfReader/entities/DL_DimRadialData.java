package com.stancforma.dxfReader.entities;

public class DL_DimRadialData {

    /*! X Coordinate of definition point. */
    double dpx;
    /*! Y Coordinate of definition point. */
    double dpy;
    /*! Z Coordinate of definition point. */
    double dpz;

    /*! Leader length */
    double leader;

    public DL_DimRadialData(double dpx, double dpy, double dpz, double leader) {
        this.dpx = dpx;
        this.dpy = dpy;
        this.dpz = dpz;
        this.leader = leader;
    }
}
