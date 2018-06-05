package model.element.motionless;

/**
 * The MotionlessElementFactory class
 * @author Christophe CHICHMANIAN
 *
 */
public abstract class MotionlessElementFactory {
	
	/** Instance of a CornerWall */
	private static final CornerWall     cornerwall     = new CornerWall();
	
	/** Instance of a Floor */
	private static final Floor          floor          = new Floor();
	
	/** Instance of a HorizontalWall */
	private static final HorizontalWall horizontalwall = new HorizontalWall();
	
	/** Instance of a OpenedDoor */
	private static final OpenedDoor     openeddoor     = new OpenedDoor();
	
	/** Instance of a VerticalWall */
	private static final VerticalWall   verticalwall   = new VerticalWall();
	
	/** Array of all the instances */
	private static MotionlessElement[] motionlessElements = {
			cornerwall,
			floor,
			horizontalwall,
			openeddoor,
			verticalwall
	};
	
	/** 
	 * Gets the instance of the CornerWall
	 * @return the instance of the CornerWall
	 */
	public static MotionlessElement createCornerWall() {
		return cornerwall;
	}
	
	/** 
	 * Gets the instance of the Floor
	 * @return the instance of the Floor
	 */
	public static MotionlessElement createFloor() {
		return floor;
	}
	
	/** 
	 * Gets the instance of the HorizontalWall
	 * @return the instance of the HorizontalWall
	 */
	public static MotionlessElement createHorizontalWall() {
		return horizontalwall;
	}
	
	/** 
	 * Gets the instance of the OpenedDoor
	 * @return the instance of the OpenedDoor
	 */
	public static MotionlessElement createOpenedDoor() {
		return openeddoor;
	}
	
	/** 
	 * Gets the instance of the VerticalWall
	 * @return the instance of the VerticalWall
	 */
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
