package org.example.logic;

import java.awt.*;

public class Enemy extends Entity{
    public Enemy(int x, int y,int width, int height, String url) {
        super(x, y, width, height, url);
    }

        public int getX() {
            return coord.x;
        }

        public int getY() {
            return coord.y;
        }

        public int getWidth() {
            return image.getWidth(null);
        }

        public int getHeight() {
            return image.getHeight(null);
        }




}
