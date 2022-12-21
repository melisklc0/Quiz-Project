public class GrupListesi extends Grup {

    public GrupListesi(){}

// -------------------------------- LİSTELER ---------------------------------

// yeni grup eklediğiniz zaman aşağıda olduğu gibi grubu listelere eklemelisiniz. (2 listeye de)
// direkt kopyala yapıştır yapıp isim ve numarasını değiştirmeniz yeterlidir.
// grup sildiğiniz zaman da aynı şekilde bu listelerden silmelisiniz yoksa hata verir.
// bunlar haricinde kodların geri kalanına dokunmayınız.


    @Override
    public String [][] grupNumaralari(int numara){
        return switch (numara) {
            case 1 -> ornek_Grup;
            case 2 -> ornek_Grup_2;
            case 3 -> ornek_Kelimeler;


            default -> throw new IllegalArgumentException
                    ("Lütfen geçerli bir konu numarası giriniz.");
        };
    }

    @Override
    public void gruplariYazdir(){
        System.out.println("""


                ------ GRUP LİSTESİ ADI ------
                
                  1 -> Örnek Grup 1
                  2 -> Örnek Grup 2
                  3 -> Örnek Kelimeler
                                   
                  """);
    }

// -------------------------------- GRUPLAR ---------------------------------

// Yeni grup oluşturmak için aşağıda çizgiyle belirlenmiş aralığı komple kopyala - yapıştır yapmanız gerekiyor.
// Grupları örnekteki gibi doldurabilirsiniz. (tırnak içlerine yazmazsanız hata verir)

//-----------------------------------------------------------

    private final String[][] ornek_Grup={
            {"soru" , "cevap"},
            {"kelime" , "anlamı"},
            {"" , ""},
            {"" , ""}
    };

//-----------------------------------------------------------


    private final String[][] ornek_Grup_2= {
            {"soru" , "cevap"},
            {"kelime" , "anlamı"},
            {"" , ""},
            {"" , ""},
            {"" , ""},
            {"" , ""},
            {"" , ""},
            {"" , ""},
            {"" , ""},
            {"" , ""}
    };

    private final String[][] ornek_Kelimeler={
            {"accomplish","başarmak"}, {"achieve","başarmak"}, {"adjust","ayarlamak"},
            {"adequately","yeterince, yeterli şekilde"}, {"sufficently","yeterli şekilde"},
            {"admire","hayran olmak"}, {"astonishing","şaşırtıcı ,hayran bırakıcı, amazing"},
            {"anticipate","ummak, beklemek"}, {"appreciate","taktir etmek, anlamak, farkına varmak"},
            {"arrange","düzenlemek, (toplantı vs) ayarlamak"}, {"assess","değerlendirmek"}
    };
































} // burdan daha aşağısına grup eklemeyin, daima bu sınırdan yukarı tarafa ekleyin yoksa hata verir.