import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import  java.util.Collections;




public class Test {

    public static void pozisyonSec() {

    }

    public static void main(String[] args) {


//Futbolcu seçimi hem bilgisayar hem kullanıcı tarafından yapılır. Cristiano Ronaldo ve Lionel Messi
//seçilmiş olsun. ---->>>>>Polimorfizm devreye girer:

        //Sporcu kartlarını oluşturma

        List<Sporcu> deste = new ArrayList<>();
        deste.add(new Futbolcu("Ronaldo", "Juventus", 95, 90, 90));
        deste.add(new Futbolcu("Lionel Messi", "Barça", 100, 75, 90));
        deste.add(new Futbolcu("Neymar", "Barça", 90, 95, 95));
        deste.add(new Futbolcu("Robert Lewandowski", "Dortmunt", 95, 100, 95));
        deste.add(new Futbolcu("Kevin De Bruyne", "Man City", 88, 90, 85));
        deste.add(new Futbolcu("Mohamed Salah", "Liverpool", 85, 88, 90));
        deste.add(new Futbolcu("Virgil van Dijk", "Liverpool", 80, 85, 88));
        deste.add(new Futbolcu("Kylian Mbappe", "PSG", 92, 80, 90));

        deste.add(new Basketbolcu(85, 85, 85, "LeBron James", "Lakers"));
        deste.add(new Basketbolcu(90, 90, 90, "Stephen Curry", "Warriors"));
        deste.add(new Basketbolcu(88, 85, 89, "Kevin Durant", "Nets"));
        deste.add(new Basketbolcu(84, 80, 82, "James Harden", "76ers"));
        deste.add(new Basketbolcu(82, 78, 80, "Kobe Bryant", "Lakers"));
        deste.add(new Basketbolcu(90, 88, 85, "Michael Jordan", "Bulls"));
        deste.add(new Basketbolcu(85, 80, 83, "Giannis Antetokounmpo", "Bucks"));
        deste.add(new Basketbolcu(88, 86, 87, "Shaquille O'Neal", "Lakers"));


        //kartlar karıştı;
        Collections.shuffle(deste);
        //kullanıcı ve bilgiseyarı oluşturduk:
        Kullanıcı kullanıcı = new Kullanıcı("0", "Ati PC", 0);
        Bilgisayar bilgisayar = new Bilgisayar("1", "Furki", 0);

        //kartları dağıtmamamız lazım ki arraylist boş kalmasın!!!!!!!
        int i=0;
        for(;i<deste.size();i++) {
            if(i%2==0){
                kullanıcı.getKartListesi().add(deste.get(i));
            }else{
                bilgisayar.getKartListesi().add(deste.get(i));
            }
        }

        while ((!kullanıcı.getKartListesi().isEmpty()&&!bilgisayar.getKartListesi().isEmpty())) {
            Sporcu kullanıcıKart = kullanıcı.kartSec();
            Sporcu bilgisayarKart = bilgisayar.kartSec();
            //kullanıcının ve bilgiseyarın seçtiği kartlar;
            System.out.println("Kullanıcı kartı: " + kullanıcıKart.toString());
            System.out.println("Bilgisayar kartı: " + bilgisayarKart.toString());

            int kullanıcıPuan = 0;
            int bilgisayarPuan = 0;

            if (kullanıcıKart instanceof Futbolcu && bilgisayarKart instanceof Futbolcu) {
                Futbolcu kullanıcıFutbolcu = (Futbolcu) kullanıcıKart;
                Futbolcu bilgisayarFutbolcu = (Futbolcu) bilgisayarKart;
                kullanıcıPuan = kullanıcıFutbolcu.getPenaltı() + kullanıcıFutbolcu.getSerbestAtis() + kullanıcıFutbolcu.getKaleciKarsiKarsiya();
                bilgisayarPuan = bilgisayarFutbolcu.getPenaltı() + bilgisayarFutbolcu.getSerbestAtis() + bilgisayarFutbolcu.getKaleciKarsiKarsiya();
            } else if (kullanıcıKart instanceof Basketbolcu && bilgisayarKart instanceof Basketbolcu) {
                Basketbolcu kullanıcıBasketbolcu = (Basketbolcu) kullanıcıKart;
                Basketbolcu bilgisayarBasketbolcu = (Basketbolcu) bilgisayarKart;
                kullanıcıPuan = kullanıcıBasketbolcu.getIkilik() + kullanıcıBasketbolcu.getSerbestAtis() + kullanıcıBasketbolcu.getUcluk();
                bilgisayarPuan = bilgisayarBasketbolcu.getIkilik() + bilgisayarBasketbolcu.getSerbestAtis() + bilgisayarBasketbolcu.getUcluk();
            }


            if (kullanıcıPuan > bilgisayarPuan) {
                kullanıcı.setSkor(kullanıcı.getSkor() + 10);
                System.out.println("Turu kazanan: Kullanıcı!");
            } else if (bilgisayarPuan > kullanıcıPuan) {
                bilgisayar.setSkor(bilgisayar.getSkor() + 10);
                System.out.println("Turu kazanan: Bilgisayar!");
            } else {
                System.out.println("Bu tur berabere!");
            }

            kullanıcı.SkorGoster();
            bilgisayar.SkorGoster();

        }


        //Kazanan:

        System.out.println("Oyun bitti....");

        if(kullanıcı.getSkor()>bilgisayar.getSkor()) {
            System.out.println("Kullancı oyunu kazandı!");
        } else if (bilgisayar.getSkor()>kullanıcı.getSkor()) {
            System.out.println("Kazanan bilgiseyar!");
        }
        else {
            System.out.println("Berabere...");


    }






    }
}