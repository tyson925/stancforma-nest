package com.stancforma.dxfReader.entities;

public class DL_Attributes {
    private String layer;
    private int color;
    private int color24;
    private int width;
    private String linetype;
    private double linetypeScale;
    private int handle;

    // DXF code 67 (true: entity in paper space, false: entity in model space (default):
    private boolean inPaperSpace;

    /**
     * Default constructor.
     */
   public DL_Attributes() {
        layer = "";
        color = 0;
        color24 = -1;
        width = 0;
        linetype = "BYLAYER";
        linetypeScale = 1.0;
        handle = -1;
        inPaperSpace = false;
    }


    /**
     * Constructor for DXF attributes.
     *
     * @param layer    Layer name for this entity or NULL for no layer
     *                 (every entity should be on a named layer!).
     * @param color    Color number (0..256). 0 = BYBLOCK, 256 = BYLAYER.
     * @param width    Line thickness. Defaults to zero. -1 = BYLAYER,
     *                 -2 = BYBLOCK, -3 = default width
     * @param linetype Line type name or "BYLAYER" or "BYBLOCK". Defaults
     *                 to "BYLAYER"
     */
    public DL_Attributes(String layer,
                  int color,
                  int width,
                  String linetype,
                  double linetypeScale) {
        this.layer = layer;
        this.color = color;
        color24 = -1;
        this.width = width;
        this.linetype = linetype;
        this.linetypeScale = linetypeScale;
        handle = -1;
        inPaperSpace = false;
    }


    /**
     * Constructor for DXF attributes.
     *
     * @param layer    Layer name for this entity or NULL for no layer
     *                 (every entity should be on a named layer!).
     * @param color    Color number (0..256). 0 = BYBLOCK, 256 = BYLAYER.
     * @param color24  24 bit color (0x00RRGGBB, see DXF reference).
     * @param width    Line thickness. Defaults to zero. -1 = BYLAYER,
     *                 -2 = BYBLOCK, -3 = default width
     * @param linetype Line type name or "BYLAYER" or "BYBLOCK". Defaults
     *                 to "BYLAYER"
     */
    public DL_Attributes(String layer,
                  int color,
                  int width,
                  String linetype,
                  double linetypeScale,
                  int handle) {
        this.layer = layer;
        this.color = color;
        color24 = -1;
        this.width = width;
        this.linetype = linetype;
        this.linetypeScale = linetypeScale;
        this.handle = handle;
        inPaperSpace = false;
    }

    public DL_Attributes(String layer,
                         int color,
                         int color24,
                         int width,
                         String linetype,
                         int handle) {
        this.layer = layer;
        this.color = color;
        this.color24 = color24;
        this.width = width;
        this.linetype = linetype;
                this.handle = handle;
        inPaperSpace = false;
    }


    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor24() {
        return color24;
    }

    public void setColor24(int color24) {
        this.color24 = color24;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getLinetype() {
        if (linetype.length() == 0) {
            return "BYLAYER";
        } else {
            return linetype;
        }
    }

    public void setLinetype(String linetype) {
        this.linetype = linetype;
    }

    public double getLinetypeScale() {
        return linetypeScale;
    }

    public void setLinetypeScale(double linetypeScale) {
        this.linetypeScale = linetypeScale;
    }

    public int getHandle() {
        return handle;
    }

    public void setHandle(int handle) {
        this.handle = handle;
    }

    public boolean isInPaperSpace() {
        return inPaperSpace;
    }

    public void setInPaperSpace(boolean inPaperSpace) {
        this.inPaperSpace = inPaperSpace;
    }
}
