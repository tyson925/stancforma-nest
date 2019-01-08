package com.stancforma.dxfReader.entities;

public class DL_DimensionData {

    public DL_DimensionData(double dpx, double dpy, double dpz, double mpx, double mpy, double mpz, int type, int attachmentPoint, int lineSpacingStyle, double lineSpacingFactor, String text, String style, double angle, double linearFactor, double dimScale) {
        this.dpx = dpx;
        this.dpy = dpy;
        this.dpz = dpz;
        this.mpx = mpx;
        this.mpy = mpy;
        this.mpz = mpz;
        this.type = type;
        this.attachmentPoint = attachmentPoint;
        this.lineSpacingStyle = lineSpacingStyle;
        this.lineSpacingFactor = lineSpacingFactor;
        this.text = text;
        this.style = style;
        this.angle = angle;
        this.linearFactor = linearFactor;
        this.dimScale = dimScale;
    }

    /*! X Coordinate of definition point. */
    double dpx;
    /*! Y Coordinate of definition point. */
    double dpy;
    /*! Z Coordinate of definition point. */
    double dpz;
    /*! X Coordinate of middle point of the text. */
    double mpx;
    /*! Y Coordinate of middle point of the text. */
    double mpy;
    /*! Z Coordinate of middle point of the text. */
    double mpz;
    /**
     * Dimension type.
     *
     * 0   Rotated, horizontal, or vertical
     * 1   Aligned
     * 2   Angular
     * 3   Diametric
     * 4   Radius
     * 5   Angular 3-point
     * 6   Ordinate
     * 64  Ordinate type. This is a bit value (bit 7)
     *     used only with integer value 6. If set,
     *     ordinate is X-type; if not set, ordinate is
     *     Y-type
     * 128 This is a bit value (bit 8) added to the
     *     other group 70 values if the dimension text
     *     has been positioned at a user-defined
     *    location rather than at the default location
     */
    int type;
    /**
     * Attachment point.
     *
     * 1 = Top left, 2 = Top center, 3 = Top right,
     * 4 = Middle left, 5 = Middle center, 6 = Middle right,
     * 7 = Bottom left, 8 = Bottom center, 9 = Bottom right,
     */
    int attachmentPoint;
    /**
     * Line spacing style.
     *
     * 1 = at least, 2 = exact
     */
    int lineSpacingStyle;
    /**
     * Line spacing factor. 0.25 .. 4.0
     */
    double lineSpacingFactor;
    /**
     * Text string.
     *
     * Text string entered explicitly by user or null
     * or "<>" for the actual measurement or " " (one blank space).
     * for supressing the text.
     */
    String text;
    /*! Dimension style (font name). */
    String style;
    /**
     * Rotation angle of dimension text away from
     * default orientation.
     */
    double angle;
    /**
     * Linear factor style override.
     */
    double linearFactor;
    /**
     * Dimension scale (dimscale) style override.
     */
    double dimScale;
}
