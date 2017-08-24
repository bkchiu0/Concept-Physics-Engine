package game.Core;
import java.awt.*;

public abstract class GameObject {
	protected boolean friction = true;
	protected int x, y, rotation;
	protected ID id;
	protected double velX, velY, aX, aY;
	protected int angularV;
	
	public GameObject(int x, int y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public void setID(ID id){
		this.id = id;
	}
	public ID getID(){
		return id;
	}
	
	public void setVelX(double V){
		this.velX = V;
	}
	public void setVelY(double V){
		this.velY = V;
	}
	public double getVelX(){
		return velX;
	}
	public double getVelY(){
		return velY;
	}
	
	public void setAngularV(int V){
		angularV = V;
	}
	public void setRotation(int degrees){
		rotation = degrees;
	}
	public int getAngularV(){
		return angularV;
	}
	public int getRotation(){
		return rotation;
	}
	
	public void toggleFriction(boolean value){
		friction = value;
	}
	
	public void setaX(double a){
		aX = a;
	}
	public void setaY(double a){
		aY = a;
	}
	public double getaX(){
		return aX;
	}
	public double getaY(){
		return aY;
	}
}
