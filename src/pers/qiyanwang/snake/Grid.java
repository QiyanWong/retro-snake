package pers.qiyanwang.snake;

public class Grid{
    private final int  width;
    private final int  height;
    private Snake snake;
    
    public Grid(int width, int height){
        this.width = width;
        this.height = height;
        initSnake();
    }
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public Snake getSnake(){
        return snake;
    }
    
    private Snake initSnake(){
        snake = new Snake();
        return snake;
    }
}

