package dev.destroyer;

import acm.graphics.GCanvas;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private static final int WIDTH = 640;
    private static final int HEIGHT= 480;

    private GCanvas Canvas;

    private JFrame FRAME;
    private JPanel PANEL_BOTTOM;
    private JPanel PANEL_TOP;
    private JPanel PANEL_CENTER;
    private JButton PLAY;
    private JButton OPTIONS;
    private JCheckBox OPTIONS_CHECKBOX_

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.init();
        gui.run();
    }

    public void init(){
        FRAME = new JFrame();
        FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PANEL_BOTTOM = new JPanel();
        PANEL_CENTER = new JPanel();
        PANEL_TOP = new JPanel();
        PLAY = new JButton("Play");
        OPTIONS = new JButton("Options");
    }

    public void run(){
        PLAY.addActionListener(new Play_Button());
        OPTIONS.addActionListener(new Options_Button());

        PANEL_BOTTOM.add(OPTIONS, BorderLayout.CENTER);
        PANEL_CENTER.add(PLAY, BorderLayout.CENTER);
        FRAME.add(PANEL_CENTER, BorderLayout.CENTER);
        FRAME.add(PANEL_BOTTOM, BorderLayout.SOUTH);

        FRAME.setVisible(true);
        FRAME.setSize(WIDTH, HEIGHT);
    }

    private void show_Options_window(){

    }

    public class Play_Button implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameInterface GI = new GameInterface(WIDTH, HEIGHT);
            GI.run();
        }
    }

    public class Options_Button implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FRAME.getContentPane().removeAll();
            FRAME.repaint();
        }
    }
}
