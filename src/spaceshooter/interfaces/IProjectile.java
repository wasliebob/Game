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