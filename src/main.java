

public class main {
    public static void main(String[] args) {
        Festmeny festmeny = new Festmeny("hómező","Bálint Ferenc", "expresszionizmus");
        for (int i =0;i<15;i++){
            festmeny.licit();
            System.out.println(festmeny.getLegmagasabblicit());
        }
    }
}
