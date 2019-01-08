package com.stancforma.dxf;

import static com.stancforma.dxf.DxfItem.Type.ENTITY;

public class DxfEntity extends DxfItem {

    protected DxfValue _type;
    protected DxfValue _handle;
    protected DxfValue _owner;
    protected DxfValue _layer;



    // Actual container
    protected Entity _container;

    // Constructor for existing table
    public DxfEntity(Entity container) {
        super.type = ENTITY;
        this._container = container;

        _type = Util.mapValue(container.getAttributes(), 0);
        _handle = Util.mapValue(container.getAttributes(), 5);
        _owner = Util.mapValue(container.getAttributes(), 330);
        _layer = Util.mapValue(container.getAttributes(), 8, "0");
    }

    // type
    void type(String value) {
        _type.set(value);
    }

    String type() {
        return _type.asString();
    }

    // handle
    void handle(int value) {
        _handle.setHex(value);
    }

    int handle() {
        return _handle.asHex();
    }

    // owner
    void owner(int value) {
        _owner.setHex(value);
    }

    int owner() {
        return _owner.asHex();
    }

    // layer
    void layer(String value) {
        _layer.set(value);
    }

    String layer() {
        return _layer.asString();
    }

    public Entity get_container() {
        return _container;
    }

}
