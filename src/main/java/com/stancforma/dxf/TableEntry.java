package com.stancforma.dxf;

import java.util.List;

public class TableEntry {

    public List<DxfValue> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<DxfValue> attributes) {
        this.attributes = attributes;
    }

    List<DxfValue> attributes;
}
