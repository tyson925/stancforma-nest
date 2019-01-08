package com.stancforma.dxf;

import java.util.List;

import static com.stancforma.dxf.DxfItem.Type.BLOCK;


public class DxfBlock extends DxfItem {

    // Effective fields
    DxfValue _name;
    DxfValue _handle;
    DxfValue _owner;
    DxfValue _layer;
    DxfValue _bpx;
    DxfValue _bpy;
    DxfValue _bpz;

    List<DxfEntity> entities;
    DxfTableEntry blockRecord;

    // Actual container
    Block _container;

    // Constructor for existing table
    DxfBlock(Block container, DxfTableEntry blockRecord){
        super.type = BLOCK;

        this._container = container;
        this.blockRecord = blockRecord;

        _name = Util.mapValue(container.attributes, 2);
        _handle = Util.mapValue(container.attributes, 5);
        _owner = Util.mapValue(container.attributes, 330, 0);
        _layer = Util.mapValue(container.attributes, 8, "0");
        _bpx = Util.mapValue(container.attributes, 10);
        _bpy = Util.mapValue(container.attributes, 20);
        _bpz = Util.mapValue(container.attributes, 30, 0);

        for (Entity entity: container.entities) {
            entities.add(new DxfEntity(entity));
        }
    }


    // name
    void name(String value) {
        _name.set(value);
    }

		String name(){
        return _name.asString();
    }

    // handle
    void handle(int value) {
        _handle.setHex(value);
    }

		int handle(){
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

		String layer(){
        return _layer.asString();
    }

    // base point
    void basePoint(double x, double y, double z) {
        _bpx.set(x);
        _bpy.set(y);
        _bpz.set(z);
    }

    void basePoint(double[] values) {
        basePoint(values[0], values[1], values[2]);
    }

		double[] basePoint() {
        return new double[]{_bpx.asDouble(), _bpy.asDouble(), _bpz.asDouble()};
    }
}
