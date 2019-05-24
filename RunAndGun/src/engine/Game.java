package engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import components.Player;

public class Game extends BasicGameState{
	
	public static int delta;
	
	
	private Image back = Resources.getImage("chinatown");
	
	private static int offset;
	
	private Player p = new Player();
	
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {

		offset = 0;
		delta = 1;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {

		offset = offset % back.getWidth();
		
		if(offset + 1920 > back.getWidth()) {
			
			
			back.getSubImage(offset, 0, back.getWidth() - offset, 1080).draw();
			
			back.getSubImage(0, 0, 1920 - (back.getWidth() - offset), 1080).draw(1920 - (1920 - (back.getWidth() - offset)), 0);
			
			
		}else {
			back.getSubImage(offset, 0, 1920, 1080).draw();
		}
		
		p.render(g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int d) throws SlickException {
		delta = d;
		
		p.update(gc);
		
	}
	
	public static void addOffset(int add) {
		offset += add;
	}

	@Override
	public int getID() {
		return States.GAME;
	}
	

}
