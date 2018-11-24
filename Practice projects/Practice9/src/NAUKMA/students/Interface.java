package NAUKMA.students;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;

public class Interface {
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    private JFrame FRAME;
    private JPanel MAIN;
    private JPanel BOTTOM;
    private JPanel TOP;
    private JTextArea AREA;
    private JScrollPane SCROLL_AREA_PANE;
    private JButton SHOW_INFO;
    private JButton CLEAR_TEXTAREA;
    private JLabel LABEL;

    private int AREA_COLUMNS = 20;
    private int AREA_LINES = 15;

    private BufferedReader reader;

    public Interface(){
        setupInterface();
    }

    public Interface(BufferedReader reader){
        this.reader = reader;
        setupInterface();
    }

    private void setupInterface() {
        FRAME = new JFrame();
        MAIN = new JPanel();
        TOP = new JPanel();
        BOTTOM = new JPanel();
        AREA = new JTextArea(AREA_LINES, AREA_COLUMNS);
        SCROLL_AREA_PANE = new JScrollPane(AREA);
        SHOW_INFO = new JButton("Show Info");
        CLEAR_TEXTAREA = new JButton("Clear");
        LABEL = new JLabel("Dan's Program");

        FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        AREA.setLineWrap(true);
        SCROLL_AREA_PANE.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        SCROLL_AREA_PANE.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        SHOW_INFO.addActionListener(new ShowInfo());
        CLEAR_TEXTAREA.addActionListener(new ClearTextArea());

        TOP.add(LABEL);
        BOTTOM.add(SHOW_INFO);
        MAIN.add(BorderLayout.CENTER, SCROLL_AREA_PANE);
        MAIN.add(BorderLayout.SOUTH, CLEAR_TEXTAREA);

        FRAME.getContentPane().add(BorderLayout.NORTH, TOP);
        FRAME.getContentPane().add(BorderLayout.CENTER, MAIN);
        FRAME.getContentPane().add(BorderLayout.SOUTH, BOTTOM);
        FRAME.setVisible(true);
        FRAME.setSize(WIDTH, HEIGHT);
    }

    private class ShowInfo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String line;
                while((line = reader.readLine()) != null){
                    AREA.append(line + "\n");
                }
                reader.close();
            } catch(IOException exception){
                exception.printStackTrace();
            }
        }
    }

    private class ClearTextArea implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AREA.setText("");
        }
    }
}
