package application;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.scene.canvas.GraphicsContext;

import javafx.scene.transform.NonInvertibleTransformException;

public class MyPieChart {
	
	private MyPoint tlc = new MyPoint();
	//private  double radius;
	private double radius;
	private Map<Character, Integer> data = new HashMap<>();
	private MyColor background;
	private Slice slice;
	private GraphicsContext board;
	int n = 0;
	
	MyPieChart(double size, MyPoint position, MyColor color, GraphicsContext gc, int events)
	{
		radius = size;
		tlc.setX(position.getX() - size);
		tlc.setY(position.getY() - size);
		background = color;
		board = gc;
		n = events;
		slice = new Slice(tlc, board, background, data, radius*2, n);
		
	}
	
	public void sort(Map<Character, Integer> map) 
	{
		data = map.
				entrySet().
				stream().
				sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
				.collect(
						Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	
	public void insertData(char entry)
	{
		if (data.isEmpty())
		{
			data.put(entry, 1);
		}
		else if (data.containsKey(entry))
		{
			data.put(entry, (data.get(entry)+1));
		}
		else
		{
			data.put(entry, 1);
		}
		sort(data);
	}
	public String toString()
	{
		slice.pointToMap(data);
		return slice.toString();
	}
	
	public void draw() throws NonInvertibleTransformException
	{
		slice.pointToMap(data);
		slice.draw();
	}
}
	
