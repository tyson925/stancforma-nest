package com.stancforma.dxf.hatch;

import com.stancforma.dxf.DxfValue;
import com.stancforma.dxf.EnclosingRectangle;

import java.util.Iterator;
import java.util.List;

import static com.stancforma.dxfReader.DL_Codes.M_PI;
import static java.lang.Math.*;
import static java.lang.StrictMath.atan2;
import static java.lang.StrictMath.cos;

public class Loop {

    List<DxfValue> _container;
    Iterator begin;
    Iterator end;

    // polyline
    DxfValue pathType;
    DxfValue hasBulgeFlag;
    DxfValue isClosed;
    DxfValue numOfEdges;
    List<Edge> edges;

    // others
    DxfValue numOfBoundaryObjects;

    boolean isPolyline() {
        return (pathType.asInt() & 0x02) == 0;
    }

    boolean hasBulge() {
        return hasBulgeFlag.asInt() == 0;
    }

    Loop(List<DxfValue> container) {

        this._container = container;
    }

    Loop(List<DxfValue> container, int it) throws Exception {

        this._container =  container;

        //begin = it;

        pathType = container.get(it++);

        if (isPolyline()) { // if path is polyline
            hasBulgeFlag = container.get(it++);
            isClosed = container.get(it++);
            numOfEdges = container.get(it++);

            // fetch points
            for (int vertex = 0; vertex < numOfEdges.asInt(); vertex++) {
                DxfValue x = container.get(it++);
                DxfValue y = container.get(it++);
                DxfValue bulge = null;

                if (hasBulge()) {
                    if (container.get(it).getGroupcode() == 42) {
                        bulge = container.get(it++);
                    } else {
                        bulge = new DxfValue(42, 0.0);
                        container.add(it, bulge);
                    }
                }

               edges.add(Edge.polyline(x, y, bulge));
            }
        } else { // if path is not a polyline

            numOfEdges = container.get(it++);

            DxfValue edgeType;
            DxfValue x;
            DxfValue y;
            DxfValue endx;
            DxfValue endy;
            DxfValue radius;
            DxfValue startAngle;
            DxfValue endAngle;
            DxfValue isCCW;

            for (int edge = 0; edge < numOfEdges.asInt(); edge++) {

                edgeType = container.get(it++);

                switch (edgeType.asInt()) {
                    case 1:// line
                        x = container.get(it++);
                        y = container.get(it++);
                        endx = container.get(it++);
                        endy = container.get(it++);
                        edges.add(Edge.line(edgeType, x, y, endx, endy));
                        break;
                    case 2:// arc
                        x = container.get(it++);
                        y = container.get(it++);
                        radius = container.get(it++);
                        startAngle = container.get(it++);
                        endAngle = container.get(it++);
                        isCCW = container.get(it++);
                        edges.add(Edge.arc(edgeType, x, y, radius, startAngle, endAngle, isCCW));
                        break;
                    default:
                        throw new Exception("Unhandled edge type: " + edgeType.asInt());
                        //break;

                }
            }

        }

        numOfBoundaryObjects = container.get(it++);
        for (int bo = 0; bo < numOfBoundaryObjects.asInt(); bo++) {
            it++;
        }

//        end = it;
    }

    static Loop polyline(List<DxfValue> container, boolean isClosed, boolean hasBulge) {
        Loop loop = new Loop(container);

        loop.pathType = new DxfValue(92, 2);
        loop.hasBulgeFlag = new DxfValue(72, hasBulge);
        loop.isClosed = new DxfValue(73, isClosed);
        loop.numOfEdges = new DxfValue(93, 0);
        loop.numOfBoundaryObjects = new DxfValue(97, 0);


        //loop.begin = container.add(loopsEnd, loop.pathType);
        container.add(loop.hasBulgeFlag);
        container.add(loop.isClosed);
        container.add(loop.numOfEdges);
        //loop.end = container.insert(loopsEnd, loop.numOfBoundaryObjects);

        return loop;
    }



