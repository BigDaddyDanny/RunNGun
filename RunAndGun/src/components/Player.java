package components;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import engine.Game;
import engine.Resources;

public class Player {
	
	private static final int SPEED = 5;

	
	
	private Animation idle = new Animation(new Image[] { Resources.getImage("idle1").getScaledCopy(3), Resources.getImage("idle2").getScaledCopy(3), Resources.getImage("idle3").getScaledCopy(3)}, 1000, true);
	private Animation moving = new Animation(new Image[] { Resources.getImage("moving1").getScaledCopy(3), Resources.getImage("moving2").getScaledCopy(3), Resources.getImage("moving3").getScaledCopy(3),
											Resources.getImage("moving4").getScaledCopy(3), Resources.getImage("moving5").getScaledCopy(3), Resources.getImage("moving6").getScaledCopy(3), 
											Resources.getImage("moving7").getScaledCopy(3), Resources.getImage("moving8").getScaledCopy(3), Resources.getImage("moving9").getScaledCopy(3)}, 50, true);
	
	
	private Animation shooting = new Animation(new Image[] { Resources.getImage("shooting1").getScaledCopy(3), Resources.getImage("shooting2").getScaledCopy(3)}, 75, true);
	
	private Animation preCrouch = new Animation(new Image[] { Resources.getImage("crouching1").getScaledCopy(3), Resources.getImage("crouching2").getScaledCopy(3)}, 75, true);
	
	private Animation crouching = new Animation(new Image[] { Resources.getImage("crouching3").getScaledCopy(3), Resources.getImage("crouching4").getScaledCopy(3),
												Resources.getImage("crouching5").getScaledCopy(3)}, 500, true);
	
	private boolean direction;// true == right
	
	private enum State {IDLE, MOVING, SHOOTING, PRECROUCH, CROUCH};
	private State current;
	
	private int x;
	private int y;
	
	public Player() {
		
		x = 1920 / 2;
		y = 700;
		
		current = State.IDLE;
		direction = true;
		
	}
	
	public void render(Graphics g) {
		
		switch(current) {
		
		case IDLE:
			if(direction) {
				idle.draw(x, y);
			}else {
				idle.getCurrentFrame().getFlippedCopy(true, false).draw(x, y);
				idle.update(Game.delta * 3);
			}
			break;
		case MOVING:
			if(direction) {
				moving.draw(x, y);
			}else {
				moving.getCurrentFrame().getFlippedCopy(true, false).draw(x, y);
				moving.update(Game.delta * 3);
			}
			break;
		case SHOOTING:
			if(direction) {
				shooting.draw(x, y);
			}else {
				shooting.getCurrentFrame().getFlippedCopy(true, false).draw(x, y);
				shooting.update(Game.delta * 3);
			}
						
			break;	
		case PRECROUCH:
			if(direction) {
				preCrouch.draw(x, y);
			}else {
				preCrouch.getCurrentFrame().getFlippedCopy(true, false).draw(x, y);
				preCrouch.update(Game.delta * 3);
			}
			
			if(preCrouch.getFrame() == preCrouch.getFrameCount()) {
				current = State.CROUCH;
			}
			break;
		case CROUCH:
			
			if(direction) {
				crouching.draw(x, y);
			}else {
				crouching.getCurrentFrame().getFlippedCopy(true, false).draw(x, y);
				crouching.update(Game.delta * 3);
			}
			
			break;
		}
		
	}
	
	public void update(GameContainer gc) {	
		
		int changeX = 0;
		
		if(gc.getInput().isKeyDown(Input.KEY_LEFT)){
			changeX -= SPEED;
		}
		
		if(gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
			changeX += SPEED;
		}
				
		if(x + changeX > 0 && x + changeX < 1420) {
			
			x += changeX;
			
		}else if(x + changeX > 0){
			
			Game.addOffset(changeX);
			
		}		
		
		
		if(changeX == 0) {
			current = State.IDLE;
		}else {
			current = State.MOVING;
		}
		
		if(changeX > 0) {
			direction = true;
		}else if(changeX < 0){
			direction = false;
		}
		
		
		if(gc.getInput().isKeyDown(Input.KEY_SPACE)) {
			current = State.SHOOTING;
		}
		
		if(gc.getInput().isKeyDown(Input.KEY_DOWN)) {
//			current
		}
		
	}

}
