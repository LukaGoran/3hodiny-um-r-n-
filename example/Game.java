package org.example;

import org.example.logic.Enemy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {
    GameLogic logic;

    public Game() {
        logic = new GameLogic();
        GameGraphics graphics = new GameGraphics(logic);

        // Nastavení focusu pro zachycení kláves
        graphics.setFocusable(true);
        graphics.requestFocusInWindow();

        graphics.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (!logic.getBall().isVisible()) {
                    return; // Pokud míč není viditelný, ignorujeme vstup
                }

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        logic.getBall().setY(logic.getBall().getY() - 10);
                        break;
                    case KeyEvent.VK_S:
                        logic.getBall().setY(logic.getBall().getY() + 10);
                        break;
                    case KeyEvent.VK_A:
                        logic.getBall().setX(logic.getBall().getX() - 10);
                        break;
                    case KeyEvent.VK_D:
                        logic.getBall().setX(logic.getBall().getX() + 10);
                        break;
                }

                // Kontrola kolize po každém pohybu
                Enemy enemy = logic.getEnemy();
                if (enemy != null && logic.getBall().checkCollision(enemy)) {
                    logic.getBall().setVisible(false);
                }

                graphics.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.update();
                graphics.repaint();
            }
        });

        timer.start();

        graphics.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!logic.getBall().isVisible()) {
                    return; // Pokud míč není viditelný, ignorujeme kliknutí
                }

                Rectangle pointOfCollision = new Rectangle(e.getX(), e.getY() - 30, 1, 1);
                Rectangle ballBounds = new Rectangle(

                );

                if (pointOfCollision.intersects(ballBounds)) {
                    logic.getBall().setX(logic.getBall().getX() + 500);

                    // Kontrola kolize po pohybu
                    if (logic.getBall().checkCollision(logic.getEnemy())) {
                        logic.getBall().setVisible(false);
                    }

                    graphics.repaint();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // Vytvoření a nastavení okna
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Game());
    }
}


