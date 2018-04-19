package pers.qiyanwang.snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener, Runnable {
    private final Grid grid;
    private final GameView gameView;
    private boolean running;

    public GameController(Grid grid, GameView gameView) {
        this.gameView = gameView;
        this.grid = grid;
        running = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

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
                this.space();
                break;
            case KeyEvent.VK_ENTER:
                this.enter();
                break;
            default:
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub


    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                break;
            }
            if (grid.nextRound()) {
                gameView.draw();

            } else {
                gameView.showGameOverMessage();
                running = false;
            }
        }
    }
    public void enter() {
        if (running == false) {
            grid.init();
            running = true;
            new Thread(this).start();
        }
    }

    public void space() {
        if (running) {
            running = false;
        } else {
            running = true;
            new Thread(this).start();
        }
    }

}
