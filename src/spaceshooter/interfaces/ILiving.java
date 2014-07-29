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