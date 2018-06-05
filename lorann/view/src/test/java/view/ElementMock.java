package view;

import java.awt.Image;

import model.IElement;
import model.Permeability;
import model.Sprite;

public abstract class ElementMock implements IElement{
	
	private Sprite sprite;
	
	public ElementMock() {
		this.sprite = new Sprite(' ', "floor");
	}

	@Override
	public Sprite getSprite() {
		return this.sprite;
	}

	@Override
	public Permeability getPermeability() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
