package spaceshooter.levels;

import java.util.HashMap;

import spaceshooter.entities.EntityEnemy;
import spaceshooter.helpers.RenderingHelper;
import spaceshooter.interfaces.ILevel;

public class LevelBase implements ILevel{
	public LevelBase(){
	}
	public HashMap<Integer, EntityEnemy> enemies = new HashMap<Integer, EntityEnemy>();
	public int id;
	
	@Override
	public void setup() {
		addEnemy(RenderingHelper.xSize - 50, RenderingHelper.ySize - 50);
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