package com.stancforma.dxfReader;


import com.stancforma.dxfReader.entities.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DXFileReader extends Util {


    private version version;

    private String polylineLayer;
    private Double[] vertices;
    private int maxVertices;
    private int vertexIndex;

    private Double[] knots;
    private int maxKnots;
    private int knotIndex;

    private Double[] weights;
    private int weightIndex;

    private Double[] controlPoints;
    private int maxControlPoints;
    private int controlPointIndex;

    private Double[] fitPoints;
    private int maxFitPoints;
    private int fitPointIndex;

    private Double[] leaderVertices;
    private int maxLeaderVertices;
    private int leaderVertexIndex;

    private Boolean firstHatchLoop;
    private DL_HatchEdgeData hatchEdge;
    private List<List<DL_HatchEdgeData>> hatchEdges;

    private String xRecordHandle;
    private Boolean xRecordValues;

    // Only the useful part of the group code
    private String groupCodeTmp;
    // ...same as integer
    private int groupCode;
    // Only the useful part of the group value
    private String groupValue;
    // Current entity type
    private int currentObjectType;
    // Value of the current setting
    //public static final Integer DL_DXF_MAXLINE = 1024;
    private char[] settingValue;
    // Key of the current setting (e.g. "$ACADVER")
    private String settingKey;
    // Stores the group codes
    private Map<Integer, String> values;
    // First call of this method. We initialize all group values in
    //  the first call.
    private boolean firstCall;
    // Attributes of the current entity (layer, color, width, line type)
    private DL_Attributes attrib;
    // library version. hex: 0x20003001 = 2.0.3.1
    private int libVersion;
    // app specific dictionary handle:
    private long appDictionaryHandle;
    // handle of standard text style, referenced by dimstyle:
    private long styleHandleStd;

    //TODO
//    public boolean in(stringstream&stream,
//                      DL_CreationInterface creationInterface) {
//
//        firstCall = true;
//        currentObjectType = DL_UNKNOWN;
//        while (readDxfGroups(stream, creationInterface)) {
//        }
//        return true;
//
//        return false;
//    }

    version getVersion() {

        return version;
    }

    boolean hasValue(int code) {
        return values.containsKey(code);
    }

    int getIntValue(int code, int def) {
        if (!hasValue(code)) {
            return def;
        }
        return toInt(values.get(code));
    }

    int toInt(String str) {
        return Integer.parseInt(str);
    }

    int getInt16Value(int code, int def) {
        if (!hasValue(code)) {
            return def;
        }
        return toInt16(values.get(code));
    }

    //TODO
    int toInt16(String str) {
        return Integer.parseInt(str);
    }

    boolean toBool(String str) {

        return Boolean.parseBoolean(str);
    }

    String getStringValue(int code, String def) {
        if (!hasValue(code)) {
            return def;
        }
        return values.get(code);
    }

    double getRealValue(int code, double def) {
        if (!hasValue(code)) {
            return def;
        }
        return toReal(values.get(code));
    }

    double toReal(String str) {

        return Double.parseDouble(str);
    }


    public boolean processDXFGroup(DL_CreationInterface creationInterface,
                                   int groupCode, String groupValue) {
        if (firstCall) {
            settingValue[0] = '\0';
            firstCall = false;
        }

        // Indicates comment or dxflib version:
        if (groupCode == 999) {
            if (!groupValue.isEmpty()) {
                if (groupValue.substring(0, 6).equals("dxflib")) {
                    libVersion = getLibVersion(groupValue.substring(7));
                }

                addComment(creationInterface, groupValue);
            }
        }// Indicates start of new entity or variable:
        else if (groupCode == 0 || groupCode == 9) {
            // If new entity is encountered, the last one is complete.
            // Prepare default attributes for next entity:
            String layer = getStringValue(8, "0");

            int width;
            // Compatibility with qcad1:
            if (hasValue(39) && !hasValue(370)) {
                width = getIntValue(39, -1);
            }
            // since autocad 2002:
            else if (hasValue(370)) {
                width = getIntValue(370, -1);
            }
            // default to BYLAYER:
            else {
                width = -1;
            }

            int color;
            color = getIntValue(62, 256);
            int color24;
            color24 = getIntValue(420, -1);
            int handle;
            handle = getInt16Value(5, -1);

            String linetype = getStringValue(6, "BYLAYER");

            attrib = new DL_Attributes(layer,                   // layer
                    color,                   // color
                    color24,                 // 24 bit color
                    width,                   // width
                    linetype,                // linetype
                    handle);                 // handle
            attrib.setInPaperSpace((getIntValue(67, 0)) > 0);
            attrib.setLinetypeScale(getRealValue(48, 1.0));
            creationInterface.setAttributes(attrib);

            int elevationGroupCode = 30;
            if (currentObjectType == DL_ENTITY_LWPOLYLINE) {
                // see lwpolyline group codes reference
                elevationGroupCode = 38;
            } else {
                // see polyline group codes reference
                elevationGroupCode = 30;
            }
            creationInterface.setExtrusion(getRealValue(210, 0.0),
                    getRealValue(220, 0.0),
                    getRealValue(230, 1.0),
                    getRealValue(elevationGroupCode, 0.0));


        }
        return true;
    }

//    public static void main(String[] args) {
//        DXFDocument dxfDocument = new
//                DXFDocument("Example");
//
//    }

    public Integer getLibVersion(String str) {
        int[] d = new int[4];
        int idx = 0;
        //char v[4][5];
        String[] v = new String[4];
        int ret = 0;

        for (int i = 0; i < str.length() && idx < 3; ++i) {
            if (str.toCharArray()[i] == '.') {
                d[idx] = i;
                idx++;
            }
        }

        if (idx >= 2) {
            d[3] = str.length();

            v[0] = str.substring(0, d[0]);
            v[1] = str.substring(d[0] + 1, d[1] - d[0] - 1);
            v[2] = str.substring(d[1] + 1, d[2] - d[1] - 1);
            if (idx >= 3) {
                v[3] = str.substring(d[2] + 1, d[3] - d[2] - 1);
            } else {
                v[3] = "0";
            }

            ret = (Integer.parseInt(v[0]) << (3 * 8)) +
                    (Integer.parseInt(v[1]) << (2 * 8)) +
                    (Integer.parseInt(v[2]) << (1 * 8)) +
                    (Integer.parseInt(v[3]) << (0 * 8));

            return ret;
        } else {
            System.err.println("getLibVersion: invalid version number: " + str);
            return 0;
        }
    }

    public void addComment(DL_CreationInterface creationInterface, String comment) {
        //creationInterface.addComment(comment);
    }

    public void addSetting(DL_CreationInterface creationInterface) {
        int c = -1;


        Iterator it = values.keySet().iterator();
        if (it.hasNext()) {
            c = (int) it.next();
        }
//    for (int i=0; i<=380; ++i) {
//        if (values[i][0]!='\0') {
//            c = i;
//            break;
//        }
//    }

        // string
        if (c >= 0 && c <= 9) {
            creationInterface.setVariableString(settingKey, values.get(c), c);

            // backwards compatibility:
            //creationInterface.setVariableString(settingKey, values[c].c_str(), c);

        }
        // vector
        else if (c >= 10 && c <= 39) {
            if (c == 10) {
                creationInterface.setVariableVector(
                        settingKey,
                        getRealValue(c, 0.0),
                        getRealValue(c + 10, 0.0),
                        getRealValue(c + 20, 0.0),
                        c);
            }
        }
        // double
        else if (c >= 40 && c <= 59) {
            creationInterface.setVariableDouble(settingKey, getRealValue(c, 0.0), c);
        }
        // int
        else if (c >= 60 && c <= 99) {
            creationInterface.setVariableInt(settingKey, getIntValue(c, 0), c);
        }
        // misc
        else if (c >= 0) {
            creationInterface.setVariableString(settingKey, getStringValue(c, ""), c);
        }
    }

    /**
     * Adds a layer that was read from the file via the creation interface.
     */
    void addLayer(DL_CreationInterface creationInterface) {
        // correct some invalid attributes for layers:
        attrib = creationInterface.getAttributes();
        if (attrib.getColor() == 256 || attrib.getColor() == 0) {
            attrib.setColor(7);
        }
        if (attrib.getWidth() < 0) {
            attrib.setWidth(1);
        }

        String linetype = attrib.getLinetype().toUpperCase();

        if (linetype.equals("BYLAYER") || linetype.equals("BYBLOCK")) {
            attrib.setLinetype("CONTINUOUS");
        }

        // add layer
        String name = getStringValue(2, "");
        if (name.length() == 0) {
            return;
        }

        creationInterface.addLayer(new DL_LayerData(name, getIntValue(70, 0)));
    }

    /**
     * Adds a linetype that was read from the file via the creation interface.
     */
    void addLinetype(DL_CreationInterface creationInterface) {
        String name = getStringValue(2, "");
        if (name.length() == 0) {
            return;
        }
        int numDashes = getIntValue(73, 0);
        //double dashes[numDashes];

        DL_LinetypeData d = new DL_LinetypeData(
                // name:
                name,
                // description:
                getStringValue(3, ""),
                // flags
                getIntValue(70, 0),
                // number of dashes:
                numDashes,
                // pattern length:
                getRealValue(40, 0.0)
                // pattern:
                //dashes
        );

        if (!name.equals("By Layer") && !name.equals("By Block") && name.equals("BYLAYER") && !name.equals("BYBLOCK")) {
            creationInterface.addLinetype(d);
        }
    }

    /**
     * Handles all dashes in linetype pattern.
     */
    boolean handleLinetypeData(DL_CreationInterface creationInterface) {
        if (groupCode == 49) {
            creationInterface.addLinetypeDash(toReal(groupValue));
            return true;
        }

        return false;
    }

    /**
     * Adds a block that was read from the file via the creation interface.
     */
    void addBlock(DL_CreationInterface creationInterface) {
        String name = getStringValue(2, "");
        if (name.length() == 0) {
            return;
        }

        DL_BlockData d = new DL_BlockData(
                // Name:
                name,
                // flags:
                getIntValue(70, 0),
                // base point:
                getRealValue(10, 0.0),
                getRealValue(20, 0.0),
                getRealValue(30, 0.0));

        creationInterface.addBlock(d);
    }

    /**
     * Ends a block that was read from the file via the creation interface.
     */
    void endBlock(DL_CreationInterface creationInterface) {
        creationInterface.endBlock();
    }

    void addTextStyle(DL_CreationInterface creationInterface) {
        String name = getStringValue(2, "");
        if (name.length() == 0) {
            return;
        }

        DL_StyleData d = new DL_StyleData(
                // name:
                name,
                // flags
                getIntValue(70, 0),
                // fixed text heigth:
                getRealValue(40, 0.0),
                // width factor:
                getRealValue(41, 0.0),
                // oblique angle:
                getRealValue(50, 0.0),
                // text generation flags:
                getIntValue(71, 0),
                // last height used:
                getRealValue(42, 0.0),
                // primart font file:
                getStringValue(3, ""),
                // big font file:
                getStringValue(4, "")
        );
        creationInterface.addTextStyle(d);
    }

    /**
     * Adds a point entity that was read from the file via the creation interface.
     */
    void addPoint(DL_CreationInterface creationInterface) {
        DL_PointData d = new DL_PointData(getRealValue(10, 0.0),
                getRealValue(20, 0.0),
                getRealValue(30, 0.0));
        creationInterface.addPoint(d);
    }


    /**
     * Adds a line entity that was read from the file via the creation interface.
     */
    void addLine(DL_CreationInterface creationInterface) {
        DL_LineData d = new DL_LineData(getRealValue(10, 0.0),
                getRealValue(20, 0.0),
                getRealValue(30, 0.0),
                getRealValue(11, 0.0),
                getRealValue(21, 0.0),
                getRealValue(31, 0.0));

        creationInterface.addLine(d);
    }

    /**
     * Adds an xline entity that was read from the file via the creation interface.
     */
    void addXLine(DL_CreationInterface creationInterface) {
        DL_XLineData d = new DL_XLineData(getRealValue(10, 0.0),
                getRealValue(20, 0.0),
                getRealValue(30, 0.0),
                getRealValue(11, 0.0),
                getRealValue(21, 0.0),
                getRealValue(31, 0.0));

        creationInterface.addXLine(d);
    }

    /**
     * Adds a ray entity that was read from the file via the creation interface.
     */
    void addRay(DL_CreationInterface creationInterface) {
        DL_RayData d = new DL_RayData(getRealValue(10, 0.0),
                getRealValue(20, 0.0),
                getRealValue(30, 0.0),
                getRealValue(11, 0.0),
                getRealValue(21, 0.0),
                getRealValue(31, 0.0));

        creationInterface.addRay(d);
    }


    /**
     * Adds a polyline entity that was read from the file via the creation interface.
     */
    void addPolyline(DL_CreationInterface creationInterface) {
        DL_PolylineData pd = new DL_PolylineData(maxVertices,
                getIntValue(71, 0),
                getIntValue(72, 0),
                getRealValue(38, 0),
                getIntValue(70, 0));
        creationInterface.addPolyline(pd);

        maxVertices = Math.min(maxVertices, vertexIndex + 1);

        if (currentObjectType == DL_ENTITY_LWPOLYLINE) {
            for (int i = 0; i < maxVertices; i++) {
                DL_VertexData d = new DL_VertexData(vertices[i * 4],
                        vertices[i * 4 + 1],
                        vertices[i * 4 + 2],
                        vertices[i * 4 + 3]);

                creationInterface.addVertex(d);
            }
            creationInterface.endEntity();
        }
    }


    /**
     * Adds a polyline vertex entity that was read from the file
     * via the creation interface.
     */
    void addVertex(DL_CreationInterface creationInterface) {

        // vertex defines a face of the mesh if its vertex flags group has the
        // 128 bit set but not the 64 bit. 10, 20, 30 are irrelevant and set to
        // 0 in this case
        if (((getIntValue(70, 0) & 128) == 0) && ((getIntValue(70, 0) & 64) != 0)) {
            return;
        }

        DL_VertexData d = new DL_VertexData(getRealValue(10, 0.0),
                getRealValue(20, 0.0),
                getRealValue(30, 0.0),
                getRealValue(42, 0.0));

        creationInterface.addVertex(d);
    }


    /**
     * Adds a spline entity that was read from the file via the creation interface.
     */
    void addSpline(DL_CreationInterface creationInterface) {
        DL_SplineData sd = new DL_SplineData(getIntValue(71, 3),
                maxKnots,
                maxControlPoints,
                maxFitPoints,
                getIntValue(70, 4));

        sd.setTangentStartX(getRealValue(12, 0.0));
        sd.setTangentStartY(getRealValue(22, 0.0));
        sd.setTangentStartZ(getRealValue(32, 0.0));
        sd.setTangentEndX(getRealValue(13, 0.0));
        sd.setTangentEndY(getRealValue(23, 0.0));
        sd.setTangentEndZ(getRealValue(33, 0.0));

        creationInterface.addSpline(sd);

        int i;
        for (i = 0; i < maxControlPoints; i++) {
            DL_ControlPointData d = new DL_ControlPointData(controlPoints[i * 3],
                    controlPoints[i * 3 + 1],
                    controlPoints[i * 3 + 2],
                    weights[i]);

            creationInterface.addControlPoint(d);
        }
        for (i = 0; i < maxFitPoints; i++) {
            DL_FitPointData d = new DL_FitPointData(fitPoints[i * 3],
                    fitPoints[i * 3 + 1],
                    fitPoints[i * 3 + 2]);

            creationInterface.addFitPoint(d);
        }
        for (i = 0; i < maxKnots; i++) {
            DL_KnotData k = new DL_KnotData(knots[i]);

            creationInterface.addKnot(k);
        }
        creationInterface.endEntity();
    }


    /**
     * Adds an arc entity that was read from the file via the creation interface.
     */
    void addArc(DL_CreationInterface creationInterface) {
        DL_ArcData d = new DL_ArcData(getRealValue(10, 0.0),
                getRealValue(20, 0.0),
                getRealValue(30, 0.0),
                getRealValue(40, 0.0),
                getRealValue(50, 0.0),
                getRealValue(51, 0.0));

        creationInterface.addArc(d);
    }


}
