//
// Project 2
// Name: Brendan Doyle
// E-mail: bjd54@georgetown.edu
// Instructor: Singh
// COSC 150
//
// In accordance with the class policies and Georgetown's Honor Code,
// I certify that, with the exceptions of the lecture and Blackboard
// notes and those items noted below, I have neither given nor received
// any assistance on this project.
//
// Description: <Describe your program>
//


package bjd54P2;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * The Game class extends JFrame
 * and controls the logic of the game.
 * The GUI is initiated and the main 
 * method is implemented in the Game class.
 */
public class Game extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Board board;
	private int score;
	
	JLabel currentLevel;
	JLabel currentScore;
	
	/*
	 * The Constructor initializes a new board
	 * object and adds it to the frame. The 
	 * GUI initialization is then called.
	 */
	public Game() 
	{
		try {
			board = new Board(this);
			add(board);
			
			score = 0;
			
			initGameGUI();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	/*
	 * The GUI initialization sets the size of the frame,
	 * makes it visible, closes the program on exit, 
	 * places the window in the middle of the screen, 
	 * and sets the title of the frame to Snake. The
	 * play method is then called.
	 */
	public void initGameGUI() throws InterruptedException
	{
		
		setSize(318, 380);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Snake");

		play();
		
	}
	
	/*
	 * The play method contains the game logic. It also
	 * creates labels of the current level and score. Changes
	 * to the difficulty are expressed at the start of each level
	 * in the level label. The game Thread sleeps each time it iterates
	 * and the amount of time that the thread sleeps shortens as score
	 * and levels increase. This speeds up the snake.
	 */
	public void play() throws InterruptedException
	{
		currentLevel = new JLabel("Level 1");
		
		currentScore = new JLabel("Score: " + getScoreString());
		
		while(true)
		{		
			add(currentLevel, BorderLayout.NORTH);
			add(currentScore, BorderLayout.SOUTH);
			
			currentScore.setText("Score: " + getScoreString());
		
			board.play();
		
			if(score < 11)
			{
				Thread.sleep(100);
			
				if (score >= 0 && score < 4)
				{
					currentLevel.setText("Level 1 Help Your "
							  + "Snake Eat The Green Apples!");
				}
				else
				{
					currentLevel.setText("Level 1");
				}
			}
		
			else if (score > 10 && score < 20)
			{
				Thread.sleep(90);
			
				if (score >= 10 && score < 13)
				{
					currentLevel.setText("Level 2 Don't Hit "
								       + "The Red Obstacles!");
				}
				else
				{
					currentLevel.setText("Level 2");
				}
			}
		
			else if (score >= 20 && score < 40)
			{
				Thread.sleep(80);
			
				if (score >= 20 && score < 22)
				{
					currentLevel.setText("Level 3 Faster Now!");
				}
				else
				{
					currentLevel.setText("Level 3");
				}	
			}
		
			else if (score >= 40 && score < 50)
			{
				Thread.sleep(70);
			
				if (score >= 40 && score < 43)
				{
					currentLevel.setText("Level 4 Even Faster!");
				}
				else
				{
					currentLevel.setText("Level 4");
				}	
			}
			
			else if (score >= 50)
			{
				Thread.sleep(60);
			
				if (score >= 50 && score < 52)
				{
					currentLevel.setText("Final Level Max Out Your Score!");
				}
				else
				{
					currentLevel.setText("Final Level");	
				}
			}
		} // ends game logic while loop
		
		
	}
		
	/*
	 * The game over method ends the game. It displays an option pane
	 * with the user's score and gives them the option to start a new
	 * game of close the program.
	 */
	public void gameOver()
	{
		String message = "Game Over\n Score: " + score + "\n Play again?";
		int answer = JOptionPane.showConfirmDialog(this, message, "Game Over", JOptionPane.YES_NO_OPTION);
		
		if (answer == JOptionPane.YES_OPTION)
		{
			setVisible(false);
			
			//try {
				new Game();
			//} catch (InterruptedException e) {
				//e.printStackTrace();
			//}
			
		}
		else
		{
			System.exit(ABORT);
		}
	}
	
	/*
	 * Method increments the score of the game. The score
	 * increments everytime the snake eats the food object.
	 */
	public void incrementScore()
	{
		score = score + 1;
	}
	
	/*
	 * The method returns the score of the game.
	 */
	public int getScore()
	{
		return score;
	}
	
	/*
	 * The getScoreString method converts the score
	 * integer to a string so that it can be used in the
	 * label on the frame.
	 */
	public String getScoreString()
	{
		return Integer.toString(score);	
	}

	//The main thread invokes a Game object starting the game.
	public static void main(String[] args) throws InterruptedException 
	{
		new Game();			
	}
	
}
