package bjd54P2;

//Class creates an object that stores the data of a two dimensional point
public class Point {

	
	private	int x;
	private	int y;
		
	//Default Constructor sets x and y values to 0
	public Point()
	{
		x = 0;
		y = 0;
	}
	
	//Copy Constructor sets x and y values
	public Point(int xValue, int yValue)
	{
		x = xValue;
		y = yValue;
	}
	
	//Method sets the x value
	public void setX(int xValue)
	{
		x = xValue;
	}
	
	//Method sets the y value
	public void setY(int yValue)
	{
		y = yValue;
	}
	
	//Method returns the integer x value
	public int getX()
	{
		return x;
	}
	
	//Method returns the integer y value
	public int getY()
	{
		return y;
	}
	
	//Method formats and outputs a point object
	public void outputPoint()
	{
		System.out.print("(" + x + ", " + y + ") ");
	}
	

}
