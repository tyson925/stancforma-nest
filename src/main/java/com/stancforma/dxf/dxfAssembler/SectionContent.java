package com.stancforma.dxf.dxfAssembler;

public class SectionContent {

    private int sectionContentKey;
    private String sectionContentValue;

    public SectionContent(int sectionContentKey, String sectionContentValue) {
        this.sectionContentKey = sectionContentKey;
        this.sectionContentValue = sectionContentValue;
    }

    public int getSectionContentKey() {
        return sectionContentKey;
    }

    public String getSectionContentValue() {
        return sectionContentValue;
    }
}
