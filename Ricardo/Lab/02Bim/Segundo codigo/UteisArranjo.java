import java.util.Random;
import java.util.Optional;

/**
 * Write a description of class UteisArranjo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UteisArranjo {
    public static void clonarArranjo(int[] dst, int[] src) {
        for (int i = 0; i < dst.length; i++) {
            dst[i] = src[i];
        }
    }
    
    public static int[] clonarArranjo(int[] src) {
        int[] dst = new int[src.length];
        for (int i = 0; i < dst.length; i++) {
            dst[i] = src[i];
        }
        return dst;
    }
    
    public static int[] novoArranjoCrescente(int length) {
        int[] arranjo = new int[length];
        for (int i = 0; i < arranjo.length; i++) {
            arranjo[i] = i;
        }
        return arranjo;
    }
    
    public static int[] novoArranjoDecrescente(int length) {
        int[] arranjo = new int[length];
        for (int i = 0; i < arranjo.length; i++) {
            arranjo[i] = arranjo.length - i;
        }
        return arranjo;
    }
    
    public static int[] novoArranjoAleatorio(int length, Optional<Integer> seed) {
        int[] arranjo = new int[length];
        Random r = seed.isPresent() 
            ? new Random(seed.get())
            : new Random();
        for (int i = 0; i < arranjo.length; i++) {
            arranjo[i] = r.nextInt(length);
        }
        return arranjo;
    }
    
    public static int[] novoArranjoAleatorio(int length) {
        return novoArranjoAleatorio(length, Optional.empty());
    }
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private UteisArranjo() {}
}
