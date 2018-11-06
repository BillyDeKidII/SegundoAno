import java.util.Random;
import java.util.Optional;

/**
 * Write a description of class UteisArranjo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UteisArranjo {    
    public static Integer[] novoArranjoCrescente(int length) {
        Integer[] arranjo = new Integer[length];
        for (int i = 0; i < arranjo.length; i++) {
            arranjo[i] = i;
        }
        return arranjo;
    }
    
    public static Integer[] novoArranjoDecrescente(int length) {
        Integer[] arranjo = new Integer[length];
        for (int i = 0; i < arranjo.length; i++) {
            arranjo[i] = arranjo.length - i;
        }
        return arranjo;
    }
    
    public static Integer[] novoArranjoAleatorio(int length, Optional<Integer> seed) {
        Integer[] arranjo = new Integer[length];
        Random r = seed.isPresent() 
            ? new Random(seed.get())
            : new Random();
        for (int i = 0; i < arranjo.length; i++) {
            arranjo[i] = r.nextInt(length);
        }
        return arranjo;
    }
    
    public static Integer[] novoArranjoAleatorio(int length) {
        return novoArranjoAleatorio(length, Optional.empty());
    }
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private UteisArranjo() {}
}
