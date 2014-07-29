package spaceshooter.entities;

import java.util.HashMap;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import spaceshooter.entities.bullets.EntityPlayerBullet;
import spaceshooter.helpers.LevelHelper;
import spaceshooter.helpers.MathHelper;
import spaceshooter.helpers.RenderingHelper;
import spaceshooter.interfaces.ILiving;
import spaceshooter.interfaces.IObject;
import spaceshooter.interfaces.IProjectile;
import spaceshooter.main.SpaceShooter;

public class EntityPlayer implements ILiving{
	public EntityPlayer(double health){
		this.health = health;
		
	    this.speed = 50;

		this.x = RenderingHelper.xSize / 2 - 50;
		this.y = 50;
				
		this.width = 50;
		this.height = 50;
		
		this.minX = 0;
		
		this.maxX = RenderingHelper.xSize;
	}
	public double health;
	public int speed;
	public IProjectile projectile;
	
	public int x, y;
	public int width, height;
	
	public int minX, maxX;
	
	@Override
	public double getHealth() {
		return this.health;
	}

	@Override
	public void damage(double value) {
		this.health -= value;
	}

	@Override
	public void heal(double value) {
		this.health += value;		
	}

	@Override
	public void handleInput(){
		while(Mouse.next()){
			if(Mouse.getEventButtonState()){
				if(Mouse.isButtonDown(0)){
					spawnProjectile();
				}
			}
		}
		
		while(Keyboard.next()){
			if(Keyboard.getEventKeyState()){	
				if(Keyboard.isKeyDown(Keyboard.KEY_D)){
					if(canMove(x + speed, y)){
						this.x += speed;
					}
				}
				
				if(Keyboard.isKeyDown(Keyboard.KEY_S)){
					if(canMove(x - speed, y)){
						this.x -= speed;
					}
				}
			}
		}
	}
	
	public boolean canMove(int x, int y){
		int mX = this.maxX;
		int minX = 0 - speed;
		
		return MathHelper.isBetween(minX, mX, x);
	}
	
	public void spawnProjectile(){
		projectile = new EntityPlayerBullet(20);
	}

	@Override
	public void onUpdate() {
		if(projectile != null){
			HashMap<Integer, EntityEnemy> enemies = LevelHelper.level.get(SpaceShooter.level).getEnemyMap();
			if(enemies != null && !enemies.isEmpty()){
				for(EntityEnemy enemy : enemies.values()){
					int x = enemy.x;
					int y = enemy.y;
					if(projectile.getX() == x && projectile.getY() == y){
						projectile.onImpact(enemy);
					}
				}
			}else if(projectile.getY() < projectile.getMaxY()){
				projectile.draw();
				projectile.onUpdate();
			}else if(projectile != null && projectile.getY() >= projectile.getMaxY()){
				projectile = null;
			}
		}
	}

	@Override
	public void draw(){       	
		GL11.glColor3d(0, 0, 100);
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(x, y);
			GL11.glVertex2f(x + width, y);
			GL11.glVertex2f(x + width, y + height);
			GL11.glVertex2f(x, y + height);
		GL11.glEnd();
	}

	@Override
	public void onCollision(IObject obj){		
	}

	@Override
	public void onCollision(ILiving entity) {
	}
}