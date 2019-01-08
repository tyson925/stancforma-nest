package com.stancforma.dxfReader;

import com.stancforma.dxfReader.entities.*;

public abstract class DL_CreationInterface {
    protected DL_Attributes attributes;
    protected DL_Extrusion extrusion;

    DL_CreationInterface() {
        extrusion = new DL_Extrusion();
    }

    DL_TraceData DL_SolidData;


    /**
     * 3dface Data.
     */
    DL_TraceData DL_3dFaceData;


    /**
     * Called for every code / value tuple of the DXF file. The complete DXF file
     * contents can be handled by the implemetation of this function.
     */
    abstract void processCodeValuePair(int groupCode, String groupValue);

    /**
     * Called when a section (entity, table entry, etc.) is finished.
     */
    abstract void endSection();

    /**
     * Called for every layer.
     */
    abstract void addLayer(DL_LayerData data);

    /**
     * Called for every linetype.
     */
    abstract void addLinetype(DL_LinetypeData data);

    /**
     * Called for every dash in linetype pattern
     */
    abstract void addLinetypeDash(double length);

    /**
     * Called for every block. Note: all entities added after this
     * command go into this block until endBlock() is called.
     *
     * @see endBlock()
     */
    abstract void addBlock(DL_BlockData data);

    /**
     * Called to end the current block
     */
    abstract void endBlock();

    /**
     * Called for every text style
     */
    abstract void addTextStyle(DL_StyleData data);

    /**
     * Called for every point
     */
    abstract void addPoint(DL_PointData data);

    /**
     * Called for every line
     */
    abstract void addLine(DL_LineData data);

    /**
     * Called for every xline
     */
    abstract void addXLine(DL_XLineData data);

    /**
     * Called for every ray
     */
    abstract void addRay(DL_RayData data);

    /**
     * Called for every arc
     */
    abstract void addArc(DL_ArcData data);

    /**
     * Called for every circle
     */
    abstract void addCircle(DL_CircleData data);

    /**
     * Called for every ellipse
     */
    abstract void addEllipse(DL_EllipseData data);

    /**
     * Called for every polyline start
     */
    abstract void addPolyline(DL_PolylineData data);

    /**
     * Called for every polyline vertex
     */
    abstract void addVertex(DL_VertexData data);

    /**
     * Called for every spline
     */
    abstract void addSpline(DL_SplineData data);

    /**
     * Called for every spline control point
     */
    abstract void addControlPoint(DL_ControlPointData data);

    /**
     * Called for every spline fit point
     */
    abstract void addFitPoint(DL_FitPointData data);

    /**
     * Called for every spline knot value
     */
    abstract void addKnot(DL_KnotData data);

    /**
     * Called for every insert.
     */
    abstract void addInsert(DL_InsertData data);

    /**
     * Called for every trace start
     */
    abstract void addTrace(DL_TraceData data);

    /**
     * Called for every 3dface start
     */
    abstract void add3dFace(DL_TraceData data);

    /**
     * Called for every solid start
     */
    abstract void addSolid(DL_TraceData data);


    /**
     * Called for every multi Text entity.
     */
    abstract void addMText(DL_MTextData data);

    /**
     * Called for additional text chunks for MTEXT entities.
     * The chunks come at 250 character in size each. Note that
     * those chunks come <b>before</b> the actual MTEXT entity.
     */
    abstract void addMTextChunk(String text);

    /**
     * Called for every text entity.
     */
    abstract void addText(DL_TextData data);

    /**
     * Called for every arc aligned text entity.
     */
    abstract void addArcAlignedText(DL_ArcAlignedTextData data);

    /**
     * Called for every block Attribute entity.
     */
    abstract void addAttribute(DL_AttributeData data);

    /**
     * Called for every aligned dimension entity.
     */
    abstract void addDimAlign(DL_DimensionData data,
                              DL_DimAlignedData edata);

    /**
     * Called for every linear or rotated dimension entity.
     */
    abstract void addDimLinear(DL_DimensionData data,
                               DL_DimLinearData edata);

    /**
     * Called for every radial dimension entity.
     */
    abstract void addDimRadial(DL_DimensionData data,
                               DL_DimRadialData edata);

    /**
     * Called for every diametric dimension entity.
     */
    abstract void addDimDiametric(DL_DimensionData data,
                                  DL_DimDiametricData edata);

