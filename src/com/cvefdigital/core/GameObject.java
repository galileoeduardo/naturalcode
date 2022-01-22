package com.cvefdigital.core;

public class GameObject {
	
	public Vector2D position = new Vector2D(0,0);
	public Vector2D velocity;
	public Vector2D acceleration;
	private int width = 0;
	private int height = 0;
	
	public GameObject() {}

	public GameObject(int x,int y,int width,int height) {
		this.position.setX(x);
		this.position.setY(y);
		this.setWidth(width);
		this.setHeight(height);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
