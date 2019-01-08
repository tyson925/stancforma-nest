package com.stancforma.dxf;

import java.util.List;

public class Table {
    List<DxfValue> attributes;
    List<TableEntry> records;

    public List<DxfValue> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<DxfValue> attributes) {
        this.attributes = attributes;
    }

    public List<TableEntry> getRecords() {
        return records;
    }

    public void setRecords(List<TableEntry> records) {
        this.records = records;
    }
}
