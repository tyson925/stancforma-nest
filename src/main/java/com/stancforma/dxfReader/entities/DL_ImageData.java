package com.stancforma.dxfReader.entities;

public class DL_ImageData {

    /*! Reference to the image file
        (unique, used to refer to the image def object). */
    String ref;
    /*! X Coordinate of insertion point. */
    double ipx;
    /*! Y Coordinate of insertion point. */
    double ipy;
    /*! Z Coordinate of insertion point. */
    double ipz;
    /*! X Coordinate of u vector along bottom of image. */
    double ux;
    /*! Y Coordinate of u vector along bottom of image. */
    double uy;
    /*! Z Coordinate of u vector along bottom of image. */
    double uz;
    /*! X Coordinate of v vector along left side of image. */
    double vx;
    /*! Y Coordinate of v vector along left side of image. */
    double vy;
    /*! Z Coordinate of v vector along left side of image. */
    double vz;
    /*! Width of image in pixel. */
    int width;
    /*! Height of image in pixel. */
    int height;
    /*! Brightness (0..100, default = 50). */
    int brightness;
    /*! Contrast (0..100, default = 50). */
    int contrast;
    /*! Fade (0..100, default = 0). */
    int fade;

    public DL_ImageData(String ref, double ipx, double ipy, double ipz, double ux, double uy, double uz, double vx, double vy, double vz, int width, int height, int brightness, int contrast, int fade) {
        this.ref = ref;
        this.ipx = ipx;
        this.ipy = ipy;
        this.ipz = ipz;
        this.ux = ux;
        this.uy = uy;
        this.uz = uz;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.width = width;
        this.height = height;
        this.brightness = brightness;
        this.contrast = contrast;
        this.fade = fade;
    }
}
