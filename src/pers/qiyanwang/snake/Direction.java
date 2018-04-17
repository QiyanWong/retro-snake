package pers.qiyanwang.snake;

/**
 * 贪吃蛇前进的方向
 */
public enum Direction {

UP(0),
RIGHT(1),
DOWN(2),
LEFT(3);

private final int directionCode;

Direction(int directionCode) {
this.directionCode = directionCode;
}

public int directionCode() {
return directionCode;
}

/**
 * 判断方向改变是否有效，例如从向上变为向下为无效，从向上变为向左为有效
 * @param direction
 * @return
 */
public boolean compatibleWith(Direction direction) {
// your code here
return true;
}
}