    /**
     * Called for every angular dimension (2 lines version) entity.
     */
    abstract void addDimAngular(DL_DimensionData data,
                                DL_DimAngularData edata);

    /**
     * Called for every angular dimension (3 points version) entity.
     */
    abstract void addDimAngular3P(DL_DimensionData data,
                                  DL_DimAngular3PData edata);

    /**
     * Called for every ordinate dimension entity.
     */
    abstract void addDimOrdinate(DL_DimensionData data,
                                 DL_DimOrdinateData edata);

    /**
     * Called for every leader start.
     */
    abstract void addLeader(DL_LeaderData data);

    /**
     * Called for every leader vertex
     */
    abstract void addLeaderVertex(DL_LeaderVertexData data);

    /**
     * Called for every hatch entity.
     */
    abstract void addHatch(DL_HatchData data);

    /**
     * Called for every image entity.
     */
    abstract void addImage(DL_ImageData data);

    /**
     * Called for every image definition.
     */
    abstract void linkImage(DL_ImageDefData data);

    /**
     * Called for every hatch loop.
     */
    abstract void addHatchLoop(DL_HatchLoopData data);

    /**
     * Called for every hatch edge entity.
     */
    abstract void addHatchEdge(DL_HatchEdgeData data);

    /**
     * Called for every XRecord with the given handle.
     */
    abstract void addXRecord(String handle);

    /**
     * Called for XRecords of type string.
     */
    abstract void addXRecordString(int code, String value);

    /**
     * Called for XRecords of type double.
     */
    abstract void addXRecordReal(int code, double value);

    /**
     * Called for XRecords of type int.
     */
    abstract void addXRecordInt(int code, int value);

    /**
     * Called for XRecords of type boolean.
     */
    abstract void addXRecordBool(int code, boolean value);

    /**
     * Called for every beginning of an XData section of the given application.
     */
    abstract void addXDataApp(String appId);

    /**
     * Called for XData tuples.
     */
    abstract void addXDataString(int code, String value);

    /**
     * Called for XData tuples.
     */
    abstract void addXDataReal(int code, double value);

    /**
     * Called for XData tuples.
     */
    abstract void addXDataInt(int code, int value);

    /**
     * Called for dictionary objects.
     */
    abstract void addDictionary(DL_DictionaryData data);

    /**
     * Called for dictionary entries.
     */
    abstract void addDictionaryEntry(DL_DictionaryEntryData data);

    /**
     * Called after an entity has been completed.
     */
    abstract void endEntity();

    /**
     * Called for every comment in the DXF file (code 999).
     */
    abstract void addComment(String comment);

    /**
     * Called for every vector variable in the DXF file (e.g. "$EXTMIN").
     */
    abstract void setVariableVector(String key, double v1, double v2, double v3, int code);

    /**
     * Called for every string variable in the DXF file (e.g. "$ACADVER").
     */
    abstract void setVariableString(String key, String value, int code);

    /**
     * Called for every int variable in the DXF file (e.g. "$ACADMAINTVER").
     */
    abstract void setVariableInt(String key, int value, int code);

    /**
     * Called for every double variable in the DXF file (e.g. "$DIMEXO").
     */
    abstract void setVariableDouble(String key, double value, int code);



    abstract void setVariableVector(char key, double v1, double v2, double v3, int code);

    abstract void setVariableString(char key, char value, int code);

    abstract void setVariableInt(char key, int value, int code);

    abstract void setVariableDouble(char key, double value, int code);

    abstract void processCodeValuePair(int groupCode, char groupValue);

    abstract void addComment(char comment);

    abstract void addMTextChunk(char text);


    /**
     * Called when a SEQEND occurs (when a POLYLINE or ATTRIB is done)
     */
    abstract void endSequence();

    /**
     * Sets the current attributes for entities.
     */
    void setAttributes(DL_Attributes attrib) {
        attributes = attrib;
    }

    /**
     * @return the current attributes used for new entities.
     */
    DL_Attributes getAttributes() {
        return attributes;
    }

    /**
     * Sets the current attributes for entities.
     */
    void setExtrusion(double dx, double dy, double dz, double elevation) {
        extrusion.setDirection(dx, dy, dz);
        extrusion.setElevation(elevation);
    }

    /**
     * @return the current attributes used for new entities.
     */
    DL_Extrusion getExtrusion() {
        return extrusion;
    }
}