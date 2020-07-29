package FBTest;

import java.util.ArrayList;

import FBDomein.Flightbook;
import FBData.FBException;
import FBData.FBMapper;
import FBDomein.Plane;

/**
 * DIverse testjes om te kijken of het ophalen van gegevens uit de database
 * werkt.
 *
 * @author gerjan
 *
 */
public class FBMapperTest {
    public static void main(String[] args) throws FBException {
        Flightbook FB = new Flightbook();
        FBMapper mapper = new FBMapper();
        ArrayList<String[]> vliegtuigen = mapper.leesAllePlanes();
        String[] plane = vliegtuigen.get(0);
        System.out.println(plane[0]);

        ArrayList<Plane> vliegtuigen2 = FB.getPlanes();
        for (Plane vlgt:vliegtuigen2) {
            System.out.println("naam: "+ vlgt.getName()+" gewicht: "+ vlgt.getWeight()+ " remarks: " + vlgt.getRemarks());
        }


        //System.out.println(plane.getName()+plane.getRemarks()+plane.getWeight());
        //System.out.println("2" + vestiging.getPlaats());

        //ArrayList<Klant> klanten = mapper.leesKlanten();
        //Klant klant = klanten.get(5);
        //System.out.println("3" + klanten.size());
        //System.out.println("4" + klant);
       // System.out.println("5" + klant.getKlantnr());
        //System.out.println("5a" + klant.getOorsprVest());
        //System.out.println("5b" + klant.getdBZVest());
        //System.out.println("5c" + klant.getWerkelijkeVest());
        // print vestigingen
        //for (Vestiging v : vestigingen) {
         //   System.out.println("6" + v.getPlaats());
        //}
        // print klanten
        //for (Klant k : klanten) {
         //   System.out.println("7" + k.getKlantlat());
       // }
    }
}
