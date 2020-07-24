package FB;

public class Plane {
    String name = null;
    int weight = 0;
    String remarks = null;

    public Plane(String name, int weight,String remarks) {
        this.name=name;
        this.weight=weight;
        this.remarks=remarks;
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
}
