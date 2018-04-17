package pers.qiyanwang.snake;

public class Node {

    private final int x;
    private final int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object obj){
    if(this == obj) return true;
    if(obj instanceof Node){
        Node temp = (Node)obj;
        if(temp.getX() == this.getX() && temp.getY() == this.getY()){
            return true;
        }
        else return false;
    }
    return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}