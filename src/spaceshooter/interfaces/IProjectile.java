/**
 * Created by wasliebob, on 29 jul. 2014, at 12:22:17
 * Licensed under CC BY-NC-SA 3.0,
 * For more info visit http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB!
 */
package spaceshooter.interfaces;

public interface IProjectile {
	public int getX();
	
	public int getY();
	
	public int getMaxY();
	
	public int getSpeed();
	
	public double getDamage();
	
	public void onImpact(ILiving living);
	
	public void onUpdate();
	
	public void draw();
		
}