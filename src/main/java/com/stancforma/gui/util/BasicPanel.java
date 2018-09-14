package com.stancforma.gui.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicPanel extends JPanel {
    public BasicPanel() {
        JButton button = new JButton("Set parameters of automata cutting");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                InputDialog inputForm = new InputDialog();
                inputForm.setVisible(true);
            }
        });
        add(button);
    }
}
