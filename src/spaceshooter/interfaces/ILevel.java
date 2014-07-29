package spaceshooter.interfaces;

import java.util.HashMap;

import spaceshooter.entities.EntityEnemy;

public interface ILevel {
	public void setup();
	
	public HashMap<Integer, EntityEnemy> getEnemyMap();
	
	public void addEnemy(int x, int y);
	
	public void generateLevel();
	
	public void onCompletion();
	
	public void reset();
}
