package dev.destroyer;

import javax.swing.*;
import java.awt.*;

public class Options extends JPanel {
    private Image PLANE_MODEL_IMAGE;
    private Image BACKGROUND_IMAGE;

    public Options(){
        initOptions();
    }

    public void initOptions(){
        loadBackgroundImage();

        int w = PLANE_MODEL_IMAGE.getWidth(this);
        int h = PLANE_MODEL_IMAGE.getHeight(this);
        setPreferredSize(new Dimension(w, h));
    }

    private void loadBackgroundImage(){
        ImageIcon BackgroundImgIcon = new ImageIcon("src/" + Background.PATH);
        BACKGROUND_IMAGE = BackgroundImgIcon.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(BACKGROUND_IMAGE, 0, 0, null);
    }
}
