/**
 * Created by wasliebob, on 29 jul. 2014, at 12:22:17
 * Licensed under CC BY-NC-SA 3.0,
 * For more info visit http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB!
 */
package spaceshooter.entities;

import org.lwjgl.opengl.GL11;

import spaceshooter.interfaces.ILiving;
import spaceshooter.interfaces.IObject;

public class EntityEnemy implements ILiving{
	public EntityEnemy(int x, int y, double health){
		this.health = health;
		this.time = 200;

		this.x = x;
		this.y = y;
		
		this.width = 50;
		this.height = 50;
	}
	public double health;
	public double damage;
	int time;
	
	public int x, y;
	public int width, height;
	
	@Override
	public double getHealth(){
		return this.health;
	}
	
	@Override
	public void damage(double value){
		this.health = this.health - value;
	}

	@Override
	public void heal(double value) {
		this.health = this.health + value;
	}

	@Override
	public void handleInput() {
		
	}
	
	@Override
	public void onUpdate() {

	}

	@Override
	public void draw() {        
		GL11.glPushMatrix();
		
		GL11.glColor3d(100, 0, 0);
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(x, y);
			GL11.glVertex2f(x + width, y);
			GL11.glVertex2f(x + width, y + height);
			GL11.glVertex2f(x, y + height);
		GL11.glEnd();
		
		GL11.glPopMatrix();
	}

	@Override
	public void onCollision(IObject obj) {
		
	}

	@Override
	public void onCollision(ILiving entity) {
		
	}
}