package com.stancforma.dxfReader.entities;

public class DL_MTextData {

    /*! X Coordinate of insertion point. */
    double ipx;
    /*! Y Coordinate of insertion point. */
    double ipy;
    /*! Z Coordinate of insertion point. */
    double ipz;
    /*! X Coordinate of X direction vector. */
    double dirx;
    /*! Y Coordinate of X direction vector. */
    double diry;
    /*! Z Coordinate of X direction vector. */
    double dirz;
    /*! Text height */
    double height;
    /*! Width of the text box. */
    double width;
    /**
     * Attachment point.
     *
     * 1 = Top left, 2 = Top center, 3 = Top right,
     * 4 = Middle left, 5 = Middle center, 6 = Middle right,
     * 7 = Bottom left, 8 = Bottom center, 9 = Bottom right
     */
    int attachmentPoint;
    /**
     * Drawing direction.
     *
     * 1 = left to right, 3 = top to bottom, 5 = by style
     */
    int drawingDirection;
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
    /*! Text string. */
    String text;
    /*! Style string. */
    String style;
    /*! Rotation angle. */
    double angle;

    public DL_MTextData(double ipx, double ipy, double ipz, double dirx, double diry, double dirz, double height, double width, int attachmentPoint, int drawingDirection, int lineSpacingStyle, double lineSpacingFactor, String text, String style, double angle) {
        this.ipx = ipx;
        this.ipy = ipy;
        this.ipz = ipz;
        this.dirx = dirx;
        this.diry = diry;
        this.dirz = dirz;
        this.height = height;
        this.width = width;
        this.attachmentPoint = attachmentPoint;
        this.drawingDirection = drawingDirection;
        this.lineSpacingStyle = lineSpacingStyle;
        this.lineSpacingFactor = lineSpacingFactor;
        this.text = text;
        this.style = style;
        this.angle = angle;
    }
}
