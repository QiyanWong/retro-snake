package pers.qiyanwang.snake;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

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

    /**
     * 渲染整个游戏界面
     */
    public void draw() {
        this.canvas.repaint();
    }

    /**
     * 渲染贪吃蛇
     * @param graphics
     * @param snake
     */
    public void drawSnake(Graphics graphics, Snake snake) {
        // your code here
        for(Node bodynode : snake.getBody()) {
            drawSquare(graphics,bodynode,Settings.DEFAULT_SNAKE_COLOR);
        }
    }

    /**
     * 渲染食物
     * @param graphics
     * @param squareArea
     */
    public void drawFood(Graphics graphics, Node squareArea) {
        // your code here
        drawCircle(graphics,squareArea,Settings.DEFAULT_FOOD_COLOR);

    }

    /**
     * 渲染棋盘背景
     *
     * @param graphics
     */
    public void drawGridBackground(Graphics graphics) {
        graphics.setColor(Settings.DEFAULT_BACKGROUND_COLOR);
//        int size = Settings.DEFAULT_GRID_WIDTH * Settings.DEFAULT_GRID_HEIGHT;
        graphics.fillRect(0, 0, Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT);

        // your code here
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
