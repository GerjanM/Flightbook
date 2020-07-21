package FBData;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import FB.Plane;


public class FBMapper {

    private PreparedStatement pselectplanes = null;
    //private PreparedStatement pselecttracks = null;
    private Connection con = null; // verbinding met gegevensbank

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
    public void sluitVerbinding() {
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
            //pselecttracks = con.prepareStatement("SELECT * FROM Track WHERE cd = ?");
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
    public ArrayList<Plane> leesAllePlanes() throws FBException {
        ArrayList<Plane> planes = new ArrayList<>();
        try {
            ResultSet res = pselectplanes.executeQuery();
            while (res.next()) {
                String name = res.getString(1);
                int weight = res.getInt(2);
                String remarks = res.getString(3);
                //int jaar = res.getInt(4);
                //String genre = res.getString(5);
                Plane plane = new Plane(name, weight, remarks);
                planes.add(plane);
            }
        }
        catch (SQLException e) {
            throw new FBException("Fout bij het inlezen van de Planes.");
        }
        return planes;
    }

    /**
     * Geeft tracks bij een gegeven cd
     * @param cd de cd
     * @return de tracks bij de cd
     * @throws CDException
     */

  /*
  public ArrayList<Track> leesTracks(CD cd) throws CDException {
    ArrayList<Track> tracks = new ArrayList<>();
    try {
      pselecttracks.setString(1, cd.getCode());
      ResultSet res = pselecttracks.executeQuery();
      while (res.next()) {
        int nr = res.getInt(3);
        String titel = res.getString(4);
        String artiest = res.getString(5);
        tracks.add(new Track(nr, titel, artiest));
      }
    }
    catch (SQLException e) {
      throw new FBException("Fout bij het inlezen van de tracks van een cd.");
    }
    return tracks;
  }

  */

}
