package com.stancforma.dxf;

import java.util.List;

public class Entity {
    private List<DxfValue> attributes;

    public List<DxfValue> getAttributes() {
        return attributes;
    }

    public Entity() {
    }

    public Entity(List<DxfValue> attributes) {
        this.attributes = attributes;
    }

    public void setAttributes(List<DxfValue> attributes) {
        this.attributes = attributes;
    }
}
