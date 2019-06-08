package engine;
import java.util.HashMap;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Resources {
	
	private static HashMap<String, Image> images;
	
	public Resources(){
		
		images = new HashMap<String, Image>();
		
		try {
			
			images.put("robokips", loadImage("resources/robokips.png"));
			images.put("chinatown", loadImage("resources/chinatown_resized.png"));
			
			images.put("idle1", loadImage("resources/idle/sprite1.png"));
			images.put("idle2", loadImage("resources/idle/sprite2.png"));
			images.put("idle3", loadImage("resources/idle/sprite3.png"));
			
			images.put("moving1", loadImage("resources/moving/sprite1.png"));
			images.put("moving2", loadImage("resources/moving/sprite2.png"));
			images.put("moving3", loadImage("resources/moving/sprite3.png"));
			images.put("moving4", loadImage("resources/moving/sprite4.png"));
			images.put("moving5", loadImage("resources/moving/sprite5.png"));
			images.put("moving6", loadImage("resources/moving/sprite6.png"));
			images.put("moving7", loadImage("resources/moving/sprite7.png"));
			images.put("moving8", loadImage("resources/moving/sprite8.png"));
			images.put("moving9", loadImage("resources/moving/sprite9.png"));
			
			images.put("shooting1", loadImage("resources/shooting/sprite1.png"));
			images.put("shooting2", loadImage("resources/shooting/sprite2.png"));
			
			images.put("crouching1", loadImage("resources/crouching/sprite1.png"));
			images.put("crouching2", loadImage("resources/crouching/sprite2.png"));
			images.put("crouching3", loadImage("resources/crouching/sprite3.png"));
			images.put("crouching4", loadImage("resources/crouching/sprite4.png"));
			images.put("crouching5", loadImage("resources/crouching/sprite5.png"));
			
			


			
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	private Image loadImage(String path) throws SlickException {		
		return new Image(path, false, Image.FILTER_NEAREST);
	}
	
	public static Image getImage(String name) {
		return images.get(name).copy();
	}

}
