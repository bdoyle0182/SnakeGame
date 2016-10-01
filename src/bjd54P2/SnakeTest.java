package bjd54P2;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Test;

public class SnakeTest {

	//private Game testGame = new Game();
	//private Board testBoard = new Board(testGame);
	private Snake testSnake = new Snake();
	
	@Test
	public void testAddToTail() {
		
		testSnake.addToTail();
		assertEquals(16, testSnake.getBody().size(), 0);
	}
	
	@Test
	public void testGetBody() {
		
		Rectangle testRectangle = new Rectangle(10, 10);
		
		for (int i = 0; i < 15; i++)
		{
			assertEquals(testSnake.getBody().get(i).getHeight(), 
					     testRectangle.getHeight(), 0);
			
			assertEquals(testSnake.getBody().get(i).getWidth(),
						 testSnake.getBody().get(i).getWidth(), 0);
			
			
		}
	}
	
	@Test
	public void testInitialLocation() {
		
		assertEquals(160, testSnake.getBody().get(0).x, 0);
		assertEquals(200, testSnake.getBody().get(0).y, 0);
	}
		
	
	

}
