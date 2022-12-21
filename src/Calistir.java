import java.util.Scanner;
public class Calistir {

    static Scanner klavye= new Scanner(System.in);
    public static void main(String[] args) {

        GrupListesi grupListesi = new GrupListesi();
        GrupListesi_2 grupListesi_2 = new GrupListesi_2();
        GrupListesi_3 grupListesi_3 =new GrupListesi_3();
        boolean devamMi;

        do {
            int listeTipi= listeTipiAl();
            switch (listeTipi) {
                case 1 -> baslat(grupListesi);
                case 2 -> baslat(grupListesi_2);
                case 3 -> baslat(grupListesi_3);
            }
            System.out.print("""
                    
                    Devam edelim mi?
                    (1-Evet, 2-Hayır) :""");

            devamMi=devamMi(klavye.nextInt());
        } while (devamMi);
    }

    public static void baslat(Grup konu){
        konu.gruplariYazdir();
        System.out.print("Kaç tane konudan quiz olmak istiyorsunuz:");
        int sayi= klavye.nextInt();
        String [][] konular= konu.grupSecimi(sayi,konu);
        konu.quiz(konular);
    }

    public static boolean devamMi(int devamSayisi){
        if (devamSayisi==1) return true;
        else if (devamSayisi==2) return false;
        else throw new IllegalArgumentException("Yanlış sayı girdiniz.");
    }

    public static int listeTipiAl(){
        System.out.print("""
                
                1- Grup Listesi 1
                2- Grup Listesi 2
                3- Grup Listesi 3
                Seçmek istediğiniz bölümü yazınız:""");

        boolean continueLoop=true;
        int sayi;
        do {
            sayi= klavye.nextInt();
            if (sayi == 1 || sayi == 2 || sayi == 3){
                continueLoop=false;
            }
            else System.out.print("Liste numarası giriniz:");
        } while (continueLoop);
        return sayi;
    }
}

