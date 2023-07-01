import java.util.*;
import java.io.*;
public class Algorytmy {
    public boolean CzyMozliwe(int m1, int m2, int m3)
    {
        if(((m1+m2+m3)%2==0) && ((m1+m2)%2==1 || (m1+m3)%2==1))
        {
            return true;
        }
        return false;
    }




    public int jakaKolumna(int m, int wym)
    {
        int pomoc = m;
        int k = 1;
        for(int i = 0; i<wym; i++){
            if(pomoc % wym == 1)
                break;
            pomoc -= 1;
            k += 1;
        }
        return k;
    }


    public int jakiWiersz(int m, int wym)
    {
        int pomoc = m;
        int w = 1;
        for (int i = 0; i < wym; i++){
            if(pomoc <= wym)
                break;
            pomoc -= wym;
            w +=1;
        }
        return w;
    }
    public int przypadek(int m1, int m2, int m3, int wym)
    {
        int km1 = jakaKolumna(m1, wym);
        int wm1 = jakiWiersz(m1, wym);
        int km2 = jakaKolumna(m2, wym);
        int wm2 = jakiWiersz(m2, wym);
        int km3 = jakaKolumna(m3, wym);
        int wm3 = jakiWiersz(m3, wym);


        if(m2 % 2 == 0){
            if(wm1 != wm2 && wm2 != wm3)
                return 1;
            if(wm2 % 2 == 1)
                return 1;
            if(wm2 % 2 == 0 && wm2 == wm3)
                return 2;
        }
        if(m1 % 2 == 0){
            if(wm1 == wm2 && wm1 % 2 == 0 && wm1 != wm3)
                return 1;
            if(wm1 == wm2 && wm1 % 2 ==1 && wm1 != wm3)
                return 2;
            if(km1 > km2){
                if(km1 < km3)
                    return 3;
                if(km1 == km3 && km1 % 2 == 0)
                    return 4;
                if(km1 == km3 && km1 % 2 == 1)
                    return 3;
            }
            if(km1 < km2){
                if(km1 > km3)
                    return 3;
                if(km1 == km3 && km1 % 2 == 0)
                    return 3;
                if(km1 == km3 && km1 % 2 == 1)
                    return 4;
            }
            if(km1 > km3){
                if(km1 < km2)
                    return 3;
                if(km1 == km2 && km1 % 2 == 0)
                    return 4;
                if(km1 == km2 && km1 % 2 == 1)
                    return 3;
            }
            if(km1 < km3){
                if(km1 > km2)
                    return 3;
                if(km1 == km3 && km1 % 2 == 0)
                    return 3;
                if(km1 == km3 && km1 % 2 ==1)
                    return 4;
            }
            if((km2 * wm2)% 2 == 1)
                return 5;
            else return 6;
        }
        if(m3 % 2 == 0){
            if(wm3 == wm2 && wm3 % 2 == 0 && wm3 != wm1)
                return 1;
            if(wm3 == wm2 && wm3 % 2 == 1 && wm3 != wm1)
                return 2;
            if(km3 > km1){
                if(km3 < km2)
                    return 3;
                if(km3 == km2 && km3 % 2 == 0)
                    return 3;
                if(km3 == km2 && km3 % 2 == 1)
                    return 4;
            }
            if(km3 < km1){
                if(km3 > km2)
                    return 3;
                if(km3 == km2 && km3 % 2 == 0)
                    return 4;
                if(km3 == km2 && km3 % 2 == 1)
                    return 3;
            }
            if(km3 > km2){
                if(km3 < km1)
                    return 3;
                if(km3 == km1 && km3 % 2 == 0)
                    return 3;
                if(km3 == km1 && km3 % 2 == 1)
                    return 4;
            }
            if(km3 < km2){
                if(km3 > km1)
                    return 3;
                if(km3 == km1 && km3 % 2 == 0)
                    return 4;
                if(km3 == km1 && km3 % 2 == 1)
                    return 3;
            }
            if((km2 * wm2)%2 == 1)
                return 7;
            else return 8;
        }
        return 0;
    }




