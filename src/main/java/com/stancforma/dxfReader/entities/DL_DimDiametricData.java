package com.stancforma.dxfReader.entities;

public class DL_DimDiametricData {
    /*! X Coordinate of definition point (DXF 15). */
    double dpx;
    /*! Y Coordinate of definition point (DXF 25). */
    double dpy;
    /*! Z Coordinate of definition point (DXF 35). */
    double dpz;

    /*! Leader length */
    double leader;

    public DL_DimDiametricData(double dpx, double dpy, double dpz, double leader) {
        this.dpx = dpx;
        this.dpy = dpy;
        this.dpz = dpz;
        this.leader = leader;
    }
}
