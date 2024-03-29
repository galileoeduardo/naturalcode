package com.cvefgigital.entities;

import java.awt.Color;
import java.awt.Graphics;

import com.cvefdigital.core.Vector2D;

public class Line {
	
	public Vector2D positionStart;
	public Vector2D positionEnd;
	public float mag;
	
	public Line(float sx, float sy, float ex, float ey) {
		positionStart = new Vector2D(sx,sy);
		positionEnd = new Vector2D(ex,ey);
	}
	
	public void Update(Vector2D vector) {
		
		positionEnd.SetLocation(vector);
		vector.Sub(positionStart);
		mag = vector.Mag();
	}
	
	public void Render(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawLine(positionStart.getX(), positionStart.getY(), positionEnd.getX(), positionEnd.getY());
		g.fillRect(0, 0, Math.round(mag), 10);
	}

}
