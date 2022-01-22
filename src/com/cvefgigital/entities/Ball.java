package com.cvefgigital.entities;

import java.awt.Graphics;

import com.cvefdigital.core.GameObject;
import com.cvefdigital.core.Vector2D;
import com.cvfdigital.main.Game;
import com.cvfdigital.main.SpriteSheet;

public class Ball extends GameObject {
	 
	private Vector2D mouse = new Vector2D(0,0);	
	
	public Ball(float x, float y) {
		super(Math.round(x),Math.round(y),32,32);
		this.position = new Vector2D(x, y);
		this.velocity = new Vector2D(0f,0f);
		this.acceleration = new Vector2D(0,0);
	}
	
	public void update() {
		BounceOutOfBounds();
		MouseFollow();
		position.Add(velocity);
	}
	
	public void update(Vector2D mouse) {
		this.mouse.SetLocation(mouse);
	}
	
	public void render(Graphics g) {
		g.drawImage(SpriteSheet.getSprite(0, 0, getWidth(), getHeight()), position.getX(), position.getY(), getWidth(), getHeight(), null);
	}
	
	public void MouseFollow() {
		Vector2D dir = Vector2D.Sub(mouse,position);
		dir.Normalize();
		dir.Mult(0.5f);
		acceleration = dir;
	    velocity.Add(acceleration);
        velocity.Limit(3);
	}
	public void MoveRandom() {
		acceleration = Vector2D.Random2D(-1f,1f);
		acceleration.Mult(0.5f);
		velocity.Add(acceleration);
		velocity.Limit(2);
	}
	
	public void BounceOutOfBounds() {
		
		if (Game.Screen.IsOutOfBoundsHorizontal(position.getX())) {
			velocity.x = velocity.x * -1f;
		} else if (Game.Screen.IsOutOfBoundsVertical(position.getY())) {
			velocity.y = velocity.y * -1f;
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