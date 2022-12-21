import java.security.SecureRandom;
import java.util.Scanner;

public abstract class Grup {

    public static SecureRandom random = new SecureRandom();
    public static Scanner klavye= new Scanner(System.in);

    public abstract String [][] grupNumaralari(int i);
    public abstract void gruplariYazdir();

    public void quiz(String[][] konu){
        klavye.nextLine();
        System.out.println("\nDoğru cevaplar 1 puan, yanlış cevaplar 0.");
        int [] dizi = diziyiBosIntDizisineCevir(konu);
        int sayi;
        int toplam=0;
        for (int i = 0; i < konu.length; i++) {
            sayi = randomSayiUret(konu, dizi);
            System.out.print("\n"+ (i+1) +"/" +konu.length+ "\t" + konu[sayi][0]);
            dizi[sayi] = sayi;
            klavye.nextLine(); //enter a basma işlemi
            System.out.println("Cevap: "+konu[sayi][1]);
            System.out.print("Puan:");
            toplam = toplam + kullanicidanCevapAl();
            klavye.nextLine();
        }
        skor(toplam,konu);
    }
    public int kullanicidanCevapAl(){
        boolean continueLoop=true;
        int sayi;
        do {
            sayi= klavye.nextInt();
                if (sayi == 1 || sayi == 0){
                    continueLoop=false;
                }
                else System.out.print("1 veya 0 giriniz:");
        } while (continueLoop);
        return sayi;
    }
    public void skor(int dogruSayisi, String [][] konu){
        System.out.println("\nBildiğiniz kelime sayısı: "+ dogruSayisi);
        System.out.println("Bilemediğiniz kelime sayısı: "+ (konu.length-dogruSayisi));
        System.out.println("Toplam kelime sayısı: "+konu.length);
        System.out.printf("Doğru cevaplama oranınız: %%% .0f %n",((double) dogruSayisi/ (double) konu.length)*100);
    }
    public String [][] grupSecimi(int sayac, Grup konu){
        String [][] birlesmis=new String[0][0];
        for (int i = 0; i < sayac; i++) {
            if (sayac==1){
                System.out.print("1. konu:");
                return konu.grupNumaralari(klavye.nextInt());
            }
            else {
                System.out.print(i+1 +". konu:");
                birlesmis= grupBirlestir(konu.grupNumaralari(klavye.nextInt()), birlesmis);
            }
        }
        return birlesmis;
    }
    public String [][] grupBirlestir(String [][] birincil, String [][] ikincil){
        int uzunluk=birincil.length + ikincil.length;
        String [][] yeniDizi=new String [uzunluk][2];
        System.arraycopy(birincil, 0, yeniDizi, 0, birincil.length);
        int baslangic= birincil.length;
        System.arraycopy(ikincil, 0, yeniDizi, baslangic, ikincil.length);
        return yeniDizi;
    }
    public int randomSayiUret(String[][] konu, int[] dizi) {
        boolean cekilmisMi = false;
        int sayi = random.nextInt((konu.length));
        do {
            for (int i = 0; i < konu.length; i++) {
                if (dizi[i] == sayi) {
                    cekilmisMi = true;
                    break;
                } else cekilmisMi = false;
            }
            if (cekilmisMi) sayi =random.nextInt((konu.length));
        } while (cekilmisMi);
        return sayi;
    }
    public int[] diziyiBosIntDizisineCevir(String[][] konu) {
        int[] dizi = new int[konu.length];
        for (int i = 0; i < konu.length; i++) {
            dizi[i] = i+1000;
        }
        return dizi;
    }


}
