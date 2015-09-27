package com;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;



public class BouncingBall extends Applet implements Runnable{

	int x,y,dx,dy,sizeX,sizeY,diam;
	boolean drawSquare=false;
	public void init()
	{
		x=150;
		y=50;
		dx=dy=5;
		sizeX=1000;
		sizeY=500;
		diam=20;
		setBackground(Color.black);
		(new Thread(BouncingBall.this)).start();
	}
	

	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		//if(!drawSquare)
		{
			g.setColor(Color.white);
			g.drawRect(150,50,sizeX,sizeY);
			drawSquare=true;
		}
		g.fillArc(x,y,diam,diam,0,360);
	}
	
	@Override
	public void run() {
		while(true)
	{  
		try 
		  {
		        Thread.sleep(40);
		  }
		 catch (InterruptedException e) 
		 {
			e.printStackTrace(); 
		 }
		      x+=dx; 
		      y+=dy;
		      
		      if ((x<=150)||(x+diam>=sizeX+150)) 
		    	  dx=-dx;
		      if ((y<=50)||(y+diam>=sizeY+50)) 
		    	  dy=-dy;
		    	  
		      repaint();
		    }
	}
}

