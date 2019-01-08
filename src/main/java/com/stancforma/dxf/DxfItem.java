package com.stancforma.dxf;

public class DxfItem {
    enum Type {
        UNDEFINED,
        TABLE,
        TABLE_ENTRY,
        ENTITY,
        BLOCK,
        OBJECT
    };

    protected Type type;

    public DxfItem() {
        this.type = Type.UNDEFINED;
    }

    public DxfItem(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
