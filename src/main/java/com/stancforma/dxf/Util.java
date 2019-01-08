package com.stancforma.dxf;

import java.util.List;

public class Util {


    public static DxfValue mapValue(List<DxfValue> dfxValues, int groupCode) {

        boolean isBoundedBy102 = false;

        for (DxfValue dxfValue : dfxValues) {
            if (!isBoundedBy102) {
                if (dxfValue.getGroupcode() == 102) {
                    isBoundedBy102 = true;
                }else if (dxfValue.getGroupcode() == groupCode) {
                    return dxfValue;
                }
            }else if (dxfValue.getGroupcode() == 102){
                isBoundedBy102 = false;
            }
        }

        return null;
    }

    public static DxfValue mapValue(List<DxfValue> dfxValues, int groupCode, int def) {

        boolean isBoundedBy102 = false;

        for (DxfValue dxfValue : dfxValues) {
            if (!isBoundedBy102) {
                if (dxfValue.getGroupcode() == 102) {
                    isBoundedBy102 = true;
                }else if (dxfValue.getGroupcode() == groupCode) {
                    return dxfValue;
                }
            }else if (dxfValue.getGroupcode() == 102){
                isBoundedBy102 = false;
            }
        }


        DxfValue ret = new DxfValue(groupCode,def);
        dfxValues.add(ret);
        return ret;
    }

    public static DxfValue mapValue(List<DxfValue> dfxValues, int groupCode, String def) {

        boolean isBoundedBy102 = false;

        for (DxfValue dxfValue : dfxValues) {
            if (!isBoundedBy102) {
                if (dxfValue.getGroupcode() == 102) {
                    isBoundedBy102 = true;
                }else if (dxfValue.getGroupcode() == groupCode) {
                    return dxfValue;
                }
            }else if (dxfValue.getGroupcode() == 102){
                isBoundedBy102 = false;
            }
        }


        DxfValue ret = new DxfValue(groupCode,def);
        dfxValues.add(ret);
        return ret;
    }
}
