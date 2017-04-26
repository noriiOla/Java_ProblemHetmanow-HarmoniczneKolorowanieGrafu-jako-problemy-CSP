
package harm;

import java.util.ArrayList;
import java.util.List;

public class Harm {
    public static int n = 11;
    public static int nDlaGrafu = 2 ;
    public static void main(String[] args) {
        float startTime;
            //   int i = 8;

        List<Rozwiazanie> listaRozwiazan = new ArrayList<Rozwiazanie>();
        for(int i=1; i<13; i++){
            n = i;
            BacktrackingHetmiani bh = new BacktrackingHetmiani(i);
            startTime = System.nanoTime();
            bh.hetman(0);
            bh.printIloscRozw(System.nanoTime() - startTime);
            listaRozwiazan.add(bh.getRozwiazanie(System.nanoTime() - startTime));
        }
        IOService service = new IOService("backHet");
        service.zapisz(listaRozwiazan);
        
        listaRozwiazan = new ArrayList<Rozwiazanie>();
        for(int i=1; i<13; i++){
            n = i;
            BacktrackingHetmiani bhH = new BacktrackingHetmiani(i, stworzHetmanow());
            startTime = System.nanoTime();
            bhH.hetmanH(0);
            bhH.printIloscRozw(System.nanoTime() - startTime);
            listaRozwiazan.add(bhH.getRozwiazanie(System.nanoTime() - startTime));

        }
        service = new IOService("backHetH");
        service.zapisz(listaRozwiazan);
        
        listaRozwiazan = new ArrayList<Rozwiazanie>();
        for(int i=1; i<13; i++){
            n = i;
            ForwardHetmani fh = new ForwardHetmani(n);
            startTime = System.nanoTime();
            fh.hetman(0, stworzHetmanomWolneMiejsca());
            fh.printIloscRozw(System.nanoTime() - startTime);
            listaRozwiazan.add(fh.getRozwiazanie(System.nanoTime() - startTime));
        }
        service = new IOService("forwHet");
        service.zapisz(listaRozwiazan);
        
        listaRozwiazan = new ArrayList<Rozwiazanie>();
        for(int i=1; i<13; i++){
            n = i;
            ForwardHetmani fhH = new ForwardHetmani(n, stworzHetmanow());
            startTime = System.nanoTime();
            fhH.hetmanH(0, stworzHetmanomWolneMiejsca());
            fhH.printIloscRozw(System.nanoTime() - startTime);
            listaRozwiazan.add(fhH.getRozwiazanie(System.nanoTime() - startTime));
         }
        service = new IOService("forwHetH");
        service.zapisz(listaRozwiazan);
//        
      ///////////////////////////////////////////////////////////////////  
       listaRozwiazan = new ArrayList<Rozwiazanie>();
        for(int i=1; i<5; i++){
            nDlaGrafu = i;
            BHarmonousGraph bhar = new BHarmonousGraph(nDlaGrafu);
            startTime = System.nanoTime();
            bhar.wezel(0, 0);
            bhar.printIloscRozw(System.nanoTime() - startTime);
            listaRozwiazan.add(bhar.getRozwiazanie(System.nanoTime() - startTime));
         }
        service = new IOService("BackGraf");
        service.zapisz(listaRozwiazan);
//        BHarmonousGraph bharH = new BHarmonousGraph(nDlaGrafu);
//        startTime = System.nanoTime();
//        bharH.wezelH(nDlaGrafu/2, nDlaGrafu/2);
//        bharH.printIloscRozw(System.nanoTime() - startTime);
         listaRozwiazan = new ArrayList<Rozwiazanie>();
        for(int i=1; i<5; i++){
            nDlaGrafu = i;
            FGraph fhar = new FGraph(nDlaGrafu);
            startTime = System.nanoTime();
            fhar.wezel(stwozTabliceMozliwychPolaczen(), 0, 0, stworzListeKolorow());
            fhar.printIloscRozw(System.nanoTime() - startTime);
            listaRozwiazan.add(fhar.getRozwiazanie(System.nanoTime() - startTime));
         }
        service = new IOService("ForwGraf");
        service.zapisz(listaRozwiazan);
    }
    
