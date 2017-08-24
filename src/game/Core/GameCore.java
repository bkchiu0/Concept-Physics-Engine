package game.Core;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class GameCore extends Canvas implements Runnable{
	private static final long serialVersionUID = -1918555423816926449L;
	public static final int WIDTH = 1920, HEIGHT = 1080;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	
	public GameCore(){
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "Asteroids", this);
		
		handler.addObject(new Player(WIDTH / 2 - 50, HEIGHT/2 - 50, ID.Player));
	}
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountTicks = 60.0;
		double ns = 1000000000 / amountTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta --;
			}
			if(running){
				render();
			}
			frames ++;
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames ++;
			}
		}
		stop();
	}
	
	private void tick(){
		handler.tick();
	}
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	public static void main(String[] args){
		new GameCore();
	}
}
