import java.util.*;
import java.io.*;


public class Pliki {
    public ArrayList<Integer> odczyt() throws IOException
    {
        BufferedReader plik = null;
        String linia;
        ArrayList<Integer> dane = new ArrayList<>();
        plik = new BufferedReader(new FileReader("szachownica.txt"));
        linia = plik.readLine();
        String [] pomoc = new String[4];
        pomoc = linia.split(" ");
        dane.add(Integer.parseInt(pomoc[0]));
        dane.add(Integer.parseInt(pomoc[1]));
        dane.add(Integer.parseInt(pomoc[2]));
        dane.add(Integer.parseInt(pomoc[3]));
        plik.close();
        return  dane;
    }


    public void zapis(boolean czy, ArrayList<Integer> wynikib, String opis) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("wynik.txt");
        if(czy == true) {
            zapis.println("Tak");
            int i;
            for (i = 0; i<(wynikib.size()/2); i++)
            {
                zapis.println(wynikib.get(2*i) + " " + wynikib.get(2*i + 1));
            }
        }
        else
            zapis.println("Nie" + opis);
        zapis.close();
    }
}

