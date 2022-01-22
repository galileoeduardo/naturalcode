package com.cvfdigital.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.cvefdigital.core.Screen;
import com.cvefdigital.core.Vector2D;
import com.cvefgigital.entities.Player;
import com.cvefgigital.entities.Ball;


public class Game extends Canvas implements Runnable, MouseListener, MouseMotionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private final static int WIDTH = 177;
	private final static int HEIGHT = 100;
	private final static int SCALE = 5;
	private Thread thread;
	private boolean isRunning = false;
	private int fps;
	public static Screen Screen = new Screen(WIDTH*SCALE,HEIGHT*SCALE);
	public static JFrame console;
	public static TextArea debug;
	
	public static SpriteSheet sheets = new SpriteSheet("/spritesheet.png");;
	
	public Player player;
	public ArrayList<Ball> balls = new ArrayList<Ball>();

	public Game() {
		
		console = new JFrame("console");
		console.setPreferredSize(new Dimension(300,150));
		console.add(this);
		debug= new TextArea();  
		debug.setBounds(20,50,100,20);  
		console.add(debug);
		console.pack();
		console.setVisible(true);
		
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
        
		this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		frame = new JFrame("Natural Code");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		for(int i = 0; i < 50; i++) {
			Vector2D random = Vector2D.Random2D(0, Screen.WIDTH);
			Ball ball = new Ball(random.x,random.y);
			balls.add(ball);
		}
		
		
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		
		int frames = 0;
		double timer = System.currentTimeMillis();
		
		while(isRunning) {

			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				update();
				render();
				frames++;
				delta--;
			}
			
			if (System.currentTimeMillis() - timer >= 1000) {
				fps = frames;
				frames = 0;
				timer += 1000;
			}
			
		}
		
		stop();
		
	}
	
	public void update() {
		for(int i = 0; i < balls.size(); i++) {
			balls.get(i).update();
		}
		
	}
	
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		for(int i = 0; i < balls.size(); i++) {
			balls.get(i).render(g);
		}
		
		g.dispose();
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD,12));
		g.drawString("Fps: " + fps,WIDTH*SCALE - 50,HEIGHT*SCALE - 10);

		bs.show();
	}
	
	public void mouseClicked(MouseEvent e) {}  
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e)  {}  
    public void mousePressed(MouseEvent e) {}  
    public void mouseReleased(MouseEvent e){}
    
    @Override
    public void mouseMoved(MouseEvent e)   {
    	
    	int x = e.getPoint().x;
    	int y = e.getPoint().y;
    	
    	Vector2D mouse = new Vector2D(0,0);
    	mouse.setX(x);
    	mouse.setY(y);
    	
    	for(int i = 0; i < balls.size(); i++) {
			balls.get(i).update(mouse);
		}
    	
    }
    
    public void mouseDragged(MouseEvent e) {}

}
