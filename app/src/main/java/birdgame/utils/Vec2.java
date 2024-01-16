package birdgame.utils;

public class Vec2 {
    public int x,y;
    public Vec2 left, right;
    public Vec2(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Vec2(Vec2 left, Vec2 right){
        this.left = left;
        this.right = right;
    }
}
