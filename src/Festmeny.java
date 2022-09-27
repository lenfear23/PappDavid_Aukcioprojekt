import java.time.LocalDateTime;

public class Festmeny {
    private String cim;
    private String festo;
    private String stilus;
    private int licitekszama;
    private int legmagasabblicit;
    private LocalDateTime legutolsolicitideje;
    private boolean elkelt;

    //ALT + INSERT CONSTRUCTOR
    public Festmeny(String cim, String festo, String stilus) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
        this.licitekszama = 0;
        this.legmagasabblicit =0;
        this.legutolsolicitideje =null;
        this.elkelt = false;


    }

    //ALT + INSERT getter
    public String getCim() {
        return cim;
    }

    public String getFesto() {
        return festo;
    }

    public String getStilus() {
        return stilus;
    }

    public int getLicitekszama() {
        return licitekszama;
    }

    public int getLegmagasabblicit() {
        return legmagasabblicit;
    }

    public LocalDateTime getLegutolsolicitideje() {
        return legutolsolicitideje;
    }

    public boolean isElkelt() {
        return elkelt;
    }

    public void setElkelt(boolean elkelt) {
        this.elkelt = elkelt;
    }

    public void licit(){
        this.licit(10);
    }

    private int extracted(int ujlicit) {

        String szovegeslicit = String.valueOf(ujlicit);
        int hossz = szovegeslicit.length();
        StringBuilder veglegeslicit = new StringBuilder(szovegeslicit.substring(0,2));
        veglegeslicit.append("0".repeat(hossz - 2));
        int veglegeslicitszam = Integer.parseInt(veglegeslicit.toString());
        this.legmagasabblicit = veglegeslicitszam;

        return Integer.parseInt(veglegeslicit.toString());
    }

    public void licit(int mertek){
        if (mertek<10 || mertek>100) {
            throw new IllegalArgumentException("A licit mértéke 10 és 100% között kell hogy legyen");
        }
        if (this.elkelt){
            throw new RuntimeException("A festmény már elkelt.");
        }
        if (this.licitekszama == 0){
            this.legmagasabblicit = 100;
        }
        else{
            int ujlicit = this.legmagasabblicit*(100 + mertek) /100;
            this.legmagasabblicit =  getKerek(ujlicit);
        }
        this.licitekszama++;
        this.legutolsolicitideje = LocalDateTime.now();
    }
    private int getKerek(int ujlicit){
        int osztasok =0;
        if (ujlicit>100){
            osztasok++;
            ujlicit/=10;
        }
        ujlicit*= Math.pow(10, osztasok);
        return ujlicit;
    }
}

