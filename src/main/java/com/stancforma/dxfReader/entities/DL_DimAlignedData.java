package com.stancforma.dxfReader.entities;

public class DL_DimAlignedData {

    /*! X Coordinate of Extension point 1. */
    double epx1;
    /*! Y Coordinate of Extension point 1. */
    double epy1;
    /*! Z Coordinate of Extension point 1. */
    double epz1;

    /*! X Coordinate of Extension point 2. */
    double epx2;
    /*! Y Coordinate of Extension point 2. */
    double epy2;
    /*! Z Coordinate of Extension point 2. */
    double epz2;

    public DL_DimAlignedData(double epx1, double epy1, double epz1, double epx2, double epy2, double epz2) {
        this.epx1 = epx1;
        this.epy1 = epy1;
        this.epz1 = epz1;
        this.epx2 = epx2;
        this.epy2 = epy2;
        this.epz2 = epz2;
    }
}