    public static List<Hetman> stworzHetmanow(){
        List<Hetman> hetmani = new ArrayList<Hetman>();
        //bierzemey pierw hetmanow od srodka
        int startY;
        if(n%2 == 1){
             startY = n/2+1;
        }else{
            startY = n/2;
        }
        int i = 1;
        hetmani.add(new Hetman(startY));

        while(hetmani.size() < n){
            if(startY + i < n){
                hetmani.add(new Hetman(startY+i));
            }
            if(startY-i>=0){
                hetmani.add(new Hetman(startY-i));
            }
            i++;
        }
        
        //bierzemy pierw skrajnych hetmanow
//        int pocz = 0;
//        int kon = n-1;
//        while(pocz <= kon){
//            hetmani.add(new Hetman(pocz));
//            if(pocz!=kon){
//                hetmani.add(new Hetman(kon));
//            }
//            pocz++;
//            kon--;
//        }
//        
        return hetmani;
    }
    
    public static Kolor[] stworzListeKolorow(){
        int iloscKolorow = 0;
        if(nDlaGrafu % 2 == 0){
            iloscKolorow = (2 * nDlaGrafu);
        }else{
            iloscKolorow = ((2 * nDlaGrafu)+1);
        }
        
        Kolor[] kolory = new Kolor[iloscKolorow];
        
        for(int i=0; i<iloscKolorow; i++){
            kolory[i] = new Kolor(i);
        }
        return kolory;
    }
    
    public static Hetman[] stworzHetmanomWolneMiejsca(){
        Hetman[] hetmani = new Hetman[n];
        for(int i=0; i<n; i++){
            hetmani[i] = new Hetman(i, listaMiejsc(i));
        }
        return hetmani;
    }
    
    public static Hetman[] stworzHetmanomWolneMiejscaH(){
        Hetman[] hetmani = new Hetman[n];
        int startY;
        if(n%2 == 1){
            startY = n/2+1;
        }else{
            startY = n/2;
        }
        int i = 1;    
        int index = 0;
        hetmani[index] = new Hetman(startY, listaMiejsc(startY));
       index++;
        while(hetmani.length < n){
            if(startY + i < n){
                hetmani[index] = new Hetman(startY+i, listaMiejsc(startY));
                index++;
            }
            if(startY-i>=0){
                hetmani[index] = new Hetman(startY-i, listaMiejsc(startY));
                index++;
            }
            i++;
        }
        return hetmani;
    }
    
    public static List<Miejsce> listaMiejsc(int nrKol){
        List<Miejsce> listaMiejsc = new ArrayList<Miejsce>();
        for(int nrW = 0; nrW <n; nrW++){
            listaMiejsc.add(new Miejsce(nrW, nrKol));
        }
        return listaMiejsc;
    }
    
    
    public static Wezel[][] stwozTabliceMozliwychPolaczen(){        //i jeslisie zaczyna na kolor.. i jest kolo naszego to tez nie moze byc
        Wezel[][] tablicaMozliwychPolaczen = new Wezel[nDlaGrafu][nDlaGrafu];
        int iloscKolorow=0;
        if(nDlaGrafu % 2 == 0){
            iloscKolorow = (2 * nDlaGrafu);
        }else{
            iloscKolorow = ((2 * nDlaGrafu)+1);
        }
        
       for(int i=0; i<nDlaGrafu; i++){
            for (int j=0; j< nDlaGrafu; j++){
                List<Integer> dostepneKolory = new ArrayList<Integer>();
                for(int k1=0; k1 < iloscKolorow; k1++){
                    dostepneKolory.add(k1);
                }
                tablicaMozliwychPolaczen[i][j] = new Wezel(i, j, dostepneKolory);
            }
        }
        
        return tablicaMozliwychPolaczen;
    }
}
