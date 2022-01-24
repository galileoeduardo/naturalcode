package com.cvefdigital.core;

import java.util.Random;

public class Vector2D {

	public float x;
	public float y;
	
	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return Math.round(x);
	}
	
	public int getY() {
		return Math.round(y);
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void SetLocation(Vector2D vector) {
		this.x = vector.x;
		this.y = vector.y;
	}
	
	public void Add(Vector2D vector) {
		this.x += vector.x;
		this.y += vector.y;
	}
	
	public void Sub(Vector2D vector) {
		this.x -= vector.x;
		this.y -= vector.y;
	}
	
	public void Mult(float n) {
		this.x *= n;
		this.y *= n;
	}
	
	public void Div(float n) {
		this.x /= n;
		this.y /= n;
	}
	public float MagSqrt() {
		return x*x + y*y;
	}
	
	public float Mag() {
		float m = (float)Math.sqrt(MagSqrt());
		return m;
	}
	
	public void Normalize() {
		 float m = this.Mag();
		 if (m != 0) {
		   this.Mult(1 / m);
		 }
    }
	
	public void LimitX(float max) {
		if(Math.abs(this.x) >= max) {
			this.x  = max;
		}
	}
	
	public void LimitY(float max) {
		if(Math.abs(this.y) >= max) {
			this.y  = max;
		}
	}
	
	public void Limit(float max) {
		float mSq = this.MagSqrt();
		
		  if (mSq > max * max) {
		    this.Div((float)Math.sqrt(mSq));
		    this.Mult(max);
		  }
	}
	
	public static Vector2D Add(Vector2D v1,Vector2D v2) {
		Vector2D v3 = new Vector2D(v1.x + v2.x, v1.y + v2.y);
	    return v3;
	}
	
	public static Vector2D Sub(Vector2D v1,Vector2D v2) {
		Vector2D v3 = new Vector2D(v1.x - v2.x, v1.y - v2.y);
	    return v3;
	}
	
	public static Vector2D Div(Vector2D force, float mass) {
		return new Vector2D(force.x/mass,force.y/mass);
	}
	
	public static Vector2D Random2D(float max,float min) {
		
		Random rand = new Random();
		float randX = rand.nextFloat() * (max - min) + min;
	    float randY = rand.nextFloat() * (max - min) + min;
		
	    return new Vector2D(randX,randY);
	}


}
