package birdgame.utils;

/**
 * The Vec2 class represents a 2-dimensional vector or a pair of coordinates in the Bird Game.
 * This class is used to represent positions, dimensions, and other two-dimensional values within the game.
 */
public class Vec2 {
    public int x,y;
    public Vec2 left, right;

    /**
     * Constructs a Vec2 instance representing a point in 2D space.
     *
     * @param x The x-coordinate of the point.
     * @param y The y-coordinate of the point.
     */
    public Vec2(int x, int y){
        this.x = x;
        this.y = y;
    }

     /**
     * Constructs a Vec2 instance representing a pair of Vec2 points.
     * This constructor is useful for defining bounds or ranges.
     *
     * @param left The Vec2 instance representing the left point.
     * @param right The Vec2 instance representing the right point.
     */
    public Vec2(Vec2 left, Vec2 right){
        this.left = left;
        this.right = right;
    }
}
