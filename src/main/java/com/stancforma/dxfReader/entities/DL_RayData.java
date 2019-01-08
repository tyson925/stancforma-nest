package com.stancforma.dxfReader.entities;

public class DL_RayData {


    /*! X base point. */
    double bx;
    /*! Y base point. */
    double by;
    /*! Z base point. */
    double bz;

    /*! X direction vector. */
    double dx;
    /*! Y direction vector. */
    double dy;
    /*! Z direction vector. */
    double dz;

    public DL_RayData(double bx, double by, double bz, double dx, double dy, double dz) {
        this.bx = bx;
        this.by = by;
        this.bz = bz;
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
    }
}
