/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ola
 */
public class ForwardHetmani {
    public int N;
    public int iloscWierszy;
    public int iloscKolumn;
    List<Hetman> rozwiazanie;
    public int liczbaRozw;
    public int iloscOdwiedzonychWezlow;
    List<Hetman> hetmani;

    public ForwardHetmani(int N) {
        this.N = N;
        this.iloscWierszy = N;
        this.rozwiazanie = new ArrayList<Hetman>();
        this.liczbaRozw = 0;
        this.iloscOdwiedzonychWezlow = 0;
    }
    
    public ForwardHetmani(int N, List<Hetman> hetmani) {
        this.N = N;
        this.iloscWierszy = N;
        this.rozwiazanie = new ArrayList<Hetman>();
        this.liczbaRozw = 0;
        this.iloscOdwiedzonychWezlow = 0;
        this.hetmani = hetmani;
    }
    
    public Rozwiazanie getRozwiazanie(float czas){
        return new Rozwiazanie(liczbaRozw, czas, iloscOdwiedzonychWezlow);
    }
    
    public void hetman(int nrKolHetmana, Hetman[] wolneMiejscaHetm){
       if(nrKolHetmana < this.N){
            for(Miejsce miejsce : wolneMiejscaHetm[nrKolHetmana].listaWolnychMiejsc){
                iloscOdwiedzonychWezlow++;
                rozwiazanie.add(new Hetman(miejsce));
                if(rozwiazanie.size()== this.N){
                   liczbaRozw++;
                }
                hetman(nrKolHetmana+1, usunWolneMiejsca(wolneMiejscaHetm, miejsce, nrKolHetmana));
                rozwiazanie.remove(rozwiazanie.size()-1);
            }
        }
    }
    
    public Hetman[] usunWolneMiejsca(Hetman[] wolneMiejscaHetm, Miejsce nowoZajeteMiejsce, int fromHetman){
       Hetman[] zaktualizowanieHetmani = new Hetman[this.N];
        for(int i = 0; i<this.N; i++){
            Hetman h = wolneMiejscaHetm[i];
            List<Miejsce> nowaListaWolnychMiejscH = new ArrayList<Miejsce>();
            for(Miejsce wolneMiejsce : h.listaWolnychMiejsc){
                if((wolneMiejsce.x == nowoZajeteMiejsce.x) || (wolneMiejsce.y == nowoZajeteMiejsce.y) || ((wolneMiejsce.x - wolneMiejsce.y) == (nowoZajeteMiejsce.x - nowoZajeteMiejsce.y)) || ((wolneMiejsce.x + wolneMiejsce.y) == (nowoZajeteMiejsce.x + nowoZajeteMiejsce.y))){
                    
                }else{
                    nowaListaWolnychMiejscH.add(new Miejsce(wolneMiejsce.x, wolneMiejsce.y));
                }
            }
            zaktualizowanieHetmani[i] = new Hetman(i, nowaListaWolnychMiejscH);
        }
        return zaktualizowanieHetmani;
    }
    
    public boolean wolne(int nrWiersza, int nrKolumny){
        for(Hetman hetman: rozwiazanie){
            if((hetman.x == nrWiersza) || (hetman.y == nrKolumny) || ((hetman.x - hetman.y) == (nrWiersza-nrKolumny)) || ((hetman.x + hetman.y) == (nrKolumny + nrWiersza) )){
                return false;
            }
        }
        return true;
    }
    
    public void printIloscRozw(float czas){
        System.out.println("Forward hetmani: " + liczbaRozw + " czas: " + czas + " liczba odwiedzonych wezlow: " + iloscOdwiedzonychWezlow);
    }
    
    public void hetmanH(int nrKolHetmana, Hetman[] wolneMiejscaHetm){
       if(nrKolHetmana < this.N){
            for(Miejsce miejsce : wolneMiejscaHetm[nrKolHetmana].listaWolnychMiejsc){
                iloscOdwiedzonychWezlow++;
                rozwiazanie.add(new Hetman(miejsce));
                if(rozwiazanie.size()== this.N){
                   liczbaRozw++;
                }
                hetmanH(nrKolHetmana+1, usunWolneMiejsca(wolneMiejscaHetm, miejsce, nrKolHetmana));
                rozwiazanie.remove(rozwiazanie.size()-1);
            }
        }
    }
}
