package com.stancforma.dxfReader.entities;

public class DL_VertexData {
    /*! X Coordinate of the vertex. */
    double x;
    /*! Y Coordinate of the vertex. */
    double y;
    /*! Z Coordinate of the vertex. */
    double z;
    /*! Bulge of vertex.
     * (The tangent of 1/4 of the arc angle or 0 for lines) */
    double bulge;

    public DL_VertexData(double x, double y, double z, double bulge) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.bulge = bulge;
    }
}
