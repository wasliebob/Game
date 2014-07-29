/**
 * Created by wasliebob, on 29 jul. 2014, at 12:22:17
 * Licensed under CC BY-NC-SA 3.0,
 * For more info visit http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB!
 */
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
