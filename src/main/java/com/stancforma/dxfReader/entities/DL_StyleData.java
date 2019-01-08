package com.stancforma.dxfReader.entities;

import java.util.Objects;

public class DL_StyleData implements Comparable<DL_StyleData>{



//    bool operator==(const DL_StyleData& other) {
//        // ignore lastHeightUsed:
//        return (name==other.name &&
//                flags==other.flags &&
//                fixedTextHeight==other.fixedTextHeight &&
//                widthFactor==other.widthFactor &&
//                obliqueAngle==other.obliqueAngle &&
//                textGenerationFlags==other.textGenerationFlags &&
//                primaryFontFile==other.primaryFontFile &&
//                bigFontFile==other.bigFontFile);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, flags, fixedTextHeight, widthFactor, obliqueAngle, textGenerationFlags, primaryFontFile, bigFontFile);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /** Style name */
    private String name;
    /** Style flags */
    private int flags;
    /** Fixed text height or 0 for not fixed. */
    private double fixedTextHeight;
    /** Width factor */
    private double widthFactor;
    /** Oblique angle */
    private double obliqueAngle;
    /** Text generation flags */
    private int textGenerationFlags;
    /** Last height used */
    private double lastHeightUsed;
    /** Primary font file name */
    private String primaryFontFile;
    /** Big font file name */
    private String bigFontFile;

    private boolean bold;
    private boolean italic;

    @Override
    public int compareTo(DL_StyleData o) {
        return 0;
    }

    public DL_StyleData(String name, int flags, double fixedTextHeight, double widthFactor, double obliqueAngle, int textGenerationFlags, double lastHeightUsed, String primaryFontFile, String bigFontFile) {
        this.name = name;
        this.flags = flags;
        this.fixedTextHeight = fixedTextHeight;
        this.widthFactor = widthFactor;
        this.obliqueAngle = obliqueAngle;
        this.textGenerationFlags = textGenerationFlags;
        this.lastHeightUsed = lastHeightUsed;
        this.primaryFontFile = primaryFontFile;
        this.bigFontFile = bigFontFile;
    }
}
