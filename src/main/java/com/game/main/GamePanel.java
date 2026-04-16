package com.game.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 Tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48x48 Tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // GAME LOOP TIME
    int FPS = 60;

    // KEYBOARD INPUT
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    // PLAYER'S POSITION
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // Rendering performance
        this.addKeyListener(keyHandler);
        this.setFocusable(true); // Make the panel focusable to receive key inputs
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    // public void run() {
    // double drawInterval = 1000000000 / FPS; // 0.016666666666666666 seconds
    // double nextDrawTime = System.nanoTime() + drawInterval;

    // while (gameThread != null) {
    // 1. Update game state
    // update();
    // 2. Draw the screen
    // repaint();

    // try {
    // double remainingTime = nextDrawTime - System.nanoTime();
    // remainingTime = remainingTime / 1000000;

    // if (remainingTime < 0) {
    // remainingTime = 0;
    // }

    // Thread.sleep((long) (remainingTime));
    // nextDrawTime += drawInterval;
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }
    // }
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        if (keyHandler.upPressed) {
            playerY -= playerSpeed;
        }
        if (keyHandler.downPressed) {
            playerY += playerSpeed;
        }
        if (keyHandler.leftPressed) {
            playerX -= playerSpeed;
        }
        if (keyHandler.rightPressed) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose();
    }
}
