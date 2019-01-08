package com.stancforma.dxfReader.entities;

public class DL_InsertData {

    /*! Name of the referred block. */
    String name;
    /*! X Coordinate of insertion point. */
    double ipx;
    /*! Y Coordinate of insertion point. */
    double ipy;
    /*! Z Coordinate of insertion point. */
    double ipz;
    /*! X Scale factor. */
    double sx;
    /*! Y Scale factor. */
    double sy;
    /*! Z Scale factor. */
    double sz;
    /*! Rotation angle in degrees. */
    double angle;
    /*! Number of colums if we insert an array of the block or 1. */
    int cols;
    /*! Number of rows if we insert an array of the block or 1. */
    int rows;
    /*! Values for the spacing between cols. */
    double colSp;
    /*! Values for the spacing between rows. */
    double rowSp;

    public DL_InsertData(String name, double ipx, double ipy, double ipz, double sx, double sy, double sz, double angle, int cols, int rows, double colSp, double rowSp) {
        this.name = name;
        this.ipx = ipx;
        this.ipy = ipy;
        this.ipz = ipz;
        this.sx = sx;
        this.sy = sy;
        this.sz = sz;
        this.angle = angle;
        this.cols = cols;
        this.rows = rows;
        this.colSp = colSp;
        this.rowSp = rowSp;
    }
}
