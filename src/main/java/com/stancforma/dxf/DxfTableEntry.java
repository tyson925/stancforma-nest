package com.stancforma.dxf;

import static com.stancforma.dxf.DxfItem.Type.TABLE_ENTRY;

public class DxfTableEntry extends DxfItem {

    private DxfValue _handle;
    private DxfValue _owner;

    // Actual container
    private TableEntry _container;


    // Constructor for existing table entry

    public DxfTableEntry(TableEntry container) {
        super.type = TABLE_ENTRY;
        this._container = container;

        if (Util.mapValue(container.attributes, 0).asString().equals("DIMSTYLE")) {
            _handle = Util.mapValue(container.attributes, 105);
        } else {
            _handle = Util.mapValue(container.attributes, 5);
        }
        _owner = Util.mapValue(container.attributes, 330, 0);
    }

    // handle
    public void handle(int value) {
        _handle.setHex(value);
    }

    public int handle() {
        return _handle.asHex();
    }

    // owner
    public void owner(int value) {
        _owner.setHex(value);
    }

    public int owner() {
        return _owner.asHex();
    }
}
