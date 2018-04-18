package pers.qiyanwang.snake;

import java.util.Arrays;
import java.util.Random;

public class Grid {

    public final boolean status[][];
    private final int width;
    private final int height;
    long time;
    long timeInterval = 200;
    private Snake snake;
    private Node food;

    // 初始方向设置为向左
    private Direction snakeDirection = Direction.LEFT;
    
    public Grid(int width, int height) {

        this.width = width;
        this.height = height;
        status = new boolean[width][height];
        time = System.currentTimeMillis();
        init();
    }

    public void init() {
        for (int i = 0; i < width; ++i) {
            Arrays.fill(status[i], false);
        }
        snakeDirection = Direction.LEFT;
        snake = initSnake();
        food = createFood();
    }

    /**
     * 初始化棋盘上的贪吃蛇
     * @return
     */
    private Snake initSnake() {
        snake = new Snake();

        int initialSnakeBodyLength = width / 3;
        for (int i = initialSnakeBodyLength - 1; i >= 0; --i) {
            int x = width / 2 + i;
            int y = height / 2;
            snake.getBody().addFirst(new Node(x, y));
            status[x][y] = true;
        }

        return snake;
    }

    /**
     * 随机产生一个食物（Node类型），并返回该Node
     * @return
     */
    public Node createFood() {
        int x, y;

        do {
            Random r = new Random();
            x = r.nextInt(width);
            y = r.nextInt(height);
        } while (status[x][y]);

        food = new Node(x, y);
        return food;
    }

    /**
     * 贪吃蛇往snakeDirection方向移动一格
     *
     * @return 如果游戏结束，返回false，否则返回true
     */
    public boolean nextRound() {
        Node snakeTail = snake.move(snakeDirection);
        Node snakeHead = snake.getHead();

        if (validPosition(snakeHead)) {
            if (isFood(snakeHead)) {
                snake.addTail(snakeTail);
                createFood();
            } else {
                dispose(snakeTail);
            }
            occupy(snakeHead);
            return true;
        }
        
        return false;
    }

    public void changeDirection(Direction newDirection) {
            long temp = time;
            time = System.currentTimeMillis();
            if(time - temp < timeInterval){
                return;
            }
        if (snakeDirection.compatibleWith(newDirection)) {
            snakeDirection = newDirection;
        }
    }

    public boolean validPosition(Node area) {
        int x = area.getX(), y = area.getY();
        return x >= 0 && x < width && y >= 0 && y < height && !status[x][y];
    }

    private void dispose(Node node) {
        status[node.getX()][node.getY()] = false;
    }

    private void occupy(Node node) {
        status[node.getX()][node.getY()] = true;
    }


    public boolean isFood(Node area) {
        int x = area.getX(), y = area.getY();
        return x == food.getX() && y == food.getY();
    }
    
    public Node getFood() {
        return food;
    }

    public Snake getSnake() {
        return snake;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
