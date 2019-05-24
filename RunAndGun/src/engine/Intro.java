package engine;

import org.newdawn.slick.font.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;


public class Intro extends BasicGameState{
	
	private final Image background = Resources.getImage("SpaceBackground1");
	private final String GREETING = "Press Enter To Begin";

	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		background.draw();
		
		g.drawString(GREETING, (1920 / 2) - ((GREETING.length() / 2) * 9), 1080 / 2);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int arg2) throws SlickException {
		if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			s.enterState(States.SELECTION);
		}
	}

	@Override
	public int getID() {
		return States.INTRO;
	}

}