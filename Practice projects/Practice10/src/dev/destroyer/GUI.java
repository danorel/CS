package dev.destroyer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private static final int WIDTH = 240;
    private static final int HEIGHT= 160;

    private Background GUI_Background;
    private Board BOARD;
    private Options OPTIONS_PANEL;

    private JPanel PANEL_BOTTOM;
    private JPanel PANEL_TOP;
    private JPanel PANEL_CENTER;
    private JButton PLAY;
    private JButton OPTIONS;
    private JButton BACK;
    private JCheckBox OPTIONS_CHECKBOX_LEVEL;

    public static void main(String[] args) {
        GUI GraphicsUI = new GUI();
        GraphicsUI.setVisible(true);
        GraphicsUI.initUI();
    }

    public void initUI(){
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("User Interface");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        GUI_Background = new Background("src/image/background/gui_background.png");
        PANEL_BOTTOM = new JPanel();
        PANEL_CENTER = new JPanel();
        PANEL_TOP = new JPanel();
        PLAY = new JButton("Play");
        OPTIONS = new JButton("Options");
        BACK = new JButton("Back");
        run();
    }

    private void drawBackground(){

    }

    private void run(){
        PLAY.addActionListener(new Play_Button());
        OPTIONS.addActionListener(new Options_Button());
        BACK.addActionListener(new Back_Button());

        PANEL_CENTER.add(OPTIONS, BorderLayout.CENTER);
        PANEL_TOP.add(PLAY, BorderLayout.CENTER);
        PANEL_BOTTOM.add(BACK, BorderLayout.CENTER);
        this.add(PANEL_TOP, BorderLayout.NORTH);
        this.add(PANEL_CENTER, BorderLayout.CENTER);
        this.add(PANEL_BOTTOM, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public class Play_Button implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GUI GameUI = new GUI();
            GameUI.setVisible(true);

            GameUI.add(new Board());
            GameUI.pack();

            GameUI.setSize(3 * WIDTH, 3 * HEIGHT);
            GameUI.setTitle("Game Interface");
            GameUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            GameUI.setLocationRelativeTo(null);
        }
    }

    public class Options_Button implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GUI OptionsUI = new GUI();
            OptionsUI.setVisible(true);
            OptionsUI.removeAll();
            OPTIONS_PANEL = new Options();
            JLabel LABEL = new JLabel("GOOOD MORNING");
            OPTIONS_PANEL.add(LABEL);
//            OPTIONS_CHECKBOX_LEVEL = new JCheckBox("Choose level");
//            OPTIONS_CHECKBOX_LEVEL.setSelected(true);
//            OPTIONS_PANEL.add(OPTIONS_CHECKBOX_LEVEL);
            OptionsUI.setTitle("Options");
            OptionsUI.getContentPane().add(OPTIONS_PANEL, BorderLayout.CENTER);
        }
    }

    public class Back_Button implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
