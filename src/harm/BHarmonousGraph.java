package harm;

import java.util.ArrayList;
import java.util.List;

public class BHarmonousGraph {
    public int N;
    public int iloscWierszy;
    public int iloscKolumn;
    public int iloscKolorow;
    List<Polaczenie> instniejacePolaczenia;
    public int liczbaRozw;
    int[][] graph;
    int iloscOdwiedzonychWezlow;
    
    public BHarmonousGraph(int N) {
        this.N = N;
        this.iloscWierszy = N;
        if(N % 2 == 0){
            this.iloscKolorow = (2 * N);
        }else{
            this.iloscKolorow = ((2 * N)+1);
        }
        this.instniejacePolaczenia = new ArrayList<Polaczenie>();
        this.liczbaRozw = 0;
        this.graph = new int[N][N];
        initGraph();
        iloscOdwiedzonychWezlow = 0;
    }
    
    public void initGraph(){
        for(int i=0; i<this.iloscWierszy; i++){
            for(int j=0; j< this.iloscWierszy; j++){
                this.graph[i][j] = -1;
            }
        }
    }
    
    public void wezel(int x, int y){
        if(x< this.iloscWierszy && y <this.iloscWierszy){
            for(int colorId=0; colorId < iloscKolorow; colorId++){
                iloscOdwiedzonychWezlow++;
                if(pasuje(colorId, x, y)){
                    koloruj(x, y, colorId);
                    List<Polaczenie> nowePolaczenia = generujNowePolaczenia(x, y);
                    
                    this.instniejacePolaczenia.addAll(nowePolaczenia);   //polaczeni na lewo i u gory

                    if((x == y) && (x == (this.iloscWierszy-1))){
                        liczbaRozw++;
                    }else{
                        if(x == (this.iloscWierszy-1) && (y+1 < this.iloscWierszy)){
                            wezel(0, y+1);
                        }else{
                            if(x+1 < this.iloscWierszy){
                                wezel(x+1, y);
                            }
                        }
                    }
                  for(Polaczenie pol: nowePolaczenia){
                      this.instniejacePolaczenia.remove(pol);
                  }
                }
            }
        }
    }
    
    public void koloruj(int x, int y, int colorId){
        this.graph[x][y] = colorId;
    }
    
    public List<Polaczenie> generujNowePolaczenia(int x, int y){
        List<Polaczenie> listaNowychPolaczeni = new ArrayList<Polaczenie>();
        if(x>0){
            listaNowychPolaczeni.add(new Polaczenie(this.graph[x][y], this.graph[x-1][y]));
        }
        if(y>0){
            listaNowychPolaczeni.add(new Polaczenie(this.graph[x][y], this.graph[x][y-1]));
        }
        
        return listaNowychPolaczeni;
    }
    
    public boolean pasuje(int colorId, int x, int y){
         Polaczenie newPol1 = null;
         Polaczenie newPol2 = null;
        if(x>0){
            newPol1 = new Polaczenie(colorId, this.graph[x-1][y]);
        }
        if(y>0){
            newPol2 = new Polaczenie(colorId, this.graph[x][y-1]);
        }
        
        if(!((y > 0 && this.graph[x][y-1] == colorId) || ( x > 0 && this.graph[x-1][y] == colorId)) || (x==0 && y==0)){      //jesli z bogu nie sa takie same (2 kolory nie wyst obok siebie)
            for(Polaczenie pol : this.instniejacePolaczenia){
                if( (newPol1!= null && pol.porownaj(newPol1)) || (newPol2 != null && pol.porownaj(newPol2))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public void printIloscRozw(float czas){
        System.out.println("Kolorwani egrafu backt "+ this.liczbaRozw + " czas: " + czas + " liczba odwiedzonych wezlow: " + iloscOdwiedzonychWezlow);
    }
    
     public void wezelH(int x, int y, int mode, int z){
         if(mode == 5){
             mode = 1;
         }
        if(x< this.iloscWierszy && y <this.iloscWierszy){
            for(int colorId=0; colorId < iloscKolorow; colorId++){
                iloscOdwiedzonychWezlow++;
                if(pasuje(colorId, x, y)){
                    koloruj(x, y, colorId);
                    List<Polaczenie> nowePolaczenia = generujNowePolaczeniaH(x, y);
                    
                    this.instniejacePolaczenia.addAll(nowePolaczenia);   //polaczeni na lewo i u gory

                    if((x == y) && (x == (this.iloscWierszy-1))){
                        liczbaRozw++;
                    }else{
                        if(mode%2 == 1){
                            if(z > 0){
                                z++;
                            }else{
                                z--;
                            }
                            z = z * (-1);
                            wezelH(x, y + z, mode++, z);
                        }
//                        if(x == (this.iloscWierszy-1) && (y+1 < this.iloscWierszy)){
//                            wezelH(0, y+1);
//                        }else{
//                            if(x+1 < this.iloscWierszy){
//                                wezelH(x+1, y);
//                            }
//                        }
                    }
                  for(Polaczenie pol: nowePolaczenia){
                      this.instniejacePolaczenia.remove(pol);
                  }
                }
            }
        }
    }
     
    public List<Polaczenie> generujNowePolaczeniaH(int x, int y){
        List<Polaczenie> listaNowychPolaczeni = new ArrayList<Polaczenie>();
        if(x>0){
            listaNowychPolaczeni.add(new Polaczenie(this.graph[x][y], this.graph[x-1][y]));
        }
        if(y>0){
            listaNowychPolaczeni.add(new Polaczenie(this.graph[x][y], this.graph[x][y-1]));
        }
        
        return listaNowychPolaczeni;
    }
    
     public Rozwiazanie getRozwiazanie(float czas){
        return new Rozwiazanie(liczbaRozw, czas, iloscOdwiedzonychWezlow);
    }
    
}
