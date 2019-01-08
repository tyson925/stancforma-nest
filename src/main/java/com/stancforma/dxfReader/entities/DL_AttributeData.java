package com.stancforma.dxfReader.entities;

public class DL_AttributeData extends DL_TextData {

    String tag;

    public DL_AttributeData(double ipx, double ipy, double ipz, double apx, double apy, double apz, double height, double xScaleFactor, int textGenerationFlags, int hJustification, int vJustification, String text, String style, double angle, String tag) {
        super(ipx, ipy, ipz, apx, apy, apz, height, xScaleFactor, textGenerationFlags, hJustification, vJustification, text, style, angle);
        this.tag = tag;
    }

}
