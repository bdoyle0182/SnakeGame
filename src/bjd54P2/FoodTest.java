package bjd54P2;

import static org.junit.Assert.*;

import org.junit.Test;

public class FoodTest {

	private Food testFood = new Food();
	@Test
	public void testSetFoodLocation() {

		assertEquals(testFood.getSnakeFood().x, 
				     testFood.getCurrentPoint().getX(), 0);
		
		assertEquals(testFood.getSnakeFood().y, 
			         testFood.getCurrentPoint().getY(), 0);
		
		assertTrue(testFood.getSnakeFood().x <= 300);
		assertTrue(testFood.getSnakeFood().y <= 300);
	}

}
