import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Algorytmy al = new Algorytmy();
        Pliki pli = new Pliki();
        ArrayList<Integer> daneZPliku = new ArrayList<>();
        ArrayList<Integer> daneDoPliku = new ArrayList<>();
        try {
            daneZPliku = pli.odczyt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int wymiar = daneZPliku.get(0);
        int pkt1 = daneZPliku.get(1);
        int pkt2 = daneZPliku.get(2);
        int pkt3 = daneZPliku.get(3);
        System.out.println(daneDoPliku);
        boolean t1 = al.CzyMozliwe(pkt1, pkt2, pkt3);
        if(wymiar % 2 == 0 || wymiar < 2){
            pli.zapis(false, daneDoPliku, "- wymiar tabeli jest nieprawidłowy");
        }
        else if (pkt1 < 1 || pkt3 > wymiar*wymiar){
            pli.zapis(false, daneDoPliku, "- któryś z wybranych punktów nie wchodzi w skład tabeli");
        }
        else if (t1 == false) {
            pli.zapis(false, daneDoPliku, " można wypełnić takiej planszy");
        }
        else{
            int przy = al.przypadek(pkt1,pkt2,pkt3,wymiar);
            daneDoPliku=al.sciezka(pkt1,pkt2,pkt3,wymiar,przy);
            pli.zapis(true, daneDoPliku, "OK");
        }
    }
}
