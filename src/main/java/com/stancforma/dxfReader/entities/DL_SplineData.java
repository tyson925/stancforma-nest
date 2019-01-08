package com.stancforma.dxfReader.entities;

public class DL_SplineData {
    /*! Degree of the spline curve. */
      int degree;

    /*! Number of knots. */
      int nKnots;

    /*! Number of control points. */
      int nControl;

    /*! Number of fit points. */
      int nFit;

    /*! Flags */
    int flags;

    double tangentStartX;
    double tangentStartY;
    double tangentStartZ;
    double tangentEndX;
    double tangentEndY;
    double tangentEndZ;

    public void setTangentStartX(double tangentStartX) {
        this.tangentStartX = tangentStartX;
    }

    public void setTangentStartY(double tangentStartY) {
        this.tangentStartY = tangentStartY;
    }

    public void setTangentStartZ(double tangentStartZ) {
        this.tangentStartZ = tangentStartZ;
    }

    public void setTangentEndX(double tangentEndX) {
        this.tangentEndX = tangentEndX;
    }

    public void setTangentEndY(double tangentEndY) {
        this.tangentEndY = tangentEndY;
    }

    public void setTangentEndZ(double tangentEndZ) {
        this.tangentEndZ = tangentEndZ;
    }

    public DL_SplineData(int degree, int nKnots, int nControl, int nFit, int flags) {
        this.degree = degree;
        this.nKnots = nKnots;
        this.nControl = nControl;
        this.nFit = nFit;
        this.flags = flags;
    }
}
