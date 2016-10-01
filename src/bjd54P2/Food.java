package bjd54P2;

import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

/*
 * The food class creates a rectangular
 * object on the board at a random place
 * with the color green. If the snake head
 * has the same coordinates as the food object,
 * the food will be moved to a new random location.
 */
public class Food {

	private Rectangle snakeFood;
	private Point currentPoint;
	
	
	private static int WIDTH = 10;
	private static int HEIGHT = 10;
	private Board board;
	
	/*
	 * The Default constructor is just for unit testing
	 * purposes.
	 */
	public Food()
	{
		
		snakeFood = new Rectangle();
		currentPoint = new Point();
		
		setFoodLocation();
		
	}
	
	/*
	 * Constructor initializes the rectangle object
	 * of the food and a point object it will be located at.
	 * It sets an initial random location for the food.
	 */
	public Food(Board board)
	{
		this.board = board;
		
		snakeFood = new Rectangle();
		currentPoint = new Point();
		
		setFoodLocation();
		
	}
	
	/*
	 * Set food location places the food rectangle
	 * at a random place on the board by calling
	 * the random function to get random integers
	 * for x and y coordinates of the rectangle.
	 * The coordinates are then scaled to match
	 * the height and width of the board.
	 */
	public void setFoodLocation()
	{
		Random randomCoordinate = new Random();
		
		int randomX = randomCoordinate.nextInt(30);
		int randomY = randomCoordinate.nextInt(30);
		
		randomX = randomX * WIDTH;
		randomY = randomY * HEIGHT;
		
		currentPoint.setX(randomX);
		currentPoint.setY(randomY);
		
		snakeFood.x = currentPoint.getX();
		snakeFood.y = currentPoint.getY();
		
	}
	
	/*
	 * Method returns the rectangle that is the
	 * food object.
	 */
	public Rectangle getSnakeFood()
	{
		return snakeFood;
	}
	
	public Point getCurrentPoint()
	{
		return currentPoint;
	}
	
	/*
	 * Method moves the snakeFood rectangle by
	 * calling the setFoodLocation method.
	 */
	public void move()
	{
		setFoodLocation();
	}
	
	/*
	 * The paint method draws the snakeFood on the Board
	 * in its current location with the color green.
	 */
	public void paint(Graphics2D foodGraphic)
	{
		foodGraphic.setColor(Color.GREEN);
		foodGraphic.fillRect(snakeFood.x, snakeFood.y, WIDTH, HEIGHT);
	}
	
}
