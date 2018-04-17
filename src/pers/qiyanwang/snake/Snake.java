package pers.qiyanwang.snake;


import java.util.LinkedList;

public class Snake {

    private final LinkedList<Node> body = new LinkedList<>();

    public Node eat(Node food) {
        //your code here
        if(food == null) return null;
        if(this.isNeighbor(this.getHead(),food)){
            body.offerFirst(food);
            return food;
        }
        else return null;

    }

    /**
     * 往某个方向移动，蛇的身体可能会重叠，重叠判断由<code>Grid</code>处理。
     *
     * @param direction
     * @return <code>Snake</code>原来的尾部，即最后一个<code>SquareArea</code>
     */
    public Node move(Direction direction) {
        //your code here
        int x = this.getHead().getX();
        int y = this.getHead().getY();

        switch (direction.directionCode()) {
            // 根据方向计算头部的新位置
            case 0:
                if(y == 0) break;
                body.offerFirst(new Node(x, y - 1));
                break;
            case 1:
                body.offerFirst(new Node(x+ 1,y));
                break;
            case 2:
                body.offerFirst(new Node(x,y + 1));
                break;
            case 3:
                if(x == 0) break;
                body.offerFirst(new Node(x - 1,y));
                break;
        }

        // 将新头部的Node增加近body

        // 移除尾部的Node
        // 返回移除的Node（尾部Node）
        return body.removeLast();
    }

    public Node getHead() {
        return body.getFirst();
    }

    public Node addTail(Node area) {
        this.body.addLast(area);
        return area;
    }

    public LinkedList<Node> getBody() {
        return body;
    }

    private boolean isNeighbor(Node a, Node b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1;
    }
}
