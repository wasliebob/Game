package spaceshooter.helpers;

public class EntityHelper {
	public boolean isColliding(int start, int end, int value){
		return MathHelper.isBetween(start, end, value);
	}
}