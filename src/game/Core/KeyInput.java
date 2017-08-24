package game.Core;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	private Handler handler;
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(GameObject temp : handler.object){
			if(temp.getID() == ID.Player){
				if(key == KeyEvent.VK_W){
					temp.toggleFriction(false);
					temp.setaX(Math.cos(Math.toRadians(temp.getRotation()))*5);
					temp.setaY(Math.sin(Math.toRadians(temp.getRotation()))*5);
				}
				if(key == KeyEvent.VK_A){
					temp.setAngularV(-5);
				}
				if(key == KeyEvent.VK_D){
					temp.setAngularV(5);
				}
			}
		}
	}
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(GameObject temp : handler.object){
			if(temp.getID() == ID.Player){
				if(key == KeyEvent.VK_W){
					temp.toggleFriction(true);
					temp.setaX(0);
					temp.setaY(0);
				}
				if(key == KeyEvent.VK_A){
					temp.setAngularV(0);
				}
				if(key == KeyEvent.VK_D){
					temp.setAngularV(0);
				}
			}
		}
	}
}
