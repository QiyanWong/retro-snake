package pers.qiyanwang.snake;

import javax.swing.*;
import java.awt.*;

public class GameView {

    private final Grid grid;
    private JPanel canvas;

    public GameView(Grid grid) {
        this.grid = grid;
    }

    public void init() {
        canvas = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics) {
                drawGridBackground(graphics);
                drawSnake(graphics, grid.getSnake());
                drawFood(graphics, grid.getFood());
            }
        };
    }

    public void showGameOverMessage() {
        JOptionPane.showMessageDialog(null, "游戏结束", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 渲染整个游戏界面
     */
    public void draw() {
        canvas.repaint();
    }

    /**
     * 渲染贪吃蛇
     * @param graphics
     * @param snake
     */
    public void drawSnake(Graphics graphics, Snake snake) {
        java.util.List<Node> body = snake.getBody();
        for (Node squareArea : body) {
            drawSquare(graphics, squareArea, Settings.DEFAULT_SNAKE_COLOR);
        }
    }

    /**
     * 渲染食物
     * @param graphics
     * @param squareArea
     */
    public void drawFood(Graphics graphics, Node squareArea) {
        drawCircle(graphics, squareArea, Settings.DEFAULT_FOOD_COLOR);
    }

    /**
     * 渲染棋盘背景
     * @param graphics
     */
    public void drawGridBackground(Graphics graphics) {
        graphics.setColor(Settings.DEFAULT_BACKGROUND_COLOR);
        graphics.fillRect(0, 0, grid.getWidth() * Settings.DEFAULT_NODE_SIZE,
                grid.getHeight() * Settings.DEFAULT_NODE_SIZE);
    }


    /**
     * 绘制正方形
     * @param graphics
     * @param squareArea
     * @param color
     */
    private void drawSquare(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = Settings.DEFAULT_NODE_SIZE;
        graphics.fillRect(squareArea.getX() * size, squareArea.getY() * size, size - 1, size - 1);
    }

    /**
     * 绘制圆形
     * @param graphics
     * @param squareArea
     * @param color
     */
    private void drawCircle(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = Settings.DEFAULT_NODE_SIZE;
        graphics.fillOval(squareArea.getX() * size, squareArea.getY() * size, size, size);
    }

    public JPanel getCanvas() {
        return canvas;
    }
    
}
