package dev.airship;

import javax.swing.*;
import java.awt.*;

public class Background {

    private Image Background;
    private int w, h;

    public Background(String src){
        loadBackgroundImage(src);
    }

    private void loadBackgroundImage(String src){
        ImageIcon BackgroundImgIcon = new ImageIcon(src);
        Background = BackgroundImgIcon.getImage();

        w = Background.getWidth(null);
        h = Background.getHeight(null);
    }

    public Image getBackgroundImage(){
        return Background;
    }

    public int getBackgroundImageWidth(){
        return w;
    }

    public int getBackgroundImageHeight(){
        return h;
    }
}
