package com.stancforma.dxfReader.entities;

public class DL_PolylineData {


    public DL_PolylineData(int number, int m, int n, double elevation, int flags) {
        this.number = number;
        this.m = m;
        this.n = n;
        this.elevation = elevation;
        this.flags = flags;
    }

    /*! Number of vertices in this polyline. */
    int number;

    /*! Number of vertices in m direction if polyline is a polygon mesh. */
    int m;

    /*! Number of vertices in n direction if polyline is a polygon mesh. */
    int n;

    /*! elevation of the polyline. */
    double elevation;

    /*! Flags */
    int flags;
}
