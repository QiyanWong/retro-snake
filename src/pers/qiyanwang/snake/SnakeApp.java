package pers.qiyanwang.snake;

import javax.swing.*;

public class SnakeApp {

    public void init() {
        // your code here: 初始化Grid

        //Create game window
        JFrame window = new JFrame("Retro Snake");
        JLabel label = new JLabel("Retro Snake");
        window.getContentPane().add(label);

        // your code here: 初始化GameView，并放到window中

        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SnakeApp snakeApp = new SnakeApp();
        snakeApp.init();
    }
}