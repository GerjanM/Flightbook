package FBController;

import FBData.FBException;
import FBDomein.Flightbook;

import java.util.ArrayList;

//hier de GUI starten, en ook je flightbook. hier moeten ook de methoden instaan die de GUI aan kan roepen om de data op te halen.
public class FBController {
    Flightbook FB = new Flightbook();
    public FBController() throws FBException {
    }

//vanuit hier start je de controller, die vervolgens alles regelt.
    public static void main(String[] args) throws FBException {
        FBController contr = new FBController();


    }

}
