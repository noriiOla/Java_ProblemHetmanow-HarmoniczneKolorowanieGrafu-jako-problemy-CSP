/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harm;

import java.util.List;

/**
 *
 * @author Ola
 */
public class Hetman {
    int x; 
    int y;
    List<Miejsce> listaWolnychMiejsc;
    
    Hetman(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    Hetman(int y){
        this.y = y;
    }
    
    Hetman(Miejsce miejsce){
        this.x = miejsce.x;
        this.y = miejsce.y;
    }
    
    Hetman(int y, List<Miejsce> listaWolnychMiejsc){
        this.y = y;
        this.listaWolnychMiejsc = listaWolnychMiejsc;
    }
    
    
}
