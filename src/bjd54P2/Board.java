package bjd54P2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/*
 * The Board Class extends JPanel
 * and it controls the checking of 
 * scenarios that would constitute
 * a game over, the moving of the snake, and the
 * painting of the board.
 */
public class Board extends JPanel {
	
	Snake snake;
	Food food;
	Obstacle obstacle;
	
	private static int boardWIDTH = 300;
	private static int boardHEIGHT = 300;
	
	private Game gameOfSnake;
	
	/*
	 * The Constructor initializes the board panel.
	 * It sets the panel color to light gray and 
	 * initializes the snake, food, and obstacle
	 * objects to be put on the board. It controls
	 * the checking of scenarios that would constitute
	 * a game over, the moving of the snake, and the
	 * painting of the board.
	 */
	public Board(Game game)
	{
		this.gameOfSnake = game;
		this.setBackground(Color.LIGHT_GRAY);
		setVisible(true);
		snake = new Snake(this);
		food = new Food(this);
		obstacle = new Obstacle(this);
		
		initListeners();
	}
	
	/*
	 * Method initializes the key listener.
	 */
	public void initListeners() 
	{
		KeyListener listener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				snake.keyPressed(e);
			}
		};
		
		addKeyListener(listener);
		
		setFocusable(true);
	}
	
	/*
	 * The play method paints the current logic
	 * of the game, checks whether the snake
	 * has collided with obstacles, eaten
	 * the food, or if the food and an obstacle
	 * overlap with one another. The snake is then
	 * moved.
	 */
	public void play() throws InterruptedException
	{
			repaint();
			
			checkingObstacleCollision();
			eatsFoodCheck();
			overlappingObstacleCheck();
			
			snake.move();

	}
	
	/*
	 * The paint method paints the board. It is the super method of
	 * the paint methods of the snake, food, and obstacle objects.
	 */
	@Override
	public void paint(Graphics theGraphic)
	{
		super.paint(theGraphic);
		Graphics2D the2DGraphic = (Graphics2D) theGraphic;
		the2DGraphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
									  RenderingHints.VALUE_ANTIALIAS_ON);
		
		snake.paint(the2DGraphic);
		food.paint(the2DGraphic);
		obstacle.paint(the2DGraphic);
		
	}
	
	/*
	 * This method checks whether the snake has 
	 * collided with an obstacle. If the snake head shares 
	 * the same coordinates as an obstacle, than it is
	 * game over.
	 */
	public void checkingObstacleCollision()
	{
		
		for(int i = 0; i < obstacle.getObstacles().size(); i++)
		{
			if(snake.getBody().get(0).x == obstacle.getObstacles().get(i).x &&
			   snake.getBody().get(0).y == obstacle.getObstacles().get(i).y)
			{
				gameOver();
			}
		}
		
	}
	
	/*
	 * This method checks whether the snake has eaten the food.
	 * If the snake head and food share coordinates, than the 
	 * food is moved, the score is incremented, and a new rectangle
	 * is added to the snake body. If the score is greater than ten,
	 * than a new obstacle is also created.
	 */
	public void eatsFoodCheck()
	{
		if(snake.getBody().get(0).x == food.getSnakeFood().x &&
		   snake.getBody().get(0).y == food.getSnakeFood().y)
		{
			food.move();
			incrementScore();
			snake.addToTail();
			
			if (gameOfSnake.getScore() > 10)
			{
				obstacle.getObstacles().add(obstacle.obstacleCreator());
			}
		}
	}
	
	/*
	 * Method checks to see if the current food location overlaps with 
	 * any obstacles. If it does, the food object is moved to a new
	 * location.
	 */
	public void overlappingObstacleCheck()
	{
		for(int i = 0; i < obstacle.getObstacles().size(); i++)
		{
			if(obstacle.getObstacles().get(i).x == food.getSnakeFood().x &&
			   obstacle.getObstacles().get(i).y == food.getSnakeFood().y)
			{
				food.move();
			}
		}
	}
	
	/*
	 * Method returns the width of the board.
	 */
	public int getWidth()
	{
		return boardWIDTH;
	}
	
	/*
	 * Method returns the height of the board.
	 */
	public int getHeight()
	{
		return boardHEIGHT;
	}
	
	/*
	 * Method calls the game over method of the
	 * game object.
	 */
	public void gameOver()
	{
		gameOfSnake.gameOver();
	}
	
	/*
	 * Method calls the score incrementing method of
	 * the game object.
	 */
	public void incrementScore()
	{
		gameOfSnake.incrementScore();
	}
	
}
