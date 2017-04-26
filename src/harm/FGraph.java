/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ola
 */
public class FGraph {
    public int N;
    public int iloscWierszy;
    public int iloscKolumn;
    List<Polaczenie> dostepne;
    public int liczbaRozw;
    int[][] graph;
    int iloscKolorow;
    int iloscOdwiedzonychWezlow;

    public FGraph(int N) {
      this.N = N;
        this.iloscWierszy = N;
        this.dostepne = new ArrayList<Polaczenie>();
        this.liczbaRozw = 0;
        this.iloscKolumn = N;
        this.graph = new int[N][N];
        if(N % 2 == 0){
            this.iloscKolorow = (2 * N);
        }else{
            this.iloscKolorow = ((2 * N)+1);
        }
        initGraph();
        this.iloscOdwiedzonychWezlow = 0;
    }
    
    public void initGraph(){
        for(int i=0; i<this.iloscWierszy; i++){
            for(int j=0; j< this.iloscWierszy; j++){
                this.graph[i][j] = -1;
            }
        }
    }
    
   public void wezel(Wezel[][] wezly, int x, int y, Kolor[] kolory){
       if(x< this.iloscWierszy && y <this.iloscWierszy){
           for(Integer kolor: wezly[x][y].dostepneKolory){
               iloscOdwiedzonychWezlow++;
               koloruj(x, y, kolor);
               if(x-1 >= 0){
                    kolory[kolor].dodajStykajacySieKolor(graph[x-1][y]);
               }
               if(y-1>= 0){
                    kolory[kolor].dodajStykajacySieKolor(graph[x][y-1]);
               }
               if(x-1 >= 0){
                kolory[graph[x-1][y]].dodajStykajacySieKolor(kolor);
               }
               if(y-1 >= 0){
                kolory[graph[x][y-1]].dodajStykajacySieKolor(kolor);
               }
             
               if((x == y) && (x == (this.iloscWierszy-1))){
                   liczbaRozw++;
                  }else{
                    if(y == (this.iloscKolumn-1) && (x+1 < this.iloscWierszy)){
                         wezel(usunWolneKolory(wezly, x, y, kolory), x+1, 0, kolory);
                     }else{
                         if(y+1 < this.iloscWierszy){
                             wezel(usunWolneKolory(wezly, x, y, kolory), x, y+1, kolory);
                        }
                    }
                }
               if(x-1 >= 0){
                    kolory[kolor].usunStykajacySieKolor(graph[x-1][y]);
               }
               if(y-1 >= 0){
                    kolory[kolor].usunStykajacySieKolor(graph[x][y-1]);
               }
               if(x-1 >= 0){
                   kolory[graph[x-1][y]].usunStykajacySieKolor(kolor);
               }
               if(y-1 >= 0){
                   kolory[graph[x][y-1]].usunStykajacySieKolor(kolor);
               }
               }
           }
    }
   
    public void koloruj(int x, int y, int colorId){
        this.graph[x][y] = colorId;
    }
    
    public Wezel[][] usunWolneKolory(Wezel[][] wezly, int x, int y, Kolor[] kolory){         
        Wezel[][] zakutalizowaneWolneKolory = new Wezel[iloscWierszy][iloscKolumn];
        for(int i = 0; i< iloscWierszy; i++){
            for(int j = 0; j < iloscKolumn; j++){
                zakutalizowaneWolneKolory[i][j] = new Wezel(i, j, wezly[i][j].dostepneKolory);
            }
        }
                
        List<Integer> stykKoloryZNastepnymWezlem = new ArrayList<Integer>();
        if(x+1 < iloscWierszy){
            for(int i=0;i<=y; i++){
                    zakutalizowaneWolneKolory[x+1][i].usunWszystkieKoloryZDostepnych(kolory[graph[x][i]].stykajaceSieKolory);
            }
        }
        if(x-1 >= 0){
            for(int i=x+1 ; i<iloscKolumn; i++){
                zakutalizowaneWolneKolory[x][i].usunWszystkieKoloryZDostepnych(kolory[graph[x-1][i]].stykajaceSieKolory);
            }
        }
        
        stykKoloryZNastepnymWezlem.add(graph[x][y]);
        if(x-1 >= 0 && y+1 <iloscKolumn && graph[x-1][y+1]!=-1){
            stykKoloryZNastepnymWezlem.add(graph[x-1][y+1]);
        }
        
        if(y+1 < iloscKolumn){
            for(int numerKoloru : stykKoloryZNastepnymWezlem){
                   zakutalizowaneWolneKolory[x][y+1].usunWszystkieKoloryZDostepnych(kolory[numerKoloru].stykajaceSieKolory);
            }
        }
        return zakutalizowaneWolneKolory;
    }
    
    public void printIloscRozw(float czas){
        System.out.println("Kolorwanie grafu forward "+ this.liczbaRozw + " czas: " + czas + " liczba odwiedzonych wezlow: " + iloscOdwiedzonychWezlow);
    }
    
    public Rozwiazanie getRozwiazanie(float czas){
        return new Rozwiazanie(liczbaRozw, czas, iloscOdwiedzonychWezlow);
    }
    
    public void wypiszGraf(){
        for(int i=0; i<iloscWierszy; i++){
            for(int j=0; j< iloscKolumn; j++){
                System.out.print(graph[i][j] +"  ");
            }
            System.out.println();
        }
    }
}
