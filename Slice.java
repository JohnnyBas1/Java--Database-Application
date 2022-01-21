package application;

import java.util.HashMap;
import java.util.Map;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.scene.transform.NonInvertibleTransformException;

public class Slice {
	
	private MyPoint tlc = new MyPoint();
	private GraphicsContext board;
	MyColor background;
	private Map<Character, Integer> data = new HashMap<>();
	private double size;
	private int n;
	
	Slice(GraphicsContext gc, Map<Character, Integer> map)
	{	
		tlc.setPoint(gc.getCanvas().getWidth()/2, gc.getCanvas().getHeight()/2);
		board = gc;
		background = MyColor.GREEN;
		data = map;
	}
	Slice(MyPoint point, GraphicsContext gc, MyColor color, Map<Character, Integer> map, double tamano, int events)
	{
		tlc.setPoint(point);
		board = gc;
		background = color;
		size = tamano;
		pointToMap(map);
		n = events;
	}
	
	
	public void pointToMap(Map<Character, Integer> map)
	{
		data = map;
	}
	public double totalEntries()
	{
		
		double total = 0;
		for(Map.Entry<Character, Integer> entry : data.entrySet())
		{
			total += entry.getValue();
		}
		return total;
	}
	public void drawlegend(String s, int spacing, double prob)
	{
		board.fillRect(tlc.getX()+(size), tlc.getY()+spacing, 5, 5);
		board.fillText(s, tlc.getX()+(size)+10, tlc.getY()+spacing+5);
		board.fillText(String.valueOf(prob), tlc.getX()+size+45, tlc.getY()+spacing+5);
	}
	
	public String toString()
	{		
		double prob; 
		double prob_acc = 0;
		double angle2 = 0;
		int count = 0;
		
		String ret = "Values\n";
		
		for(Map.Entry<Character, Integer> entry: data.entrySet())
		{
			//Finds how many events to care for.
			if(count == n)
			{
				prob = 1-prob_acc;
				angle2 = (2*Math.PI*prob) *(180/Math.PI);
				ret += ("All other events. Probability: " +prob + " Angle " +angle2);
				return ret;

			}
			
			MyColor random = background.pick(count);
			board.setFill(random.getFXColor());
			prob = (double)entry.getValue()/totalEntries();
			//For 1 - probability
			prob_acc += prob;
			//gets size of slice proportional to the probability of that event
			angle2 = (2*Math.PI*prob) *(180/Math.PI);
			//Needed for drawing text.
			String s = String.valueOf(entry.getKey());
			//Draws the slice
			ret += ( s + "  Probability: " + prob + "  Angle:  " +angle2 +"\n");
			count++; 
		}
		return ret;
		
	}
	
	public void draw() throws NonInvertibleTransformException
	{
		board.setFill(background.getFXColor());
		
		double prob; 
		double prob_acc = 0;
		double angle = 0; //starting angle that increases with each entry
		double angle2 = 0;
		
		int spacing = 0;
		int count = 0;
		
		for(Map.Entry<Character, Integer> entry: data.entrySet())
		{
			//Finds how many events to care for.
			if(count == n)
			{
				prob = 1-prob_acc;
				angle2 = (2*Math.PI*prob) *(180/Math.PI);
				board.setFill(MyColor.GREY.getFXColor());
				board.fillArc(tlc.getX(), tlc.getY(), size, size, angle, angle2, ArcType.ROUND);
				drawlegend("Other", spacing, prob);
				break;
			}
			
			MyColor random = background.pick(count);
			board.setFill(random.getFXColor());
			prob = (double)entry.getValue()/totalEntries();
			//For 1 - probability
			prob_acc += prob;
			//gets size of slice proportional to the probability of that event
			angle2 = (2*Math.PI*prob) *(180/Math.PI);
			//Needed for drawing text.
			String s = String.valueOf(entry.getKey());
			//Draws the slice
			double small = Math.min(board.getCanvas().getHeight(), board.getCanvas().getHeight());
			board.fillArc(tlc.getX(), tlc.getY(), size%(small), size%(small), angle, angle2, ArcType.ROUND);
			angle += angle2;
			// Draws the legend
			drawlegend(s, spacing, prob);
			spacing += 20;
			count++; 
			
		}
	}
	
}
