package model.element.mobile.auto;

import java.util.Random;

import model.ILevel;
import model.Permeability;
import model.Sprite;

public class FourthMonster extends Monster {
	
	private static Sprite sprite = new Sprite('P', "monster_4");

	public FourthMonster(ILevel level, int x, int y) {
		super(sprite, level, x, y);
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
	}

	@Override
	public int collect() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void move() {

		Random random = new Random();
		
		boolean hasMoved = false;
		
		while(!hasMoved) {
			switch(random.nextInt(4) + 1) {
				case 1:
					hasMoved = goUp();
					break;
				case 2:
					hasMoved = goDown();
					break;
				case 3:
					hasMoved = goLeft();
					break;
				case 4:
					hasMoved = goRight();
					break;
			}
		}
		
		
	}
	
	public boolean goLeft() {
		if(this.getLevel().getOnTheLevelXY(this.getX() - 1, this.getY()).getPermeability() != Permeability.BLOCKING) {
			this.moveLeft();
			return true;
		}
		return false;
			
	}
	
	public boolean goRight() {
		if(this.getLevel().getOnTheLevelXY(this.getX() + 1, this.getY()).getPermeability() != Permeability.BLOCKING) {
			this.moveRight();
			return true;
		}
		return false;
	}

	public boolean goUp() {
		if(this.getLevel().getOnTheLevelXY(this.getX(), this.getY() - 1).getPermeability() != Permeability.BLOCKING) {
			this.moveUp();
			return true;
		}
		return false;
			
	}
	
	public boolean goDown() {
		if(this.getLevel().getOnTheLevelXY(this.getX(), this.getY() + 1).getPermeability() != Permeability.BLOCKING) {
			this.moveDown();
			return true;
		}
		return false;
	}
	

}
