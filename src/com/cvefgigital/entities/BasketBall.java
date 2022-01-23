package com.cvefgigital.entities;

import java.awt.Graphics;

import com.cvefdigital.core.GameObject;
import com.cvefdigital.core.Vector2D;
import com.cvfdigital.main.Game;
import com.cvfdigital.main.SpriteSheet;

public class BasketBall extends GameObject {

	public Vector2D wind = new Vector2D(0.01f,0);
	public Vector2D gravity = new Vector2D(0,0.1f);
	
	
	public BasketBall(float x, float y) {
		super(Math.round(x),Math.round(y),16,16);
		mass = 1.5f;
	}
	
	public void Update() {
		BounceOutOfBounds();
		ApplyForce(wind);
		ApplyForce(gravity);
		velocity.Add(acceleration);
		position.Add(velocity);
		
	}
	
	public void Render(Graphics g) {
		
		g.drawImage(
				SpriteSheet.getSprite(32, 0, getWidth(),getHeight()),
				position.getX(), position.getY(), getWidth(), getHeight(),
				null
		);
	}
	
	

}

