/**
 * Created by wasliebob, on 29 jul. 2014, at 12:22:17
 * Licensed under CC BY-NC-SA 3.0,
 * For more info visit http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB!
 */
package spaceshooter.helpers;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class ResourceHelper {
	/** PNG Formatted
	 * @param location
	 * Texture location and texture name (without extension)
	 */
	public static Texture getTexture(String location){
		Texture texture = null;
        try{
        	texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(location + ".png"));
        }
        catch(IOException ioe){
            System.out.println(ioe);
        }
        return texture;
	}
}