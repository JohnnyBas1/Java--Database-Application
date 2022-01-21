package application;


import java.util.Random;

import javafx.scene.paint.Color;

enum MyColor {
	
	BLACK(0, 0, 0, 1), //1
	RED(255, 0, 0, 1),// 2
	BLUE(0, 0, 255, 1), //3
	GREEN(0,128, 0, 1), //4
	MAGENTA(255, 0, 255, 1), //5
	LIME(0, 255, 0, 1), //6
	PURPLE(128, 0, 128, 1), //7
	GREY(128,128,128,1);
	
	private final int red, green, blue, alpha;
	
	//alpha is transparency
	MyColor()
	{
		this.red = 0;
		this.green = 0;
		this.blue = 0;
		this.alpha = 0;
	}
	MyColor(int r, int g, int b, int a)
	{
		this.red = r;
		this.green = g;
		this.blue = b;
		this.alpha = a;
	}
	
	public int getR()
	{
		return red;
	}
	
	public int getG()
	{
		return green;
	}
	public int getB()
	{
		return blue;
	}
	
	public Color getFXColor()
	{
		return Color.rgb(red, green, blue, alpha);
	}
	
	public MyColor pick(int n)
	{
		return values()[n];
	}

	public MyColor random()
	{
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}
	
	

}

