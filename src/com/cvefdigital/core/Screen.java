package com.cvefdigital.core;

public class Screen {
	
	public int WIDTH;
	public int HEIGHT;
	public int CENTER_X;
	public int CENTER_Y;
	
	public Screen(int width, int height) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.CENTER_X =  this.WIDTH/2;
		this.CENTER_Y = this.HEIGHT/2;
	}
	
	
	
	public boolean IsOutOfBoundsLeft(int x) {
		return (x < 0);
	}
	
	public boolean IsOutOfBoundsRight(int x, int offset) {
		return (x >= WIDTH - offset);
	}
	
	public boolean IsOutOfBoundsHorizontal(int x) {
		return (x >= WIDTH) || (x < 0);
	}
	
	public boolean IsOutOfBoundsTop(int y) {
		return (y < 0);
	}
	
	public boolean IsOutOfBoundsBottom(int y, int offset) {
		return (y >= HEIGHT - offset);
	}
	
	public boolean IsOutOfBoundsVertical(int y) {
		return ((y >= HEIGHT) || (y < 0));
	}

}
