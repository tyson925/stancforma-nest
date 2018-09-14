package com.stancforma.gui.util;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class DxfFileFilter extends FileFilter {
    //Accept all directories and only dfx files
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        if (extension != null) {
            if (extension.equals(Utils.dxf)) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Just DXF files.";
    }
}
