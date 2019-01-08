package com.stancforma.dxf.dxfAssembler;

import com.stancforma.dxf.DxfValue;

public class DxfHeader {

    private String dxfHeaderKey;
    private DxfValue dxfHeaderValue;

    public DxfHeader(String dxfHeaderKey, DxfValue dxfHeaderValue) {
        this.dxfHeaderKey = dxfHeaderKey;
        this.dxfHeaderValue = dxfHeaderValue;
    }

    public String getDxfHeaderKey() {
        return dxfHeaderKey;
    }

    public void setDxfHeaderKey(String dxfHeaderKey) {
        this.dxfHeaderKey = dxfHeaderKey;
    }

    public DxfValue getDxfHeaderValue() {
        return dxfHeaderValue;
    }

    public void setDxfHeaderValue(DxfValue dxfHeaderValue) {
        this.dxfHeaderValue = dxfHeaderValue;
    }
}
