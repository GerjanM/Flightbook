package FBDomein;

public class Flight {

    private int nr;
    private String accu;
    private String date;
    private String height;
    private String motor;
    private String plane;
    private String remarks;
    private String time;

    public Flight(int nr,String accu,String date,String height, String motor, String plane, String remarks, String time){
        this.nr=nr;
        this.accu = accu;
        this.date= date;
        this.height= height;
        this.motor= motor;
        this.plane= plane;
        this.remarks= remarks;
        this.time= time;

    }
}
