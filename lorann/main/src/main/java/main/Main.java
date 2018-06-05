package main;

import java.io.IOException;
import java.sql.SQLException;

import controller.ControllerFacade;
import controller.IController;
import model.IModel;
import model.ModelFacade;
import view.ViewFacade;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Corentin Hangard, Christophe Chichmanian, Charlotte Bénard, François Mouton
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method
     *
     * @param args
     *            the arguments
     * @throws InterruptedException
     * 		for the sleep method and the start method
     * @throws IOException 
     * 		if the image of a sprite doesn't exist
     * @throws SQLException 
     * 		if the sql query fails
     */
    public static void main(final String[] args) throws InterruptedException, IOException, SQLException {
    	final Menu menu = new Menu();
    	while (menu.choix == false)
			Thread.sleep(10);
    	final IModel model = new ModelFacade(menu.level);
    	final ViewFacade view = new ViewFacade(model.getLevel(), model.getMyCharacter(), model.getPurses(), model.getMonsters(), model.getEnergyBall(), model.getDoor(), model.getSpell());
        final IController controller = new ControllerFacade(view, model);
        
        view.setOrderPerformer(controller.getOrderPerformer());
        controller.start();
    }

}
