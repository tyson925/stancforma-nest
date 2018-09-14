package com.stancforma.gui.util;


import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

class InputPanel extends JPanel {
    JTextField minAreaSize;
    JTextField parameter2;
    JTextField parameter3;

    public InputPanel() {
        GridLayout gridLayout = new GridLayout(4,2);
        setLayout(gridLayout);
        minAreaSize = new JTextField(20);
        parameter2 = new JTextField(20);
        parameter3 = new JTextField(20);
        JLabel firstNameLabel = new JLabel("Minimum size of area: ");
        JLabel secondNameLabel = new JLabel("Parameter 2: ");
        JLabel phoneNumberLabel = new JLabel("Parameter 3: ");

        JButton saveToFileButton = new JButton("Save to file");

        saveToFileButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedWriter writer;
                try {
                    //File file = new File("contacts.txt");
                    writer = new BufferedWriter(new FileWriter("parametes_to_cuts_"+minAreaSize.getText()+"_"+parameter2.getText()+"_"+parameter3.getText()+".txt",true));
                    writer.write("MintArea"+ "\t" + minAreaSize.getText() +"\n");
                    writer.write("parameter2"+ "\t" + parameter2.getText()+"\n");
                    writer.write("parameter3"+ "\t" + parameter3.getText()+"\n");

                    writer.close();
                } catch(FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        add(firstNameLabel);
        add(minAreaSize);
        add(secondNameLabel);
        add(parameter2);
        add(phoneNumberLabel);
        add(parameter3);
        add(saveToFileButton);
    }
}