package FBTest;

import java.util.ArrayList;

import FBData.FBException;
import FBData.FBMapper;
import FB.Plane;

/**
 * DIverse testjes om te kijken of het ophalen van gegevens uit de database
 * werkt.
 *
 * @author gerjan
 *
 */
public class FBMapperTest {
    public static void main(String[] args) throws FBException {
        FBMapper mapper = new FBMapper();
        ArrayList<Plane> planes = mapper.leesAllePlanes();
        Plane plane = planes.get(0);
        System.out.println("1" + plane);
        System.out.println(plane.getName()+plane.getRemarks()+plane.getWeight());
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
