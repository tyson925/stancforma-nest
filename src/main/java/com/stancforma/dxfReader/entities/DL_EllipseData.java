package com.stancforma.dxfReader.entities;

public class DL_EllipseData {



    /*! X Coordinate of center point. */
    double cx;
    /*! Y Coordinate of center point. */
    double cy;
    /*! Z Coordinate of center point. */
    double cz;

    /*! X coordinate of the endpoint of the major axis. */
    double mx;
    /*! Y coordinate of the endpoint of the major axis. */
    double my;
    /*! Z coordinate of the endpoint of the major axis. */
    double mz;

    /*! Ratio of minor axis to major axis.. */
    double ratio;
    /*! Startangle of ellipse in rad. */
    double angle1;
    /*! Endangle of ellipse in rad. */
    double angle2;

    public DL_EllipseData(double cx, double cy, double cz, double mx, double my, double mz, double ratio, double angle1, double angle2) {
        this.cx = cx;
        this.cy = cy;
        this.cz = cz;
        this.mx = mx;
        this.my = my;
        this.mz = mz;
        this.ratio = ratio;
        this.angle1 = angle1;
        this.angle2 = angle2;
    }
}
