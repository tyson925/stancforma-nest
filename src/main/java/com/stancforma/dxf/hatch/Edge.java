package com.stancforma.dxf.hatch;

import com.stancforma.dxf.DxfValue;

public class Edge {
    private DxfValue edgeType;

    public DxfValue getEdgeType() {
        return edgeType;
    }

    public DxfValue getX() {
        return x;
    }

    public DxfValue getY() {
        return y;
    }

    public DxfValue getBulge() {
        return bulge;
    }

    public DxfValue getEndx() {
        return endx;
    }

    public DxfValue getEndy() {
        return endy;
    }

    public DxfValue getRadius() {
        return radius;
    }

    public DxfValue getStartAngle() {
        return startAngle;
    }

    public DxfValue getEndAngle() {
        return endAngle;
    }

    public DxfValue getIsCCW() {
        return isCCW;
    }

    // polyline
    private DxfValue x;
    private DxfValue y;
    private DxfValue bulge;

    // Line
    private DxfValue endx;
    private DxfValue endy;

    // Arc
    private DxfValue radius;
    private DxfValue startAngle;
    private DxfValue endAngle;
    private DxfValue isCCW;

    static Edge polyline(DxfValue x, DxfValue y, DxfValue bulge) {
        Edge e = new Edge();
        e.edgeType = null;
        e.x = x;
        e.y = y;
        e.bulge = bulge;
        return e;
    }

    static Edge line(DxfValue edgeType, DxfValue x, DxfValue y, DxfValue endx, DxfValue endy) {
        Edge e = new Edge();
        e.edgeType = edgeType;
        e.x = x;
        e.y = y;
        e.endx = endx;
        e.endy = endy;
        return e;
    }

    static Edge arc(DxfValue edgeType, DxfValue x, DxfValue y, DxfValue radius, DxfValue startAngle, DxfValue endAngle, DxfValue isCCW) {
        Edge e = new Edge();
        e.edgeType = edgeType;
        e.x = x;
        e.y = y;
        e.radius = radius;
        e.startAngle = startAngle;
        e.endAngle = endAngle;
        e.isCCW = isCCW;
        return e;
    }

}
