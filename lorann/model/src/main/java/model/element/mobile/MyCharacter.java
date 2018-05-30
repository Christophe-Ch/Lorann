package model.element.mobile;

import java.io.IOException;

import model.ILevel;
import model.Permeability;
import model.Sprite;

public class MyCharacter extends Mobile{
	
	private static Sprite lorann_b = new Sprite(' ', "lorann_b");
	private static Sprite lorann_bl = new Sprite(' ' ,"lorann_bl");
	private static Sprite lorann_br = new Sprite(' ' ,"lorann_br");
	private static Sprite lorann_l = new Sprite(' ' ,"lorann_l");
	private static Sprite lorann_r = new Sprite(' ' ,"lorann_r");
	private static Sprite lorann_u = new Sprite(' ' ,"lorann_u");
	private static Sprite lorann_ul = new Sprite(' ' ,"lorann_ul");
	private static Sprite lorann_ur = new Sprite(' ' ,"lorann_ur");
	
	private static Sprite[] sprites;
	
	public MyCharacter(int x, int y, ILevel level) throws IOException {
		super(lorann_r, Permeability.BLOCKING, level);
		
		sprites = new Sprite[8];
		
		lorann_b.loadImage();
		lorann_bl.loadImage();
		lorann_br.loadImage();
		lorann_l.loadImage();
		lorann_u.loadImage();
		lorann_ul.loadImage();
		lorann_ur.loadImage();
		
		sprites[0] = lorann_r;
		sprites[1] = lorann_br;
		sprites[2] = lorann_b;
		sprites[3] = lorann_bl;
		sprites[4] = lorann_l;
		sprites[5] = lorann_ul;
		sprites[6] = lorann_u;
		sprites[7] = lorann_ur;
	}

	@Override
	public void doNothing() {
		int index = 0;
		for(int i = 0; i < sprites.length; i++) {
			if(sprites[i] == this.getSprite()) {
				index = i;
			}
		}
		
		if(index < 6)
			this.setSprite(sprites[index + 1]);
		else
			this.setSprite(sprites[0]);
		
		this.setHasMoved();
	}
	
	@Override
	public void moveLeft() {
		super.moveLeft();
		this.setSprite(lorann_l);
	}
	
	@Override
	public void moveRight() {
		super.moveRight();
		this.setSprite(lorann_r);
	}
	
	@Override
	public void moveUp() {
		super.moveUp();
		this.setSprite(lorann_u);
	}
	
	@Override
	public void moveDown() {
		super.moveDown();
		this.setSprite(lorann_b);
	}

}
