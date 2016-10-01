package bjd54P2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.util.ArrayList;

/* This class creates a snake object using 
 * an array list of rectangles. the snake moves
 * one point on the grid every time the game 
 * executes. The snake object grows one rectangle
 * on its tail every time the snake eats the food
 * on the board. The snake changes direction based
 * on user input of the arrow keys.
 */
public class Snake {

	private Rectangle snakeHead;
	private ArrayList<Rectangle> snakeBody;
	
	private int currentX = 160;
	private int xDirection = -10;
	private int currentY = 200;
	private int yDirection = 0;
	
	private static int WIDTH = 10;
	private static int HEIGHT = 10;
	private Board board;
	
	boolean left = true;
	boolean right = true;
	boolean up = false;
	boolean down = false;

	/*
	 * The Default Constructor is only 
	 * used as a mean for unit testing.
	 */
	public Snake()
	{
		snakeBody = new ArrayList<Rectangle>();
		
		for(int i = 0; i < 15; i++)
		{
			Rectangle bodyPiece = new Rectangle(10, 10);
			snakeBody.add(bodyPiece);
			
			snakeBody.get(i).x = currentX;
			snakeBody.get(i).y = currentY;
			
			currentX = currentX + 10;
		
		}
	}
	
	/*
	 * Constructor initializes the components of the snake.
	 * An initial array of fifteen rectangles are created
	 * ten units apart on the x axis of the board.
	 */
	public Snake(Board board)
	{
		this.board = board;
		
		snakeBody = new ArrayList<Rectangle>();
		
		for(int i = 0; i < 15; i++)
		{
			Rectangle bodyPiece = new Rectangle();
			snakeBody.add(bodyPiece);
			
			snakeBody.get(i).x = currentX;
			snakeBody.get(i).y = currentY;
			
			currentX = currentX + 10;
		
		}
		
	}

	/*
	 * This method  moves the snake array on the board.
	 * It starts with a decision as to whether the head of
	 * the snake is still on the board, otherwise game over is
	 * called. If the head is still on the board, then each 
	 * rectangle in the array of the snake is moved over one space
	 * on the board in the current direction that the user has input. 
	 * The method also checks each time it is called that the snake has
	 * not collided with itself by calling checkingSnakeCollision.
	 */
	public void move()
	{
		if (snakeBody.get(0).x + xDirection < 300 && 
			snakeBody.get(0).y + yDirection < 300 &&
			snakeBody.get(0).x >= 0 && snakeBody.get(0).y >= 0)
		{
			
				for(int i = snakeBody.size() - 1; i > 0; i--)
				{
					snakeBody.get(i).x = snakeBody.get(i-1).x;
					snakeBody.get(i).y = snakeBody.get(i-1).y;
				}
			
				snakeBody.get(0).x = snakeBody.get(0).x + xDirection;
				snakeBody.get(0).y = snakeBody.get(0).y + yDirection;
			
				snakeHead = snakeBody.get(0);
			
				checkingSnakeCollision();
		}
		else
		{
				board.gameOver();
		}
	}
	
	/*
	 * The paint method draws each rectangle in its current
	 * position on the board with the color blue.
	 */
	public void paint(Graphics2D snakeGraphic)
	{
		for (int i = 0; i < snakeBody.size(); i++)
		{
			snakeGraphic.setColor(Color.BLUE);
			snakeGraphic.fillRect(snakeBody.get(i).x, snakeBody.get(i).y, WIDTH, HEIGHT);
			
			
		}
	}
	
	/*
	 * Method adds a rectangle to the array or the snake's
	 * body at the end of the snake.
	 */
	public void addToTail()
	{
		Rectangle bodyPiece = new Rectangle(WIDTH, HEIGHT);
		snakeBody.add(bodyPiece);
	}
	
	/*
	 * Method checks that the snake has not collided with 
	 * itself. The for loop runs through the each rectangle
	 * in the body and checks if it has the same coordinates
	 * as the snake's head. If it is, game over is called.
	 */
	public void checkingSnakeCollision()
	{
		for(int i = snakeBody.size() - 1; i > 0; i--)
		{
			if (snakeHead.x == snakeBody.get(i).x &&
				snakeHead.y == snakeBody.get(i).y)
				{
						board.gameOver();
				}
		}
	}
	
	//Method returns the entire array of rectangles
	//that make up the snake.
	public ArrayList<Rectangle> getBody()
	{
		return snakeBody;
	}
	
	//Method returns the head or front rectangle
	//of the snake.
	public Rectangle getHead()
	{
		return snakeHead;
	}
	
	/*
	 * Method changes the direction of the snake
	 * when an arrow key is pressed.
	 */
	public void keyPressed(KeyEvent directionChange)
	{
		/*
		 * If the left key is pressed and the snake is not moving right,
		 * the snake will now move left.
		 */
		if (directionChange.getKeyCode() == KeyEvent.VK_LEFT && !right)
		{
			xDirection = -10;
			yDirection = 0;
			
			left = true;
			up = false;
			down = false;
			right = false;
		}
		
		/*
		 * If the up key is pressed and the snake is not moving down,
		 * the snake will now move left.
		 */
		else if (directionChange.getKeyCode() == KeyEvent.VK_UP && !down)
		{
			xDirection = 0;
			yDirection = -10;
			
			up = true;
			left = false;
			down = false;
			right = false;
		}
		
		/*
		 * If the right key is pressed and the snake is not moving left,
		 * the snake will now move left.
		 */
		else if (directionChange.getKeyCode() == KeyEvent.VK_RIGHT && !left)
		{
			xDirection = 10;
			yDirection = 0;
			
			right = true;
			left = false;
			up = false;
			down = false;
			
		}
		
		/*
		 * If the down key is pressed and the snake is not moving up,
		 * the snake will now move down.
		 */
		else if(directionChange.getKeyCode() == KeyEvent.VK_DOWN && !up)
		{
			xDirection = 0;
			yDirection = 10;
			
			down = true;
			left = false;
			up = false;
			right = false;
		}
	}
}
