package com.cvefgigital.entities;

import java.awt.Graphics;

import com.cvefdigital.core.GameObject;
import com.cvefdigital.core.Vector2D;
import com.cvfdigital.main.Game;
import com.cvfdigital.main.SpriteSheet;

public class BasketBall extends GameObject {

	public Vector2D wind;
	public Vector2D gravity;
	
	public BasketBall(float x, float y) {
		super(Math.round(x),Math.round(y),16,16);
		this.mass = 10f;
		wind = new Vector2D(0.001f,0.001f);
		gravity = new Vector2D(0.001f,0.01f);
	}
	
	public void Update() {
		BounceOutOfBounds();
		
		float c = 0.001f;
		float normal = 1f;
		float frictionMag = c*normal;

		Vector2D friction = new Vector2D(0,0);
		friction.SetLocation(velocity);
		friction.Mult(-1f);
		friction.Normalize();
		friction.Mult(frictionMag);
		
		this.ApplyForce(friction);
		this.ApplyForce(gravity);
		this.ApplyForce(wind);
		
		this.velocity.Add(this.acceleration);
		this.velocity.LimitX(1.5f);
		this.velocity.LimitY(5f);
		this.position.Add(velocity);
		
		String console = String.valueOf("ac.x:" + acceleration.x + "\n");
		console += String.valueOf("ac.y:" + acceleration.y + "\n");
		console += String.valueOf("v.x:" + velocity.x + "\n");
		console += String.valueOf("x.y:" + velocity.y + "\n");
		Game.debug.setText(console);
	}
	
	public void Render(Graphics g) {
		g.drawImage(
				SpriteSheet.getSprite(32, 0, 16,16),
				position.getX(), position.getY(), getWidth(), getHeight(),
				null
		);
	}
	
	

}

