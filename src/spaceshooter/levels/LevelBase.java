/**
 * Created by wasliebob, on 29 jul. 2014, at 12:22:17
 * Licensed under CC BY-NC-SA 3.0,
 * For more info visit http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB!
 */
package spaceshooter.levels;

import java.util.HashMap;

import spaceshooter.entities.EntityEnemy;
import spaceshooter.interfaces.ILevel;

public class LevelBase implements ILevel{
	public LevelBase(){
	}
	public HashMap<Integer, EntityEnemy> enemies = new HashMap<Integer, EntityEnemy>();
	public int id;
	
	@Override
	public void setup() {
//		addEnemy(RenderingHelper.xSize - 50, RenderingHelper.ySize - 50);
	}

	@Override
	public void addEnemy(int x, int y) {
		enemies.put(id, new EntityEnemy(x, y, 20));
		id++;
	}

	@Override
	public void generateLevel() {
		for(EntityEnemy enemy : enemies.values()){
			enemy.draw();
		}
	}

	@Override
	public void onCompletion() {
		
	}

	@Override
	public void reset() {
		
	}

	@Override
	public HashMap<Integer, EntityEnemy> getEnemyMap() {
		return this.enemies;
	}
}