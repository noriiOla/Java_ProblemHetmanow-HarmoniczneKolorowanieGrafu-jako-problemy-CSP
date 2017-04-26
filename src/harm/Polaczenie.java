
package harm;

public class Polaczenie {
    int color1;
    int color2;

    public Polaczenie(int color1, int color2) {
        this.color1 = color1;
        this.color2 = color2;
    }
    
    public boolean porownaj(Polaczenie secPol) {

        return (((this.color1 ==  secPol.color1)
            && (this.color2 ==  secPol.color2)) || ((this.color1 ==  secPol.color2)
            && (this.color2 ==  secPol.color1)) );
    }
}
