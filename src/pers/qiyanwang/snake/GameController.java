package pers.qiyanwang.snake;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements Runnable, KeyListener  {
    private final Grid grid;
    private final GameView gameView;

    boolean running;
    boolean suspend;

    public GameController(Grid grid, GameView gameView) {
        this.grid = grid;
        this.gameView = gameView;
        this.running = true;
        this.suspend = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_UP:
                grid.changeDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                grid.changeDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                grid.changeDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                grid.changeDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_SPACE:
                if(running) {
                     running = false;
                    }
                else {
                    running = true;
                    run();
                }
                break;
            case KeyEvent.VK_ENTER:
                if(running){
                    running = true;
                    grid.init();
                    run();
                }
            default:
        }
    }

    /**
     * 按一定速率自动移动贪吃蛇
     */
    public void run() {

        while (running) {
            try {
                Thread.sleep(200);
                if(!grid.nextRound()){
                    break;
                }
                else  gameView.draw();
            } catch (InterruptedException e) {
                break;
            }

        }
//        gameView.showGameOverMessage();
        running = false;

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
