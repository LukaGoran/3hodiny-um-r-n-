package org.example;

import org.example.logic.*;

import java.awt.*;
import java.util.ArrayList;

public class GameLogic {
    final int MOVE_LENGHT = 10;
    Ball ball;
    ArrayList<Enemy> enemies;
    Background background;

    public GameLogic() {

        background = new Background(-20, -20, 20, 20, "Pozadí.jpg");
        ball = new Ball(1650, 750, 50, 50, "Mimozemstan.png");
        enemies = new ArrayList<>();
        /*Enemy enemy1 = new Enemy(150, 50,20,20, "Zombie.png");
        Enemy enemy2 = new Enemy(150, 150,20,20, "Zombie.png");

         */
        Enemy enemy3 = new Enemy(-50, -100, 20, 20, "Zombie.png");
        //enemies.add(enemy1);
        //enemies.add(enemy2);
        enemies.add(enemy3);
    }


    public void update() {
        for (Enemy enemy : enemies) {
            // Kontrola kolize pro každého nepřítele v seznamu
            if (ball.isVisible() && checkCollision(ball, enemy)){
                ball.setVisible(false); // Míč zmizí při kolizi
                ball.setX(-100);
                ball.setY(-100);
            }

        }
    }

    // Metoda pro kontrolu kolize mezi míčem a nepřítelem
    private boolean checkCollision(Ball ball, Enemy enemy) {
        // Získání souřadnic středů objektů
        double ballCenterX = ball.getX() + ball.getWidth() / 2;
        double ballCenterY = ball.getY() + ball.getHeight() / 2;
        double enemyCenterX = enemy.getX() + enemy.getWidth() / 2;
        double enemyCenterY = enemy.getY() + enemy.getHeight() / 2;

        // Výpočet vzdálenosti mezi středy
        double dx = ballCenterX - enemyCenterX;
        double dy = ballCenterY - enemyCenterY;
        double distance = Math.sqrt(dx * dx + dy * dy);

        // Výpočet minimální vzdálenosti pro kolizi (součet polovin šířek objektů)
        double minDistance = (ball.getWidth() + enemy.getWidth()) / 2;


        return distance < minDistance;

    }

    public Ball getBall(){
        return ball;

    }

    public ArrayList<Enemy> getEnemies(){
        return  enemies;

    }
    public Background getBackground() {
        return background;
    }

    public Enemy getEnemy() {
        if (enemies.isEmpty()) {
            return enemies.get(0);
        }
        return null;
    }
}