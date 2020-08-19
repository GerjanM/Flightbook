package FBController;

import FBData.FBException;
import FBDomein.Flightbook;
import FBGUI.FBGui;

public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(String[] args) throws FBException {
        // create model, view and controller
        Flightbook fb = new Flightbook();
        FBGui fbgui = new FBGui();
        FBController contr = new FBController(fb,fbgui);
        //FBGUI gui = new FBGUI();

        // initial display
        //controller.updateView();
        // controller receives some interactions that affect the giant
        //controller.setHealth(Health.WOUNDED);
        //controller.setNourishment(Nourishment.HUNGRY);
        //controller.setFatigue(Fatigue.TIRED);
        // redisplay
        //controller.updateView();
    }
}
