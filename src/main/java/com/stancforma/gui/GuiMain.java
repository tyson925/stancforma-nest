package com.stancforma.gui;

import com.stancforma.gui.util.BasicPanel;
import com.stancforma.gui.util.DxfFileFilter;
import com.stancforma.gui.util.NetParameters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GuiMain extends JPanel
        implements ActionListener {
    static private final String newline = "\n";
    private JButton openButton, saveButton;
    private JTextArea log;
    private JFileChooser fc;


    public GuiMain(NetParameters netParameters) {
        super(new BorderLayout());

        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5, 20);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //Create a file chooser
        fc = new JFileChooser();


        fc.addChoosableFileFilter(new DxfFileFilter());
        fc.setAcceptAllFileFilterUsed(false);


        openButton = new JButton("Open a dxf File...");
        openButton.addActionListener(this);

        saveButton = new JButton("Run nesting...");
        saveButton.addActionListener(this);

        //Create the save button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        saveButton = new JButton("Save nested results into a file...");
        saveButton.addActionListener(this);


        BasicPanel basicPanel = new BasicPanel();


        //For layout purposes, put the buttons in a separate panel
        JPanel panel = new JPanel(); //use FlowLayout
        panel.add(openButton);
        panel.add(basicPanel);
        panel.add(saveButton);

        //Add the buttons and the log to this panel.
        add(panel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                log.append("Opening: " + file.getName() + "." + newline);
            } else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());

            //Handle save button action.
        } else if (e.getSource() == saveButton) {
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
                log.append("Saving: " + file.getName() + "." + newline);
            } else {
                log.append("Save command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
    }




    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Stancfomra cut optimazing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        NetParameters netParameters = new NetParameters();

        //Add content to the window.
        frame.add(new GuiMain(netParameters));

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}
