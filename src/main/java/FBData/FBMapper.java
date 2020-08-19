package FBData;


import FBDomein.Flight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class FBMapper {

    private PreparedStatement pselectplanes = null;
    private PreparedStatement pselectflights = null;
    private Connection con = null; // verbinding met gegevensbank

    private ArrayList<String[]> selectPlanes = new ArrayList<>();


    /**
     * Maakt verbinding met de database
     * en initialiseert PreparedStatement-objecten.
     * @throws FBException
     */
    public FBMapper() throws FBException {
        maakVerbinding();
        initialiseerPrepStatements();
    }

    /**
     * Maakt verbinding met de database.
     * Eerst wordt de JDBC-driver geregistreerd door het laden van
     * de juiste implementatie van Driver; de naam van deze
     * klasse is als constante voorhanden in DBConst.
     * Er kan daardoor van driver gewisseld worden zonder deze
     * klasse aan te passen.
     * @throws FBException als de driver niet geladen kan worden
     *         of het verbinding maken mislukt (bv. door een fout in
     *         de padnaam).
     */
    private void maakVerbinding() throws FBException {
        try {
            //DriverManager.setLogWriter(new Pr   Writer(System.out));
            Class.forName(DBConst.DRIVERNAAM);
            con = DriverManager.getConnection(DBConst.URL, DBConst.GEBRUIKERSNAAM, DBConst.WACHTWOORD);
        }
        catch (ClassNotFoundException e) {
            throw new FBException("Driver niet geladen.");
        }
        catch (SQLException e) {
            throw new FBException("Verbinding maken is mislukt.");
        }
    }

    /**
     * Sluit de verbinding met de database.
     */
    private void sluitVerbinding() {
        if (con != null) {
            try {
                con.close();
                //System.out.println("Verbinding gesloten.");
            }
            catch (SQLException e) {
            }
        }
    }

    /**
     * Initialiseert twee PreparedStatements voor de
     * SQL-opdrachten om
     * - alle cd's in te lezen uit tabel CD
     * - alle tracks in te lezen bij een gegeven CD
     * @throws FBException als de SQL-opdracht een fout bevat
     *         of niet gecompileerd kan worden.
     */
    private void initialiseerPrepStatements() throws FBException {
        try {
            pselectplanes = con.prepareStatement("SELECT * FROM plane");
            pselectflights = con.prepareStatement("SELECT * FROM flight WHERE plane = ?");
        }
        catch (SQLException e) {
            //als er nu een fout optreedt, moet de verbinding eerst gesloten worden!
            sluitVerbinding();
            throw new FBException("Fout bij het formuleren van een sql-opdracht.");
        }
    }

    /**
     * Leest alle cd 's uit de database.
     * De tracks bij een cd worden nog niet gelezen.
     * @return alle CD-objecten zonder de bijbehorende tracks
     * @throws FBException
     */
    public ArrayList<String[]> leesAllePlanes() throws FBException {
        //ArrayList<Plane> planes = new ArrayList<>();

        try {
            ResultSet res = pselectplanes.executeQuery();
            while (res.next()) {
                String[] plane = new String[3];
                plane[0] = res.getString(2); //name
                plane[1] = res.getString(3); //remarks
                plane[2] = res.getString(4); //weight
                //int jaar = res.getInt(4);
                //String genre = res.getString(5);
                //Plane plane = new Plane(name, weight, remarks);
                selectPlanes.add(plane);
            }
        }
        catch (SQLException e) {
            throw new FBException("Fout bij het inlezen van de Planes.");
        }
        return selectPlanes;
    }

    /**
     * Geeft vluchten bij een gegeven plane
     * @param planename
     * @return de vluchten bij de plane
     * @throws FBException
     */


  public ArrayList<String[]> getFlights(String planename) throws FBException {
    ArrayList<String[]> flights = new ArrayList<>();
    try {
      pselectflights.setString(1, planename);
      ResultSet res = pselectflights.executeQuery();
      while (res.next()) {
          String[] flight = new String[8];
          flight[0] = ""+ (res.getInt(1));//nr
          flight[1] = res.getString(2);//accu
          flight[2] = res.getString(3);//date
          flight[3] = res.getString(4);//height
          flight[4] = res.getString(5);//motor
          flight[5] = res.getString(6);//plane
          flight[6] = res.getString(7);//remarks
          flight[7] = res.getString(8);//time
          flights.add(flight);

      }
    }
    catch (SQLException e) {
      throw new FBException("Fout bij het inlezen van de vluchten van een vliegtuig.");
    }
    return flights;
  }



}
