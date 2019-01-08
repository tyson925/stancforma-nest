package com.stancforma.dxfReader.entities;

public class DL_ImageDefData {

    /*! Reference to the image file
        (unique, used to refer to the image def object). */
    String ref;

    /*! Image file */
    String file;

    public DL_ImageDefData(String ref, String file) {
        this.ref = ref;
        this.file = file;
    }
}
