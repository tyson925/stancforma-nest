package com.stancforma.dxfReader.entities;

public class DL_ArcAlignedTextData {

    /*! Text string */
    String text;
    /*! Font name */
    String font;
    /*! Style */
    String style;

    /*! X coordinate of arc center point. */
    double cx;
    /*! Y coordinate of arc center point. */
    double cy;
    /*! Z coordinate of arc center point. */
    double cz;
    /*! Arc radius. */
    double radius;

    /*! Relative X scale factor. */
    double xScaleFactor;
    /*! Text height */
    double height;
    /*! Character spacing */
    double spacing;
    /*! Offset from arc */
    double offset;
    /*! Right offset */
    double rightOffset;
    /*! Left offset */
    double leftOffset;
    /*! Start angle (radians) */
    double startAngle;
    /*! End angle (radians) */
    double endAngle;
    /*! Reversed character order:
     * false: normal
     * true: reversed
     */
    boolean reversedCharacterOrder;
    /*! Direction
     * 1: outward from center
     * 2: inward from center
     */
    int direction;
    /*! Alignment:
     * 1: fit
     * 2: left
     * 3: right
     * 4: center
     */
    int alignment;
    /*! Side
     * 1: convex
     * 2: concave
     */
    int side;
    /*! Bold flag */
    boolean bold;
    /*! Italic flag */
    boolean italic;
    /*! Underline flag */
    boolean underline;
    /*! Character set value. Windows character set identifier. */
    int characerSet;
    /*! Pitch and family value. Windows pitch and character family identifier. */
    int pitch;
    /*! Font type:
     * false: TTF
     * true: SHX
     */
    boolean shxFont;
    /*! Wizard flag */
    boolean wizard;
    /*! Arc handle/ID */
    int arcHandle;
}
