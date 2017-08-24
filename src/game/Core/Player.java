package game.Core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Player extends GameObject{
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
		rotation = 0;
	}

	public void tick() {
		if(x > GameCore.WIDTH-100 || x < 0){
			velX *= -1;
		}
		if(y > GameCore.HEIGHT-100 || y < 0){
			velY *= -1;
		}
		x += velX;
		y += velY;
		velX += aX;
		velY += aY;
		rotation += angularV;
		if(Math.floor(Math.abs(velX)) == 0.0 && friction){
			aX = 0.0;
			velX = 0.0;
		}
		if(Math.floor(Math.abs(velY)) == 0.0 && friction){
			aY = 0.0;
			velY = 0.0;
		}
		if(velX > 0.0 && friction)
			aX = -1.0;
		if(velX < 0.0 && friction)
			aX = 1.0;
		if(velY > 0.0 && friction)
			aY = -1.0;
		if(velY < 0.0 && friction)
			aY = 1.0;
		if(rotation < 0){
			rotation += 360;
		}
		if(rotation >= 360){
			rotation -= 360;
		}
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.rotate(Math.toRadians(rotation), x + 64 / 2, y + 32 / 2);
		g2d.fillRect(x, y, 100, 100);
	}
}
