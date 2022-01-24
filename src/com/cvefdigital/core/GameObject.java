package com.cvefdigital.core;

import java.awt.Graphics;

import com.cvfdigital.main.Game;

public class GameObject {
	
	public Vector2D position = new Vector2D(0f,0f);
	public Vector2D velocity = new Vector2D(0f,0f);
	public Vector2D acceleration = new Vector2D(0f,0f);
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
		this.width = width  * Game.SCALE;
	}

	public int getHeight() {
		return height * Game.SCALE;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void ApplyForce(Vector2D force) {
		Vector2D f = Vector2D.Div(force,mass);
		this.acceleration.Add(f);
	}
	
	public void Update() {
		// TODO Auto-generated method stub
		
	}
	
	public void Update(Vector2D mouse) {
		// TODO Auto-generated method stub
		
	}

	public void Render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	public void BounceOutOfBounds() {
		if (Game.Screen.IsOutOfBoundsLeft(this.position.getX())) {
			this.velocity.x *= -1;
			this.position.setX(0);
		} else if (Game.Screen.IsOutOfBoundsRight(this.position.getX(),this.getWidth())) {
			this.velocity.x *= -1f;
			this.position.setX(Game.Screen.WIDTH - this.getWidth());
		}
		
		if (Game.Screen.IsOutOfBoundsTop(this.position.getY())) {
			this.velocity.y *= -1f;
			this.position.setY(0);
		} else if (Game.Screen.IsOutOfBoundsBottom(this.position.getY(),this.getHeight())) {
			this.velocity.y *= -1;
			this.position.setY(Game.Screen.HEIGHT - this.getHeight());
		}
	
	}
	
	public void SeedOtherSide() {
		
		if (Game.Screen.IsOutOfBoundsLeft(position.getX())) {
			position.setX(Game.Screen.WIDTH - getWidth());
		} else if (Game.Screen.IsOutOfBoundsRight(position.getX(),getWidth())) {
			position.setX(0);
		}
		
		if (Game.Screen.IsOutOfBoundsTop(position.getY())) {
			position.setY(Game.Screen.HEIGHT - getHeight());
		} else if (Game.Screen.IsOutOfBoundsBottom(position.getY(),getWidth())) {
			position.setY(0);
		}
		
	}

}
