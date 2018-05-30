package model;

import java.sql.SQLException;
import java.util.Observable;

import model.dao.LorannDAO;

public class Level extends Observable implements ILevel {
	
	private final int width = 20;
	private final int height = 12;
	
	private IElement[][] onTheLevel;
	
	public Level(int level) throws SQLException {
		super();
		this.loadLevel(level);
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public IElement getOnTheLevelXY(int x, int y) {
		return onTheLevel[x][y];
	}
	
	@Override
	public void setOnTheLevelXY(int x, int y, IElement element) {
		this.onTheLevel[x][y] = element;
	}

	@Override
	public Observable getObservable() {
		return this;
	}

	@Override
	public void setElementHasChanged() {
		this.setChanged();
		this.notifyObservers();

	}
	
	private void loadLevel(int level) throws SQLException {
		/*final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(level)));
        String line;
        int y = 0;

        this.onTheLevel = new IElement[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while ((line = buffer.readLine()) != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheRoadXY(x, y, MotionlessElementFactory.getFromFileSymbol(line.toCharArray()[x]));
            }
            y++;
        }
        buffer.close();*/
		String levelText = LorannDAO.chooseLevel(level);
		this.onTheLevel = new IElement[this.getWidth()][this.getHeight()];
		for(int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
                this.setOnTheRoadXY(x, y, MotionlessElementFactory.getFromFileSymbol(levelText.toCharArray()[x]));
            }
		}
	}

	@Override
	public boolean setSpellOnTheLevelXY(int x, int y, IElement spell) {
		if(this.getOnTheLevelXY(x, y).getPermeability() == Permeability.PENETRABLE) {
			this.onTheLevel[x][y] = spell;
			return true;
		}
		else {
			return false;
		}
	}

}
