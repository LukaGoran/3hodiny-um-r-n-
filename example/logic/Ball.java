package org.example.logic;

import java.awt.*;
import java.util.ArrayList;

public class Ball extends Entity {
    public boolean isVisible;

    public Ball(int x, int y, int width, int height, String url) {
        super(x, y, width, height, url);
        this.isVisible = true;
    }

    public ArrayList<Coordinates> getAllCoordinates() {
        ArrayList<Coordinates> ballCoords = new ArrayList<>();
        for (int i = coord.x; i < coord.x + image.getWidth(null); i++) {
            for (int j = coord.y; j < coord.y + image.getHeight(null); j++) {
                ballCoords.add(new Coordinates(i, j));
            }
        }
        return ballCoords;
    }

    public boolean checkCollision(Enemy enemy) {
        Rectangle ballBounds = new Rectangle(
                coord.x,
                coord.y,
                image.getWidth(null),
                image.getHeight(null)
        );

        Rectangle enemyBounds = new Rectangle(
                enemy.getX(),
                enemy.getY(),
                enemy.getWidth(),
                enemy.getHeight()
        );

        return ballBounds.intersects(enemyBounds);
    }

    public int getX() {
        return coord.x;
    }

    public int getY() {
        return coord.y;
    }
    public void setX(int x) {
        coord.x = x;
    }
    public void setY(int y){
        coord.y = y;
    }

    public int getWidth() {
        return image.getWidth(null);
    }

    public int getHeight() {
        return image.getHeight(null);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        this.isVisible = visible;
    }

}

