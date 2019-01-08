package com.stancforma.dxfReader.entities;

import java.util.List;

public class DL_HatchEdgeData {

    /**
     * Default constructor.
     */
    DL_HatchEdgeData() {
        defined = false;
        x1 = 0.0;
        y1 = 0.0;
        x2 = 0.0;
        y2 = 0.0;
    }

    /**
     * Constructor for a line edge.
     * Parameters: see member variables.
     */
    DL_HatchEdgeData(double x1, double y1,
                     double x2, double y2) {
        defined = true;
        type = 1;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }



    /**
     * Constructor for an arc edge.
     * Parameters: see member variables.
     */
    DL_HatchEdgeData(double cx, double cy,
                     double radius,
                     double angle1, double angle2,
                     boolean ccw) {

        defined = true;
                type = 2;
                this.cx = cx;
        this.cy = cy;
        this.radius = radius;
        this.angle1 = angle1;
        this.angle2 = angle2;
        this.ccw = ccw;
    }


    /**
     * Constructor for an ellipse arc edge.
     * Parameters: see member variables.
     */
    DL_HatchEdgeData(double cx, double cy,
                     double mx, double my,
                     double ratio,
                     double angle1, double angle2,
                     boolean ccw) {
        defined = true;
        type = 3;

        this.cx = cx;
        this.cy = cy;

                this.angle1 = angle1;
                        this.angle2 = angle2;
                        this.ccw  = ccw;
                        this.mx = mx;
                        this.my = my;
                        this.ratio = ratio;
    }


    /**
     * Constructor for a spline edge.
     * Parameters: see member variables.
     */
    DL_HatchEdgeData(int degree,
                     boolean rational,
                     boolean periodic,
                      int nKnots,
                      int nControl,
                     int nFit,
                     List<Double> knots,
                     List<List<Double>> controlPoints,
                     List<List<Double>> fitPoints,
                     List<Double> weights,
                     double startTangentX,
                     double startTangentY,
                     double endTangentX,
                     double endTangentY) {
        defined = true;
                type = 4;
        this.degree = degree;
        this.rational = rational;
        this.periodic = periodic;
        this.nKnots = nKnots;
        this.nControl = nControl;
        this.nFit = nFit;
        this.controlPoints = controlPoints;
        this.knots = knots;
        this.weights = weights;
        this.fitPoints = fitPoints;
        this.startTangentX = startTangentX;
        this.startTangentY = startTangentY;
        this.endTangentX = endTangentX;
        this.endTangentY = endTangentY;
    }


    /**
     * Set to true if this edge is fully defined.
     */
    Boolean defined;

    /**
     * Edge type. 1=line, 2=arc, 3=elliptic arc, 4=spline.
     */
    int type;

    // line edges:

    /*! Start point (X). */
    double x1;
    /*! Start point (Y). */
    double y1;
    /*! End point (X). */
    double x2;
    /*! End point (Y). */
    double y2;

    /*! Center point of arc or ellipse arc (X). */
    double cx;
    /*! Center point of arc or ellipse arc (Y). */
    double cy;
    /*! Arc radius. */
    double radius;
    /*! Start angle of arc or ellipse arc. */
    double angle1;
    /*! End angle of arc or ellipse arc. */
    double angle2;
    /*! Counterclockwise flag for arc or ellipse arc. */
    boolean ccw;

    /*! Major axis end point (X). */
    double mx;
    /*! Major axis end point (Y). */
    double my;
    /*! Axis ratio */
    double ratio;


    /*! Spline degree */
    int degree;
    Boolean rational;
    Boolean periodic;
    /*! Number of knots. */
    int nKnots;
    /*! Number of control points. */
    int nControl;
    /*! Number of fit points. */
    int nFit;

    List<List<Double>> controlPoints;
    List<Double> knots;
    List<Double> weights;
    List<List<Double>> fitPoints;

    double startTangentX;
    double startTangentY;

    double endTangentX;
    double endTangentY;

    /** Polyline boundary vertices (x y [bulge])*/
    List<List<Double>> vertices;
    //bool closed;
}
