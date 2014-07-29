/**
 * Created by wasliebob, on 29 jul. 2014, at 12:22:17
 * Licensed under CC BY-NC-SA 3.0,
 * For more info visit http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB!
 */
package spaceshooter.interfaces;

public interface ILiving {
	public double getHealth();
	
	public void damage(double value);
	
	public void heal(double value);
	
	public void handleInput();
		
	public void onUpdate();
	
	public void draw();
	
	public void onCollision(IObject obj);
	
	public void onCollision(ILiving entity);
}