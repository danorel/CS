package dev.destroyer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener, KeyListener {

    private SpaceShip spaceShip;
    private Background background;
    private Timer timer;
    private static final int DELAY = 30;

    public Board(){
        initBoard();
    }

    public void initBoard(){
        addKeyListener(this);
//        addMouseListener(new CustomMouseListener());

        background = new Background("src/image/background/background.png");
        spaceShip = new SpaceShip();

        setPreferredSize(new Dimension(background.getBackgroundImageWidth(), background.getBackgroundImageHeight()));

        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void drawSpaceShipMotion(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(spaceShip.getImage(), spaceShip.getCurrentX(), spaceShip.getCurrentY(), this);
    }

    private void drawBackgroundImage(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background.getBackgroundImage(), 0, 0, null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBackgroundImage(g);
        drawSpaceShipMotion(g);

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
    }

    private void step(){
        if(spaceShip.getCurrentX() >= background.getBackgroundImageWidth() - spaceShip.getWidth()){
            spaceShip.x = 0;
            spaceShip.y = spaceShip.getCurrentY();
        }
        spaceShip.move();
        repaint();
}

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

//
//    private class CustomMouseListener implements MouseListener {
//
//        @Override
//        public void mouseClicked(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//            if(e.getX() >= background.getBackgroundImageWidth() / 2){
//                System.out.println("Hello, world!");
//            }
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//            System.out.println("Bye, world!");
//        }
//    }
}
