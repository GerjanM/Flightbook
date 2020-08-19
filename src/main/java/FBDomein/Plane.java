package FBDomein;

import FBData.FBException;
import FBData.FBMapper;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Plane {
    private String name;
    private int weight;
    private String remarks;
    private FBMapper fbMap = new FBMapper();
    private ArrayList<Flight> flights = new ArrayList<>();


    public Plane(String name, int weight, String remarks) throws FBException {
        this.name = name;
        this.weight = weight;
        this.remarks = remarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ArrayList<Flight> getFlights(Plane plane) throws FBException {
        ArrayList<String[]> stringFlights = fbMap.getFlights(plane.getName());
        FBMapper fbMap = new FBMapper();
        for(String[] f : stringFlights) {
            Flight flight = new Flight(parseInt(f[0]),f[1],f[2],f[3],f[4],f[5],f[6],f[7]);
            flights.add(flight);
        }
        return flights;

    }
}

