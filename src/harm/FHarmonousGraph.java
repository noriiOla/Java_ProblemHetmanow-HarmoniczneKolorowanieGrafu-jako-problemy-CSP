package harm;

import java.util.ArrayList;
import java.util.List;

public class FHarmonousGraph {
   public int N;
    public int iloscWierszy;
    public int iloscKolumn;
    List<Polaczenie> instniejacePolaczenia;
    public int liczbaRozw;
    int[][] graph;
    
    public FHarmonousGraph(int N) {
      this.N = N;
        this.iloscWierszy = N;
        this.instniejacePolaczenia = new ArrayList<Polaczenie>();
        this.liczbaRozw = 0;
        this.iloscKolumn = N;
        this.graph = new int[N][N];
        initGraph();
    }
    
    public void initGraph(){
        for(int i=0; i<this.iloscWierszy; i++){
            for(int j=0; j< this.iloscWierszy; j++){
                this.graph[i][j] = -1;
            }
        }
    }
    
//    public void wezel(Wezel[][] wezly, int x, int y, Kolor[] kolory){
//       if(x< this.iloscWierszy && y <this.iloscWierszy){
//           for(Integer kolor: wezly[x][y].dostepneKolory){
//               koloruj(x, y, kolor);
//               if(x-1 >= 0){
//                    kolory[kolor].dodajStykajacySieKolor(graph[x-1][y]);
//               }
//               if(y-1>= 0){
//                    kolory[kolor].dodajStykajacySieKolor(graph[x][y-1]);
//               }
//             
//               if((x == y) && (x == (this.iloscWierszy-1))){
//                   liczbaRozw++;
//                   // wypiszGraf();
//                        
//                        //int zccas=1;
//                  }else{
//                     if(x == (this.iloscWierszy-1) && (y+1 < this.iloscWierszy)){
//                         wezel(usunWolneKolory(wezly, x, y), 0, y+1, kolory);
//                     }else{
//                         if(x+1 < this.iloscWierszy){
//                            wezel(usunWolneKolory(wezly, x, y), x+1, y, kolory);
//                        }
//                    }
//                }
//               if(x-1 >= 0){
//                    kolory[kolor].usunStykajacySieKolor(graph[x-1][y]);
//               }
//               if(y-1 >= 0){
//                    kolory[kolor].usunStykajacySieKolor(graph[x][y-1]);
//               }
//               }
//           }
//        
//    }
// 
//    public Wezel[][] usunWolneKolory(Wezel[][] wezly, int x, int y, Kolor[] kolory){            // stworz nowa liste wezlow i ja zwroc
//        //stworz identyczna liste kolorow
//        //odejmij uzywajac funckji nizej kolory uzyte
//        Kolor[] zaktuazlizowaneKolory = new Kolor[iloscKolorow];
//        
//        List<Integer> nowaListaDostepnychKolorow = new ArrayList<Integer>();
//        for(int kolor : wezly[x][y].dostepneKolory){
//            if(!kolory[graph[x][y].contains(kolor)){
//                nowaListaDostepnychKolorow.add(kolor);
//            }
//        }
//        ko = nowaListaDostepnychKolorow;
//        
//        return wezly[x+1][y].usunWszystkieKoloryZDostepnych(kolory[graph[x][y]].stykajaceSieKolory);
//    }
//
//    public Wezel[][] usunTenKolorZWolnychPolaczenWezla(Wezel[][] tab, int color, int x, int y){
//        List<Polaczenie> nowaListaWolnychPolaczen = new ArrayList<Polaczenie>();
//        for(Polaczenie pol : tab[x][y].listaWolnychPolaczeni){
//            if(pol.color1 != color){
//                nowaListaWolnychPolaczen.add(pol);
//            }
//        }
//        tab[x][y] = new Wezel(x, y, nowaListaWolnychPolaczen);
//        return tab;
//    }
//    
//    public List<Polaczenie> szukajPowstalychPolaczen(int x, int y){
//        List<Polaczenie> listaNowychPolaczeni = new ArrayList<Polaczenie>();
//        if(x>0){
//            listaNowychPolaczeni.add(new Polaczenie(this.graph[x][y], this.graph[x-1][y]));
//        }
//        if(y>0){
//            listaNowychPolaczeni.add(new Polaczenie(this.graph[x][y], this.graph[x][y-1]));
//        }
//        
//        return listaNowychPolaczeni;
//    }
//    
//    public boolean pasuje(int colorId, int x, int y){
//         Polaczenie newPol1 = null;
//         Polaczenie newPol2 = null;
//        if(x>0){
//            newPol1 = new Polaczenie(colorId, this.graph[x-1][y]);
//        }
//        if(y>0){
//            newPol2 = new Polaczenie(colorId, this.graph[x][y-1]);
//        }
//        
//              //jesli z bogu nie sa takie same (2 kolory nie wyst obok siebie)
//        for(Polaczenie pol : this.instniejacePolaczenia){
//            if( (newPol1!= null && pol.porownaj(newPol1)) || (newPol2 != null && pol.porownaj(newPol2))){
//                return false;
//            }
//        }
//            return true;
//        
//        return false;
//    }
//    
//     public void koloruj(int x, int y, int colorId){
//        this.graph[x][y] = colorId;
//    }
//     
//    public Wezel[][] usunWolnePolaczenia(Wezel[][] wolnePolaczenia, List<Polaczenie> uzytePolaczenia, int xWezla, int yWezla){
//        Wezel[][] zaktualizowaneWezly = new Wezel[this.N][this.N];
//        for(Polaczenie pol: uzytePolaczenia){
//            for(int i=0; i< this.iloscWierszy; i++){
//                for(int j=0; j< this.iloscKolumn; j++){
//                    List<Polaczenie> nowaListaPolaczenWezla = new ArrayList<Polaczenie>();
//                    for(Polaczenie mozliwePolaczenie: wolnePolaczenia[i][j].listaWolnychPolaczeni){
//                        if((mozliwePolaczenie.porownaj(pol)) ){ //dodaj zezaczyna sie na ten sam kolor
//                        }else{
//                            nowaListaPolaczenWezla.add(new Polaczenie(mozliwePolaczenie.color1, mozliwePolaczenie.color2));
//                        }
//                    }
//                    zaktualizowaneWezly[i][j] = new Wezel(i, j, nowaListaPolaczenWezla);
//                }
//            }
//        }
//        
//        if(uzytePolaczenia.size()==0){
//            for(int i=0;i<wolnePolaczenia.length; i++){
//                for(int j=0;j<wolnePolaczenia.length; j++){
//                   zaktualizowaneWezly[i][j] = new Wezel(i, j, wolnePolaczenia[i][j].listaWolnychPolaczeni);
//                }
//            }
//        }
//                
//        List<Polaczenie> lPol = new ArrayList<Polaczenie>();
//        boolean added = false;
//        int wcolor1 = -1;
//        int wcolor2 = -1;
//        if(xWezla-1 >=0){
//            wcolor1 = graph[xWezla-1][yWezla];
//        }
//        
//        if(yWezla-1>=0){
//            wcolor2 = graph[xWezla][yWezla-1];
//        }
//        
//        if(xWezla+1 < this.iloscWierszy){
//            for(Polaczenie pol : zaktualizowaneWezly[xWezla+1][yWezla].listaWolnychPolaczeni){
//                if((pol.color1 != graph[xWezla][yWezla]) && pol.color1 !=  wcolor1 && pol.color1 != wcolor2){
//                    lPol.add(pol);
//                }
//            }
//            zaktualizowaneWezly[xWezla+1][yWezla] = new Wezel(lPol);
//        }
//        
//        lPol = new ArrayList<Polaczenie>();
//        if(yWezla+1 < this.iloscKolumn){
//            for(Polaczenie pol : zaktualizowaneWezly[xWezla][yWezla+1].listaWolnychPolaczeni){
//                if(pol.color1 != graph[xWezla][yWezla] && pol.color1 !=  wcolor1 && pol.color1 != wcolor2){
//                    lPol.add(pol);
//                }
//            }
//            zaktualizowaneWezly[xWezla][yWezla+1] = new Wezel(lPol);
//        
//        lPol = new ArrayList<Polaczenie>();
//        if(xWezla-1>=0){
//            for(Polaczenie pol : zaktualizowaneWezly[xWezla-1][yWezla+1].listaWolnychPolaczeni){
//                if(pol.color1 != graph[xWezla][yWezla]){
//                    lPol.add(pol);
//                }
//            }
//            zaktualizowaneWezly[xWezla-1][yWezla+1] = new Wezel(lPol);
//        }}
//        
//        /////////////////////////////////
//        
//        for(int i=0; i<iloscKolumn; i++){
//            if( i<= yWezla){
//                if (i != yWezla){
//                if(graph[xWezla][i] == graph[xWezla][yWezla]){
//                    if(xWezla+1 < N){
//                        lPol = new ArrayList<Polaczenie>();
//                        for(Polaczenie pol : zaktualizowaneWezly[xWezla+1][i].listaWolnychPolaczeni){
//                            if(pol.color1 == graph[xWezla][yWezla-1] || pol.color1 == graph[xWezla][yWezla+1]  || pol.color1 == graph[xWezla-1][yWezla] ){
//                              int z=0;  
//                            }else{
//                                lPol.add(pol);
//                            }
//                        }
//                        zaktualizowaneWezly[xWezla+1][i] = new Wezel(lPol);
//                    }
//                }
//                }
//            }else{
//                if(xWezla-1>=0){
//                if(graph[xWezla-1][i] == graph[xWezla][yWezla]){
//                    if(xWezla+1 < N){
//                        lPol = new ArrayList<Polaczenie>();
//                        for(Polaczenie pol : zaktualizowaneWezly[xWezla+1][i].listaWolnychPolaczeni){
//                            if(pol.color1 == graph[xWezla][yWezla-1] || pol.color1 == graph[xWezla][yWezla+1]  || pol.color1 == graph[xWezla-1][yWezla] ){
//                                int z=0;  
//                            }else{
//                                lPol.add(pol);
//                            }
//                        }
//                        zaktualizowaneWezly[xWezla+1][i] = new Wezel(lPol);
//                    }
//                }
//            }
//            }
//            
//        }
//        
//        return zaktualizowaneWezly;
//    }
//    
//    public void wypiszGraf(){
//        for(int i=0; i<iloscWierszy; i++){
//            for(int j=0; j< iloscKolumn; j++){
//                System.out.print(graph[i][j] +"  ");
//            }
//            System.out.println();
//        }
//    }
//    
//    public void printIloscRozw(){
//        System.out.println("Kolorwanie grafu forward "+ liczbaRozw);
//    }

}