    static Loop standard(List<DxfValue> container) {
        Loop loop = new Loop(container);

        loop.pathType = new DxfValue(92, 0);
        loop.numOfEdges = new DxfValue(93, 0);
        loop.numOfBoundaryObjects = new DxfValue(97, 0);

        //l.begin = container.insert(loopsEnd, l.pathType);
        container.add(loop.numOfEdges);
        //l.end = container.insert(loopsEnd, l.numOfBoundaryObjects);

        return loop;
    }

    public void addLine(double x, double y, double endx, double endy) throws Exception {
        if (isPolyline()) {
            throw new Exception("Loop type is polyline, can't add line.");
        }

        DxfValue edgeType = new DxfValue(72, 1); // edge type: 1 = Line; 2 = Circular arc; 3 = Elliptic arc; 4 = Spline
        DxfValue vx = new DxfValue(10, x);
        DxfValue vy = new DxfValue(20, y);
        DxfValue vex = new DxfValue(11, endx);
        DxfValue vey = new DxfValue(21, endy);
        Edge edge = Edge.line(edgeType, vx, vy, vex, vey);

        edges.add(edge);

        numOfEdges.set(edges.size());

        _container.add(edgeType);
        _container.add(vx);
        _container.add(vy);
        _container.add(vex);
        _container.add(vey);

    }

    public void addArc(double x, double y, double radius, double startAngle, double endAngle, boolean isCCW) throws Exception {
        if (isPolyline()) {
            throw new Exception("Loop type is polyline, can't add arc.");
        }

        DxfValue edgeType = new DxfValue(72, 2); // edge type: 1 = Line; 2 = Circular arc; 3 = Elliptic arc; 4 = Spline
        DxfValue vx = new DxfValue(10, x);
        DxfValue vy = new DxfValue(20, y);
        DxfValue vradius = new DxfValue(40, radius);
        DxfValue vstartAngle = new DxfValue(50, startAngle);
        DxfValue vendAngle = new DxfValue(51, endAngle);
        DxfValue visCCW = new DxfValue(73, isCCW);
        Edge edge = Edge.arc(edgeType, vx, vy, vradius, vstartAngle, vendAngle, visCCW);

        edges.add(edge);

        numOfEdges.set((int) edges.size());

        _container.add(edgeType);
        _container.add(vx);
        _container.add(vy);
        _container.add(vradius);
        _container.add(vstartAngle);
        _container.add(vendAngle);
        _container.add(visCCW);
    }

    public void addPolyedge(double x, double y, double bulge) throws Exception {
        if (!isPolyline()) {
            throw new Exception("Loop type is not polyline.");
        }

        DxfValue vx = new DxfValue(10, x);
        DxfValue vy = new DxfValue(20, y);
        DxfValue vbulge = null;
        if (hasBulge()) {
            vbulge = new DxfValue(42, bulge);
        }
        Edge edge = Edge.polyline(vx, vy, vbulge);

        edges.add(edge);

        numOfEdges.set((int) edges.size());

        _container.add(vx);
        _container.add(vy);
        if (hasBulge()) {
            _container.add(vbulge);
        }
    }


    public static void enclosePolylineArc(double bulge, Edge p1, Edge p2, EnclosingRectangle rect) {

        if (bulge != 0) {
            // p2 - p1
            double dx = p2.getX().asDouble() - p1.getX().asDouble();
            double dy = p2.getY().asDouble() - p1.getY().asDouble();

            // calculate radius
            double d = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)) / 2;
            double s = bulge * d;
            double r = d * (Math.pow(bulge, 2) + 1) / (2 * bulge);

            // angle to arc origin and angle of p1.p2
            boolean isCCW = bulge > 0;
            double alpha = (isCCW ? 1 : -1) * acos(d / r);
            double lineAngle = atan2(dy, dx);

            // arc origin
            double ox = p1.getX().asDouble() + r * cos(lineAngle + alpha);
            double oy = p1.getY().asDouble() + r * sin(lineAngle + alpha);

