package pers.qiyanwang.snake;

public class Grid {

    public final boolean status[][];
    private final int width;
    private final int height;

    private Snake snake;
    private Node food;

    // initate direction as LEFT
    private Direction snakeDirection = Direction.LEFT;

    public Grid(int width, int height) {

        this.width = width;
        this.height = height;
        status = new boolean[width][height];

        initSnake();
        createFood();
    }

    /**
     * initate snake on grid
     * @return
     */
    private Snake initSnake() {
        snake = new Snake();
        int y = height / 2;

        for(int i = 0; i < width / 3; i++){
            //set snake's body
            Node newNode = new Node(width / 2 + i,y);
            //update grid status
            snake.getBody().addLast(newNode);
            this.occupy(newNode);
        }

        return snake;
    }

    /**
     * 随机产生一个食物（Node类型），并返回该Node
     * @return
     */
    public Node createFood() {

        int x = 0, y = 0;
        x += (int)(Math.random() * width);
        y += (int)(Math.random() * height);
        food = new Node(x, y);
        if(snake.getBody().contains(food)){
                return createFood();
            }
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

        if(isVaildHead(snakeHead)){
            if(isFood(snakeHead)){
                snake.getBody().addLast(snakeTail);
                createFood();
                this.occupy(snakeHead);
                this.occupy(snakeTail);
                this.occupy(food);
            }
            else {
                this.occupy(snakeHead);
                this.dispose(snakeTail);
            }
            return true;
        }
        return false;
    }

    private boolean isVaildHead(Node snakeHead){
        int x = snakeHead.getX();
        int y = snakeHead.getY();
        //case1: out of boundary
        if(!this.validPosition(snakeHead)){
            return false;
        }
        //case2: overlap itself
        snake.getBody().removeFirst();
        if(snake.getBody().contains(new Node(x,y))) return false;
        snake.getBody().addFirst(new Node(x,y));
        return true;
    }
    public void changeDirection(Direction newDirection) {
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
