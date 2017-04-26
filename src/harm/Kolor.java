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
public class Kolor {
    int numerKoloru;
    List<Integer> stykajaceSieKolory;
    
    Kolor(int numerKoloru){
        this.numerKoloru = numerKoloru;
        this.stykajaceSieKolory = new ArrayList<Integer>();
        dodajStykajacySieKolor(numerKoloru);
      //  this.stykajaceSieKolory.add(numerKoloru);
    }
    
    Kolor(int numerKoloru, List<Integer> stykajaceSieKolory){
        this.numerKoloru = numerKoloru;
        this.stykajaceSieKolory = new ArrayList<Integer>();
        for(int kolor : stykajaceSieKolory){
            dodajStykajacySieKolor(kolor);
           // this.stykajaceSieKolory.add(kolor);
        }
    }
    
    
    public void dodajStykajacySieKolor(int kolor){
        if(!this.stykajaceSieKolory.contains(kolor)){
            this.stykajaceSieKolory.add(kolor);
        }
    }
   public void usunStykajacySieKolor(int kolorDoUsuniecia){
       List<Integer> nowaListaStykajacychSieKolorow = new ArrayList<Integer>();
       //nowaListaStykajacychSieKolorow.add(this.numerKoloru);
       for(int kolor : this.stykajaceSieKolory){
           if(kolor !=kolorDoUsuniecia){
               nowaListaStykajacychSieKolorow.add(kolor);
           }
       }
       this.stykajaceSieKolory = nowaListaStykajacychSieKolorow;
    }
}
