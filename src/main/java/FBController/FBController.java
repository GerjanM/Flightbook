package FBController;

import FBData.FBException;
import FBDomein.Flightbook;
import FBGUI.FBGui;

import java.util.ArrayList;

//hier de GUI starten, en ook je flightbook. hier moeten ook de methoden in staan die de GUI aan kan roepen om de data op te halen.
public class FBController {
    private final Flightbook fb;
    private final FBGui fbgui;

    public FBController(Flightbook fb, FBGui fbgui) throws FBException {

        this.fb = fb;
        this.fbgui = fbgui;
    }
    //return is een ArrayList met de vluchtdatum en vluchtduur
    public ArrayList<String[]> geefVluchten(String name) {


        ArrayList<String[]> vluchten = new ArrayList<>();

  return vluchten;
}
//vanuit hier start je de controller, die vervolgens alles regelt.
    //public static void main(String[] args) throws FBException {
        //FBController contr = new FBController();


  //  }

}
