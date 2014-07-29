/**
 * Created by wasliebob, on 29 jul. 2014, at 12:22:17
 * Licensed under CC BY-NC-SA 3.0,
 * For more info visit http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB!
 */
package spaceshooter.main;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import spaceshooter.entities.EntityPlayer;
import spaceshooter.helpers.LevelHelper;
import spaceshooter.helpers.RenderingHelper;
import spaceshooter.levels.LevelBase;

public class SpaceShooter{
	public static void main(String[] arg){
		SpaceShooter display = new SpaceShooter();
		player = new EntityPlayer(100);
		level = 0;
		LevelHelper.level.put(level, new LevelBase());

		display.init();
	}
	public int numb;
	public static EntityPlayer player;
	public static int level;
	
	public void init(){
		try{
			Display.setDisplayMode(new DisplayMode(RenderingHelper.xSize, RenderingHelper.ySize));
			Display.setTitle("Space Shooter");
			Display.sync(60);
			Display.create();
		}catch (LWJGLException e){
			e.printStackTrace();
			System.exit(0);
		}		
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, RenderingHelper.xSize, 0, RenderingHelper.ySize, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
				
		while(!Display.isCloseRequested()){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			LevelHelper.level.get(level).setup();
			LevelHelper.level.get(level).generateLevel();
			
			player.handleInput();
			player.draw();
			player.onUpdate();
			
			Display.update();
		}
		Display.destroy();
	}
}