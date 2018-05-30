package main;

import java.io.IOException;
import controller.ControllerFacade;
import controller.IController;
import model.IModel;
import model.ModelFacade;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method
     *
     * @param args
     *            the arguments
     * @throws InterruptedException 
     * @throws IOException 
     */
    public static void main(final String[] args) throws InterruptedException, IOException {
    	final IModel model = new ModelFacade(0);
    	final ViewFacade view = new ViewFacade(model.getLevel(), model.getMyCharacter());
        final IController controller = new ControllerFacade(view, model);
        
        view.setOrderPerformer(controller.getOrderPerformer());
        controller.start();
    }

}
