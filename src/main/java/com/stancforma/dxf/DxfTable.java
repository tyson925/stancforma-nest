package com.stancforma.dxf;

import java.util.List;

import static com.stancforma.dxf.DxfItem.Type.TABLE;

public class DxfTable extends DxfItem {
    private DxfValue _name;
    private DxfValue _handle;
    private DxfValue _owner;
    private DxfValue _maxNumOfEntries;

    public List<DxfTableEntry> getEntries() {
        return entries;
    }

    private List<DxfTableEntry> entries;

    // Actual container
    Table _container;

    // Constructor for existing table
    public DxfTable(Table container) {
        super.type = TABLE;
        this._container = container;

        _name = Util.mapValue(container.attributes, 2);
        _handle = Util.mapValue(container.attributes, 5);
        _owner = Util.mapValue(container.attributes, 330, 0);
        _maxNumOfEntries = Util.mapValue(container.attributes, 70);

        for (TableEntry tableEntry : container.records) {
            entries.add(new DxfTableEntry(tableEntry));
        }

    }

    // name
    public void name(String value) {
        _name.set(value);
    }

    public String name() {
        return _name.asString();
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

    // maximum number of entries
    public void maxNumOfEntries(int value) {
        _maxNumOfEntries.set(value);
    }

    public int maxNumOfEntries() {
        return _maxNumOfEntries.asInt();
    }



}
