
package harm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class IOService {
    String nazwaPliku;
    
    public IOService(String nazwaPliku) {
        this.nazwaPliku = nazwaPliku;
    }
    
    public void zapisz(List<Rozwiazanie> rozwiazania){
        try{
          FileWriter fstream = new FileWriter("F:\\studia\\sem 6\\pracaWlasna\\Sztuczna\\lab\\z2\\wyniki\\"+this.nazwaPliku +".csv");
          BufferedWriter out = new BufferedWriter(fstream);
         int i=1;
          for(Rozwiazanie rozw: rozwiazania){
              out.write(i +";");
              out.write(rozw.liczbaRozwiazan+";");
              String czas = "" + rozw.czas;
              String[] tabCzas = czas.split("\\.");
              out.write(""+tabCzas[0] + "," + tabCzas[1] + ";"); //""+ tabCzas[0] + "," + tabCzas[1] + ";"
              out.write(rozw.liczbaOdwiedzonychWezlow +";");
             out.write("\n");
             i++;
          }     
          out.close();
          }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
       }     
    }
}
