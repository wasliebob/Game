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