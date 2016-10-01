package bjd54P2;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

/*
 * The Obstacle Class creates an array of 
 * rectangles that are randomly placed on the board.
 * Every time the snake eats the food object, a new
 * obstacle is added to the obstacles array. If the
 * snake collides with one of the obstacles, the game is 
 * over.
 */
public class Obstacle {

	private ArrayList<Rectangle> obstacles;
	private static int WIDTH = 10;
	private static int HEIGHT = 10;
	
	public Obstacle()
	{
		obstacles = new ArrayList<Rectangle>();

	}
	
	/*
	 * Constructor creates an array list of rectangles
	 */
	public Obstacle(Board board)
	{
		obstacles = new ArrayList<Rectangle>();
	}

	/*
	 * The method creates a random location for a new obstacle
	 * and returns a new rectangle obstacle added to the array
	 * with that randomly created location.
	 */
	public Rectangle obstacleCreator()
	{
		Point currentPoint = new Point();
		
		Random randomCoordinate = new Random();
		
		int randomX = randomCoordinate.nextInt(30);
		int randomY = randomCoordinate.nextInt(30);
		
		randomX = randomX * WIDTH;
		randomY = randomY * HEIGHT;
		
		currentPoint.setX(randomX);
		currentPoint.setY(randomY);
		
		Rectangle newObstacle = new Rectangle();
		
		newObstacle.x = currentPoint.getX();
		newObstacle.y = currentPoint.getY();
		
		
		return newObstacle;
	}
	
	/*
	 * Method adds a new obstacle to the board
	 * by adding an obstacle to the array list
	 * by calling the obstacle creator method.
	 */
	public void addObstacle()
	{
		obstacles.add(obstacleCreator());
	}
	
	/*
	 * Method returns the array of obstacles.
	 */
	public ArrayList<Rectangle> getObstacles()
	{
		return obstacles;
	}
	
	/*
	 * The paint method draws the array of obstacles
	 * at their correct location on the board with
	 * the color red.
	 */
	public void paint(Graphics2D obstacleGraphic)
	{
		for(int i = 0; i < obstacles.size(); i++)
		{
			obstacleGraphic.setColor(Color.RED);
			obstacleGraphic.fillRect(obstacles.get(i).x, obstacles.get(i).y, WIDTH, HEIGHT);
		}
	}
}
