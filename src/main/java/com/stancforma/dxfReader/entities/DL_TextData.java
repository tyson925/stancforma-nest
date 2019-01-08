package com.stancforma.dxfReader.entities;

public class DL_TextData {
    /*! X Coordinate of insertion point. */
    double ipx;
    /*! Y Coordinate of insertion point. */
    double ipy;
    /*! Z Coordinate of insertion point. */
    double ipz;

    /*! X Coordinate of alignment point. */
    double apx;
    /*! Y Coordinate of alignment point. */
    double apy;
    /*! Z Coordinate of alignment point. */
    double apz;

    /*! Text height */
    double height;
    /*! Relative X scale factor. */
    double xScaleFactor;
    /*! 0 = default, 2 = Backwards, 4 = Upside down */
    int textGenerationFlags;
    /**
     * Horizontal justification.
     *
     * 0 = Left (default), 1 = Center, 2 = Right,
     * 3 = Aligned, 4 = Middle, 5 = Fit
     * For 3, 4, 5 the vertical alignment has to be 0.
     */
    int hJustification;
    /**
     * Vertical justification.
     *
     * 0 = Baseline (default), 1 = Bottom, 2 = Middle, 3= Top
     */
    int vJustification;
    /*! Text string. */
    String text;
    /*! Style (font). */
    String style;
    /*! Rotation angle of dimension text away from default orientation. */
    double angle;

    public DL_TextData(double ipx, double ipy, double ipz, double apx, double apy, double apz, double height, double xScaleFactor, int textGenerationFlags, int hJustification, int vJustification, String text, String style, double angle) {
        this.ipx = ipx;
        this.ipy = ipy;
        this.ipz = ipz;
        this.apx = apx;
        this.apy = apy;
        this.apz = apz;
        this.height = height;
        this.xScaleFactor = xScaleFactor;
        this.textGenerationFlags = textGenerationFlags;
        this.hJustification = hJustification;
        this.vJustification = vJustification;
        this.text = text;
        this.style = style;
        this.angle = angle;
    }
}
