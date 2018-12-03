package dev.destroyer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel implements ActionListener {

    private Image PLANE_MODEL_IMAGE;
    private int x, y;
    private Image BACKGROUND_IMAGE;
    private Plane plane;
    private Timer timer;

    private static final int START_X_COORDINATE = 0;
    private static final int START_Y_COORDINATE = 100;

    public Board(){
        initBoard();
        x = START_X_COORDINATE;
        y = START_Y_COORDINATE;
    }

    public void initBoard(){
        loadBackgroundImage();
        loadPlaneImage();

        int w = BACKGROUND_IMAGE.getWidth(this);
        int h = BACKGROUND_IMAGE.getHeight(this);
        setPreferredSize(new Dimension(w, h));

        timer = new Timer(30, this);
        timer.start();
    }

    private void drawPlaneMotion(Graphics g){
        g.drawImage(PLANE_MODEL_IMAGE, x, y, this);
    }

    private void loadPlaneImage() {
        ImageIcon PlaneImgIcon = new ImageIcon("src/image/plane_models/plane_model_1_right.jpg");
        PLANE_MODEL_IMAGE = PlaneImgIcon.getImage();
        PLANE_MODEL_IMAGE = PLANE_MODEL_IMAGE.getScaledInstance(Plane.width / 6, Plane.height / 6 , Image.SCALE_DEFAULT);
    }

    private void loadBackgroundImage(){
        ImageIcon BackgroundImgIcon = new ImageIcon(Background.PATH);
        BACKGROUND_IMAGE = BackgroundImgIcon.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(PLANE_MODEL_IMAGE, START_X_COORDINATE, START_Y_COORDINATE, null);
        g.drawImage(BACKGROUND_IMAGE, 0, 0, null);

        drawPlaneMotion(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        plane = new Plane();
        x += plane.horizontalVelocity;
        y += plane.verticalVelocity;
        addKeyListener(new CustomKeyListener());

        if (x > BACKGROUND_IMAGE.getWidth(this)) {
            System.out.println(PLANE_MODEL_IMAGE.getHeight(this));
            y = PLANE_MODEL_IMAGE.getHeight(this);
            x = START_X_COORDINATE;
        }

        repaint();
    }

    public class CustomKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e.getKeyCode());
            if(e.getKeyCode() == 39){

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
