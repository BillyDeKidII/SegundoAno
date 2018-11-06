
/**
 * Write a description of class Ingresso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ingresso
{
    public Ingresso(char setor, char fileira, int cadeira) {
        this.setor = setor;
        this.fileira = fileira;
        this.cadeira = cadeira;
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    // De 1 a 100
    private int cadeira;
    
    // De 'a' a 'z'
    private char fileira;
    
    // De 'A' a 'F'
    private char setor;
}