    public ArrayList<Integer> slalom(int start, int end, int x, int y, int wymiar, int m1, int m2, int m3, int ruch, int zmiana, ArrayList<Integer> sci)
    {
        int ile = 0;
        int pomoc = 1;
        int index = start;
        int przes = 0;
        int skok = 0;
        boolean dodaj = true;
        if(ruch == 1 || ruch == 3) { //gora/dol
            if(ruch == 1)
                przes = wymiar * (-1);
            else przes =wymiar;
            ile = y;
            if(zmiana == 2) //prawo
                skok = 1;
            else skok = -1; //lewo
        }
        else {
            if (ruch == 2)
                przes = 1;
            else przes = -1;
            ile = x;
            if(zmiana == 1) //gora
                skok = wymiar * (-1);
            else skok = wymiar;
        }
        for (int i=1; i<=x*y; i++){
            if(index == m1 || index == m2 || index == m3)
                dodaj = false;
            if(dodaj == true)
                sci.add(index);
            if(dodaj == false)
                dodaj = true;
            if(index == end)
                break;
            if(pomoc == ile){
                index += skok;
                pomoc = 1;
                przes = przes * (-1);
            } else {
                index += przes;
                pomoc += 1;
                continue;
            }
        }
        return sci;
    }
    public ArrayList<Integer> sciezka(int m1, int m2, int m3, int wym, int przy) {
        ArrayList<Integer> scie = new ArrayList<>();
        int pomoc = 0;
        if (przy == 1) {
            scie = slalom(1,wym*wym, wym, wym, wym, m1, m2, m3, 2, 3, scie);
        }
        else if(przy == 2){
            scie = slalom(wym, (wym*(wym-1))+1, wym, wym, wym, m1, m2, m3, 4, 3, scie);
        }
        else if(przy == 3){
            scie = slalom(1, wym*wym, wym, wym, wym, m1 ,m2, m3, 3, 2, scie);
        }
        else if(przy == 4){
            scie = slalom(((wym*(wym-1))+1), wym, wym, wym, wym, m1, m2, m3, 1, 2, scie);
        }
        else if(przy == 5 && m2 % wym != 0){
            int index = m2;
            int pomk = jakaKolumna(m2, wym);
            int pomw = jakiWiersz(m2, wym);
            scie = slalom(index, pomw*wym - wym +1,pomk, 1, wym, m1, m2, m3, 4,1,scie);
            index = pomw*wym - wym- wym +1;
            pomk = jakaKolumna(m2, wym);
            scie = slalom(index, pomk, pomk, pomw-1, wym, m1, m2, m3, 1, 2, scie);
            index = pomk + 1;
            scie = slalom(index, wym*pomw, wym-pomk, pomw, wym, m1, m2, m3, 2, 3, scie);
            index = (wym*pomw) + wym;
            scie = slalom(index, ((wym-1)*wym)+1, wym, wym-pomw, wym, m1, m2, m3, 3, 4, scie);
        } else if(przy == 5 && m2 % wym  == 0){
            int index = m2;
            int pomw = jakiWiersz(m2, wym);
            scie = slalom(index, 2, wym-1, pomw, wym, m1, m2, m3, 4, 1, scie);
            index = 1;
            scie = slalom(index, ((pomw+1)*wym) - 1, 1, pomw, wym, m1, m2, m3, 3, 2, scie);
            index = ((pomw)*wym) + 1;
            scie = slalom(index, wym*wym, wym, wym-pomw, wym, m1, m2, m3, 3,2,scie);
        }
        else if(przy == 6){
            int index = m2;
            int pomk = jakaKolumna(m2, wym);
            int pomw = jakiWiersz(m2, wym);
            scie = slalom(index, pomk, pomk, pomw, wym, m1, m2, m3, 4, 1, scie);
            index =  pomk + 1;
            scie = slalom(index, pomw*wym, wym-pomk, pomw, wym, m1, m2, m3, 3, 2, scie);
            index = (pomw+1)*wym;
            scie = slalom(index, ((wym-1)*wym)+1, wym, wym-pomw, wym, m1, m2, m3, 3, 4, scie);
        }
        else if(przy == 7 && m2 % wym != 1){
            int index = m2;
            int pomk = jakaKolumna(m2, wym);
            int pomw = jakiWiersz(m2 , wym);
            scie = slalom(index, pomw*wym, wym-pomk+1, 1, wym, m1, m2, m3, 2,3,scie);
            index = (pomw+1)*(wym);
            scie = slalom(index, ((wym-1)*wym)+pomk, wym-pomk+1, wym-pomw, wym, m1, m2, m3, 3,4,scie);
            index = ((wym-1)*wym)+pomk-1;
            scie= slalom(index, wym*(pomw-1)+1,pomk-1,wym-pomw+1, wym, m1, m2, m3, 4, 1, scie);
            index = (wym*pomw)-(2*wym)+1;
            scie=slalom(index, wym, wym, pomw-1,wym, m1, m2, m3, 1, 2, scie);
        } else if (przy == 7 && m2 % wym == 1) {
            int index = m2;
            int pomw = jakiWiersz(m2 , wym);
            scie=slalom(index, (wym*wym)-1,wym-1,wym-pomw+1,wym, m1, m2, m3, 2,3,scie);
            index = wym*wym;
            scie = slalom(index, pomw*wym,1,wym-pomw+1, wym, m1, m2, m3, 1,2,scie);
            index = (wym*pomw) - wym;
            scie = slalom(index, 1, wym, pomw-1, wym, m1, m2, m3, 1,4,scie);
        }
        else if(przy == 8){
            int index = m2;
            int pomk = jakaKolumna(m2, wym);
            int pomw = jakiWiersz(m2 , wym);
            scie = slalom(index,(wym*wym)-(wym-pomk),wym-pomk+1,wym-pomw+2,wym, m1, m2, m3, 2,3, scie);
            index = wym*(wym-1) +1;
            scie = slalom(index, (pomw*wym - wym + 1),pomk-1,wym-pomw+1,wym, m1, m2, m3, 1, 4, scie);
            index= (pomw*wym) - 2*wym + 1 ;
            scie = slalom(index, wym, wym, pomw-1, wym, m1, m2, m3, 1,2,scie);
        }
        return scie;
    }
}

