package com.stancforma.dxf;

import java.util.List;

public class DxfInsert extends DxfEntity {

    DxfValue _blockName;
    DxfValue _bpx;
    DxfValue _bpy;
    DxfValue _bpz;

    DxfInsert(DxfEntity entity) throws Exception {

        super(entity._container);

        List<DxfValue> attributes = _container.getAttributes();

        if (!entity.type().equals("INSERT")) {
            throw new Exception("Entity must be an insert");
        }

        _blockName = Util.mapValue(attributes, 2);
        _bpx = Util.mapValue(attributes, 10);
        _bpy = Util.mapValue(attributes, 20);
        _bpz = Util.mapValue(attributes, 30, 0);

    }


    // block name
    void blockName(String value) {
        _blockName.set(value);
    }

    String blockName() {
        return _blockName.asString();
    }

    // base point x
    void bpx(double value) {
        _bpx.set(value);
    }

    double bpx() {
        return _bpx.asDouble();
    }

    // base point y
    void bpy(double value) {
        _bpy.set(value);
    }

    double bpy() {
        return _bpy.asDouble();
    }

    // base point z
    void bpz(double value) {
        _bpz.set(value);
    }

    double bpz() {
        return _bpz.asDouble();
    }
}


