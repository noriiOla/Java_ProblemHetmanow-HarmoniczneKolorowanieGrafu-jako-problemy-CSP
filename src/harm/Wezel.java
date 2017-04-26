
package harm;

import java.util.ArrayList;
import java.util.List;

public class Wezel {
    int color;
    int x;
    int y;
          
    List<Integer> dostepneKolory;

    Wezel(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.color = color;
        this.dostepneKolory = new ArrayList<Integer>();
    }
    
    Wezel(int x, int y, List<Integer> dostepneKolory){
        this.x = x;
        this.y = y;
        this.dostepneKolory = new ArrayList<Integer>();
        for(int kolor: dostepneKolory){
            this.dostepneKolory.add(kolor);
        }
    }
    
//    Wezel(int x, int y, List<Polaczenie> listaWolnychPolaczeni){
//        przypisz(listaWolnychPolaczeni);
//        //this.listaWolnychPolaczeni = listaWolnychPolaczeni;
//        this.x = x;
//        this.y = y;
//                this.dostepneKolory = new ArrayList<Integer>();
//
//    }
        
//    Wezel(List<Polaczenie> listaWolnychPolaczeni){
//        this.listaWolnychPolaczeni = new ArrayList<Polaczenie>();
//        for(int i =0 ; i< listaWolnychPolaczeni.size(); i++){
//            this.listaWolnychPolaczeni.add(listaWolnychPolaczeni.get(i));
//        }
//                this.dostepneKolory = new ArrayList<Integer>();
//
//        //this.listaWolnychPolaczeni = listaWolnychPolaczeni;
//    }
    
//    public void przypisz(List<Polaczenie> listaWolnychPolaczeni){
//        this.listaWolnychPolaczeni = new ArrayList<Polaczenie>();
//        for(int i =0 ; i< listaWolnychPolaczeni.size(); i++){
//            this.listaWolnychPolaczeni.add(listaWolnychPolaczeni.get(i));
//        }
//    }
    
    public void usunWszystkieKoloryZDostepnych(List<Integer> listaKolorow){
        List<Integer> nowaListaDostepnychKolorow = new ArrayList<Integer>();
        for(int kolor : this.dostepneKolory){
            if(!listaKolorow.contains(kolor)){
                nowaListaDostepnychKolorow.add(kolor);
            }
        }
        this.dostepneKolory = nowaListaDostepnychKolorow;
    }
}
