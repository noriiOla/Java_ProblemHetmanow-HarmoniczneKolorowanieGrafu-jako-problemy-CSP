
package harm;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingHetmiani {
    public int N;
    public int iloscWierszy;
    public int iloscKolumn;
    List<Hetman> rozwiazanie;
    public int liczbaRozw;
    public int iloscOdwiedzonychWezlow;
    public int w;
    public int iloscRek;
    List<Hetman> hetmani;
    
    public BacktrackingHetmiani(int N) {
        this.N = N;
        this.iloscWierszy = N;
        this.rozwiazanie = new ArrayList<Hetman>();
        this.liczbaRozw = 0;
        this.iloscOdwiedzonychWezlow = 0;
        this.w = 1;
        this.iloscRek = 1;
    }
    public BacktrackingHetmiani(int N, List<Hetman> hetmani) {
        this.N = N;
        this.iloscWierszy = N;
        this.rozwiazanie = new ArrayList<Hetman>();
        this.liczbaRozw = 0;
        this.iloscOdwiedzonychWezlow = 0;
        this.w = 1;
        this.iloscRek = 1;
        this.hetmani = hetmani;
    }
    
    
    public void hetman(int nrKolHetmana){
        for(int nrWiesza=0; nrWiesza< this.iloscWierszy; nrWiesza++){
            iloscOdwiedzonychWezlow++;
            if(wolne(nrWiesza, nrKolHetmana)){
                rozwiazanie.add(new Hetman(nrWiesza, nrKolHetmana));
                if(rozwiazanie.size()== this.N){
                    liczbaRozw++;
                }
                hetman(nrKolHetmana+1);
                rozwiazanie.remove(rozwiazanie.size()-1);
            }
        }
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
        System.out.println("Backtracking hetmani " + liczbaRozw+ " czas: "+ czas + " liczba odwiedzonych wezlow: " + iloscOdwiedzonychWezlow);
    } 
    
    public Rozwiazanie getRozwiazanie(float czas){
        return new Rozwiazanie(liczbaRozw, czas, iloscOdwiedzonychWezlow);
    }
    
    public void hetmanH(int nrKolHetmana){
        if(nrKolHetmana < this.N){
            for(int nrWiesza=0; nrWiesza< this.iloscWierszy; nrWiesza++){
               iloscOdwiedzonychWezlow++;
               if(wolne(nrWiesza, hetmani.get(nrKolHetmana).y)){
                   rozwiazanie.add(new Hetman(nrWiesza, hetmani.get(nrKolHetmana).y));
                   if(rozwiazanie.size()== this.N){
                       liczbaRozw++;
                   }
                   hetmanH(nrKolHetmana+1);
                   rozwiazanie.remove(rozwiazanie.size()-1);
               }
            }
        }
    }
}
