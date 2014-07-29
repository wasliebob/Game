package spaceshooter.entities.bullets;

import org.lwjgl.opengl.GL11;

import spaceshooter.helpers.RenderingHelper;
import spaceshooter.interfaces.ILiving;
import spaceshooter.interfaces.IProjectile;
import spaceshooter.main.SpaceShooter;

public class EntityPlayerBullet implements IProjectile{
	public EntityPlayerBullet(double damage){
		this.speed = 2;
		this.damage = damage;
		
		this.x = SpaceShooter.player.x + ((SpaceShooter.player.width - width) / 2);
		this.y = SpaceShooter.player.y + SpaceShooter.player.height;
		
		this.width = 5;
		this.height = 50;
		
		this.maxY = RenderingHelper.ySize;
	}
	public double damage;
	public int speed;

	public int x, y;
	public int width, height;
	
	public int maxY;	
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public int getMaxY() {
		return this.maxY;
	}

	@Override
	public int getSpeed() {
		return this.speed;
	}

	@Override
	public double getDamage() {
		return this.damage;
	}

	@Override
	public void onImpact(ILiving living){

	}

	@Override
	public void onUpdate() {
		this.y += this.speed;
	}

	@Override
	public void draw() {        
		GL11.glPushMatrix();
	
		GL11.glColor3d(0, 100, 100);
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(x, y);
			GL11.glVertex2f(x + width, y);
			GL11.glVertex2f(x + width, y + height);
			GL11.glVertex2f(x, y + height);
		GL11.glEnd();
		
		GL11.glPopMatrix();
	}
}