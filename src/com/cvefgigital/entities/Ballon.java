package com.cvefgigital.entities;

import java.awt.Graphics;

import com.cvefdigital.core.GameObject;
import com.cvefdigital.core.Vector2D;
import com.cvfdigital.main.Game;
import com.cvfdigital.main.SpriteSheet;

public class Ballon extends GameObject {

	public Ballon(float x,float y) {
		super(Math.round(x) - 8,Math.round(y)-8,16,16);
		this.mass = 1f;
		this.velocity = new Vector2D(0f,-0.8f);
		this.acceleration = new Vector2D(0,0);
	}
	
	public void Update() {
		SeedOtherSide();
		velocity.Add(acceleration);
		velocity.Limit(3);
		position.Add(velocity);
		acceleration.Mult(0);
	}
	
	public void Render(Graphics g) {
		g.drawImage(
				SpriteSheet.getSprite(16, 0, getWidth(),getHeight()),
				position.getX(), position.getY(), getWidth(), getHeight(),
				null
		);
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
