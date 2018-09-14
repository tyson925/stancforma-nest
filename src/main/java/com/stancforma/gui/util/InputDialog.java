package com.stancforma.gui.util;

import javax.swing.*;

class InputDialog extends JDialog {
    public InputDialog() {
        InputPanel panel = new InputPanel();
        setTitle("Input Dialog");
        add(panel);
        setSize(200,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(false);
    }
}
