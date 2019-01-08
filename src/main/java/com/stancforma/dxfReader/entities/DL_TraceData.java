package com.stancforma.dxfReader.entities;

public class DL_TraceData {

    public DL_TraceData() {
        thickness = 0.0;
        x = new double[4];
        y = new double[4];
        z = new double[4];
        for (int i=0; i<4; i++) {
            x[i] = 0.0;
            y[i] = 0.0;
            z[i] = 0.0;
        }
    }

    /**
     * Constructor.
     * Parameters: see member variables.
     */
    DL_TraceData(double sx1, double sy1, double sz1,
                 double sx2, double sy2, double sz2,
                 double sx3, double sy3, double sz3,
                 double sx4, double sy4, double sz4,
                 double sthickness) {

        x = new double[4];
        y = new double[4];
        z = new double[4];
        thickness = sthickness;

        x[0] = sx1;
        y[0] = sy1;
        z[0] = sz1;

        x[1] = sx2;
        y[1] = sy2;
        z[1] = sz2;

        x[2] = sx3;
        y[2] = sy3;
        z[2] = sz3;

        x[3] = sx4;
        y[3] = sy4;
        z[3] = sz4;
    }

    /*! Thickness */
    double thickness;

    /*! Points */
    double x[];
    double y[];
    double z[];
}
