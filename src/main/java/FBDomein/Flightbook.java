package FBDomein;

import FBData.FBException;
import FBData.FBMapper;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Flightbook {
    private FBMapper fbMap = new FBMapper();
    private ArrayList<Plane> planes = new ArrayList<>();
    ArrayList<Accu> accus = new ArrayList<>();
    ArrayList<Motor> motors = new ArrayList<>();

    public Flightbook() throws FBException {
    }

    public ArrayList<Plane> getPlanes() throws FBException {
        ArrayList<String[]> allePlanes = fbMap.leesAllePlanes();
        for (String[] ap : allePlanes) {
            Plane plane = new Plane(ap[0], parseInt(ap[1]), ap[2]);
            planes.add(plane);
        }
        return planes;
    }



    public ArrayList<Flight> getFlights(Plane name) throws FBException {
        Plane plane = null;
        for (Plane p:planes) {
            if (name.equals(p.getName())) {
            plane=p;
            }
        }
        return plane.getFlights(name);

    }
}
