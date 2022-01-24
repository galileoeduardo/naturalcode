package com.cvefgigital.entities;

import java.awt.Graphics;

import com.cvefdigital.core.GameObject;
import com.cvefdigital.core.Vector2D;
import com.cvfdigital.main.Game;
import com.cvfdigital.main.SpriteSheet;

public class Ball extends GameObject {
	 
	private Vector2D mouse = new Vector2D(0,0);	
	
	public Ball(float x, float y) {
		super(Math.round(x),Math.round(y),16,16);
		this.position = new Vector2D(x, y);
		this.velocity = new Vector2D(0f,0f);
		this.acceleration = new Vector2D(0,0);
	}
	
	public void Update() {
		BounceOutOfBounds();
		MouseFollow();
		position.Add(velocity);
	}
	
	public void Update(Vector2D mouse) {
		this.mouse.SetLocation(mouse);
	}
	
	public void Render(Graphics g) {
		g.drawImage(SpriteSheet.getSprite(0, 0, 16, 16), position.getX(), position.getY(), getWidth(), getHeight(), null);
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
	
	
}