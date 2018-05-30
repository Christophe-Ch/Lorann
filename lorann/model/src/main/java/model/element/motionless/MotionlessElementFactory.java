package model.element.motionless;

public abstract class MotionlessElementFactory {

	private static final ClosedDoor      closedoor     = new ClosedDoor();
	
	private static final CornerWall     cornerwall     = new CornerWall();
	
	private static final EnergyBall     energyball     = new EnergyBall();
	
	private static final Floor          floor          = new Floor();
	
	private static final HorizontalWall horizontalwall = new HorizontalWall();
	
	private static final MoneyBag       moneybag       = new MoneyBag();
	
	private static final OpenedDoor     openeddoor     = new OpenedDoor();
	
	private static final VerticalWall   verticalwall   = new VerticalWall();
	
	private static MotionlessElement[] motionlessElements = {
			closedoor,
			cornerwall,
			energyball,
			floor,
			horizontalwall,
			moneybag,
			openeddoor,
			verticalwall
	};

	public static MotionlessElement createClosedDoor() {
		return closedoor;
	}
	
	public static MotionlessElement createCornerWall() {
		return cornerwall;
	}
	
	public static MotionlessElement createEnergyBall() {
		return energyball;
	}
	
	public static MotionlessElement createFloor() {
		return floor;
	}
	
	public static MotionlessElement createHorizontalWall() {
		return horizontalwall;
	}
	
	public static MotionlessElement createMoneyBag() {
		return moneybag;
	}
	
	public static MotionlessElement createOpenedDoor() {
		return openeddoor;
	}
	
	public static MotionlessElement createVerticalWall() {
		return verticalwall;
	}
	
	/**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return floor;
    }
}