            // angles from arc origin
            double angleToP1 = atan2(p1.getY().asDouble() - oy, p1.getX().asDouble() - ox);
            double angleToP2 = atan2(p2.getY().asDouble() - oy, p2.getX().asDouble() - ox);

            if (angleToP1 < 0) angleToP1 += 2 * M_PI;
            if (angleToP2 < 0) angleToP2 += 2 * M_PI;

            if (isCCW) {
                if (angleToP1 > angleToP2) {
                    angleToP2 += 2 * M_PI;
                }
            } else {
                if (angleToP1 < angleToP2) {
                    angleToP1 += 2 * M_PI;
                }
            }

            double diff = isCCW ? M_PI / 2 : -M_PI / 2;
            double angle = floor(angleToP1 / (M_PI / 2)) * (M_PI / 2);

            // enclose arc points
            for (int i = 0; i < 4; i++, angle += diff) {
                if ((isCCW && (angle < angleToP2 && angle >= angleToP1)) || (!isCCW && (angle <= angleToP1 && angle > angleToP2))) {
                    double x = ox + r * cos(angle);
                    double y = oy + r * sin(angle);
                    rect.enclose(x, y);
                }
            }

            // also enclose endpoints
            rect.enclose(p1.getX().asDouble(), p1.getY().asDouble());

        } else {
            // if no bulge, only endpoints matter
            rect.enclose(p1.getX().asDouble(), p1.getY().asDouble());
        }
    }

    static void encloseArc(Edge arc, EnclosingRectangle rect) {

        double r = arc.getRadius().asDouble();

        // arc origin
        double ox = arc.getX().asDouble();
        double oy = arc.getY().asDouble();

        // angles from arc origin
        double angleToP1 = arc.getStartAngle().asDouble();
        double angleToP2 = arc.getEndAngle().asDouble();

        if (angleToP1 < 0) angleToP1 += 2 * M_PI;
        if (angleToP2 < 0) angleToP2 += 2 * M_PI;

        boolean isCCW = arc.getIsCCW().asInt() == 0;

        if (isCCW) {
            if (angleToP1 > angleToP2) {
                angleToP2 += 2 * M_PI;
            }
        } else {
            if (angleToP1 < angleToP2) {
                angleToP1 += 2 * M_PI;
            }
        }

        double diff = isCCW ? (M_PI / 2) : (-M_PI / 2);
        double angle = floor(angleToP1 / (M_PI / 2)) * (M_PI / 2);

        // enclose arc points
        for (int i = 0; i < 4; i++, angle += diff) {
            if ((isCCW && (angle < angleToP2 && angle >= angleToP1)) || (!isCCW && (angle <= angleToP1 && angle > angleToP2))) {
                double x = ox + r * cos(angle);
                double y = oy + r * sin(angle);
                rect.enclose(x, y);
            }
        }

        // also enclose endpoints
        rect.enclose(ox + r * cos(angleToP1), oy + r * sin(angleToP1));

    }

    EnclosingRectangle getEnclosingRectangle() {

        EnclosingRectangle rect = new EnclosingRectangle();

        if (isPolyline()) {
            // polyline

            if (hasBulge()) {


                for (int i = 0; i < edges.size() - 2; i++) {
                    enclosePolylineArc(edges.get(i).getBulge().asDouble(), edges.get(i), edges.get(i++), rect);
                }
                Edge lastEdge = edges.get(edges.size() - 1);

                enclosePolylineArc(lastEdge.getBulge().asDouble(), lastEdge, edges.get(0), rect);

            } else {
                // no bulge
                for (Edge edge : edges) {
                    rect.enclose(edge.getX().asDouble(), edge.getY().asDouble());
                }
            }

        } else {
            // not polyline

            for (Edge edge : edges) {
                if (edge.getEdgeType().asInt() == 1) {
                    // line
                    rect.enclose(edge.getX().asDouble(), edge.getY().asDouble());
                    rect.enclose(edge.getEndx().asDouble(), edge.getEndy().asDouble());

                } else if (edge.getEdgeType().asInt() == 2) {
                    // arc
                    encloseArc(edge, rect);
                }
            }
        }

        return rect;
    }
}


