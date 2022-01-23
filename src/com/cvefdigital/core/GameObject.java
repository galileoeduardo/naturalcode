package com.cvefdigital.core;

import java.awt.Graphics;

import com.cvfdigital.main.Game;

public class GameObject {
	
	public Vector2D position = new Vector2D(0,0);
	public Vector2D velocity = new Vector2D(0,0);
	public Vector2D acceleration = new Vector2D(0,0);
	public float mass = 1f;
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
	
	public void ApplyForce(Vector2D force) {
		force.Div(mass);
		acceleration.Add(force);
	}

	public void Update() {
		// TODO Auto-generated method stub
		
	}

	public void Render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	public void BounceOutOfBounds() {
		
		if (Game.Screen.IsOutOfBoundsLeft(position.getX())) {
			velocity.x = velocity.x * -1;
			position.setX(0);
		} else if (Game.Screen.IsOutOfBoundsRight(position.getX() - getWidth())) {
			velocity.x = velocity.x * -1;
			position.setX(Game.Screen.WIDTH);
		}
		if (Game.Screen.IsOutOfBoundsTop(position.getY())) {
			velocity.y = velocity.y * -1;
			position.setY(0);
		} else if (Game.Screen.IsOutOfBoundsBottom(position.getY() - getHeight())) {
			velocity.y = velocity.y * -1;
			position.setY(Game.Screen.HEIGHT);
		}
	
	}
	
	public void SeedOtherSide() {
		
		if (Game.Screen.IsOutOfBoundsLeft(position.getX())) {
			position.setX(Game.Screen.WIDTH - getWidth());
		} else if (Game.Screen.IsOutOfBoundsRight(position.getX() + getWidth())) {
			position.setX(0);
		}
		
		if (Game.Screen.IsOutOfBoundsTop(position.getY())) {
			position.setY(Game.Screen.HEIGHT - getHeight());
		} else if (Game.Screen.IsOutOfBoundsBottom(position.getY() + getWidth())) {
			position.setY(0);
		}
		
	}

}
