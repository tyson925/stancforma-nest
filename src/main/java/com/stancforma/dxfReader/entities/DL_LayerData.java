package com.stancforma.dxfReader.entities;

public class DL_LayerData {
    /** Layer name. */
    String name;
    /** Layer flags. (1 = frozen, 2 = frozen by default, 4 = locked) */
    int flags;
    /** Layer is off */
    boolean off;

    public DL_LayerData(String name, int flags) {
        this.name = name;
        this.flags = flags;
        this.off = false;
    }

    public DL_LayerData(String name, int flags, boolean off) {
        this.name = name;
        this.flags = flags;
        this.off = off;
    }
}
