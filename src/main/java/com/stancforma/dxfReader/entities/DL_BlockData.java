package com.stancforma.dxfReader.entities;

public class DL_BlockData {

    public DL_BlockData(String name, int flags, double bpx, double bpy, double bpz) {
        this.name = name;
        this.flags = flags;
        this.bpx = bpx;
        this.bpy = bpy;
        this.bpz = bpz;
    }

    /** Block name. */
    String name;
    /** Block flags. (not used currently) */
    int flags;
    /** X Coordinate of base point. */
    double bpx;
    /** Y Coordinate of base point. */
    double bpy;
    /** Z Coordinate of base point. */
    double bpz;
}
