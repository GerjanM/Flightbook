package FBGUI;

import FBDomein.Flight;
import java.util.logging.Logger;
//import java.util.logging.LoggerFactory;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


public class FBGui {
    private static final Logger LOGGER = Logger.getLogger(FBGui.class.getName());

    public void displayGiant(Flight flight) {
        LOGGER.info(flight.toString());
    }
}
