package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyPoint {
	private double x1, y1;
	
	MyPoint() // no args constructor
	{
		this.x1 = 0;
		this.y1 = 0;
	}
	MyPoint(double x, double y) //constructor with point inputs
	{
		this.x1 = x;
		this.y1 = y;
	}
	MyPoint(MyPoint p)
	{
		this.x1 = p.getX();
		this.y1 = p.getY();
	}
	
	public void setPoint(MyPoint point) //sets point using MyPoint type
	{
		this.x1 = point.getX();
		this.y1 = point.getY();
	}
	public void setPoint(double x, double y) // sets point using double type
	{
		this.x1 = x;
		this.y1 = y;
	}

	public void setX(double x) // sets x coordinate
	{
		this.x1 = x;
	}
	
	public void setY(double y) // sets y coordinate
	{
		this.y1 = y;
	}
	public double getX() // gets x coordinate
	{
		return this.x1;
	}
	public double getY() // gets y coordinate
	{
		return this.y1;
	}
	
	public double lengthto(MyPoint p2)// finds length of this.point to p2.
	{
		double xdistance = this.getX() - p2.getX();
		double ydistance = this.getY() - p2.getY(); 
		return Math.hypot(xdistance, ydistance);
	}
	
	public void draw(GraphicsContext gc)
	{
		gc.setFill(Color.PINK);
		gc.fillRect(x1, y1, 2, 2);
	}
	
	
}


/*
 * I have getX, getY, setPoint, set y and x
 * and lengths of two points
 * 
 * 
 */

