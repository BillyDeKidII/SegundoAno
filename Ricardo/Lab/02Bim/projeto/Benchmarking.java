import java.util.Random;

public class Benchmarking
{
    public static void benchmark()
    {
      int [] arrDecrescente = novoArranjoDecrescente(200);
      System.out.println(Ordenacoes.bubblesort(clonarArranjo(arrDecrescente)));
      System.out.println(Ordenacoes.selectionsort(clonarArranjo(arrDecrescente)));
      System.out.println(Ordenacoes.insertionsort(clonarArranjo(arrDecrescente)));
    }
    
        public static void clonarArranjo(int[] dst, int[] src) {
        for (int i = 0; i < dst.length; i++) {
            dst[i] = src[i];
        }
    }
    
    public static int[] novoArranjoCrescente(int length) {
        int[] arranjo = new int[length];
        for (int i = 0; i < arranjo.length; i++) {
            arranjo[i] = i;
        }
        return arranjo;
    }
    
    public static int[] novoArranjoAleatorio(int length) {
        int[] arranjo = new int[length];
        Random r = new Random(SEED);
        for (int i = 0; i < arranjo.length; i++) {
            arranjo[i] = r.nextInt(length);
        }
        return arranjo;
    }
    
    public static void selectionsort(int[] arranjo) {
        for (int i = 0; i < arranjo.length-1; i++) {     // n
            int maior = i; // (n - 1)
            for (int j = i+1; j < arranjo.length; j++) { // (n - 1) * n
                if (arranjo[maior] < arranjo[j]) {// (n - 1) * (n - 1)
                    maior = j;// (n - 1) * (n - 1)
                }
            }
            
            // swap
            int tmp = arranjo[maior]; // (n - 1)
            arranjo[maior] = arranjo[i]; // (n - 1)
            arranjo[i] = tmp; // (n - 1)
        }
    }
    
    public static void bubblesort(int[] arranjo) {
        boolean trocou;
        do {
            trocou = false;
            for(int i = 1; i < arranjo.length; i++) {
                if (arranjo[i-1] > arranjo[i]) {                    
                    int tmp = arranjo[i-1];
                    arranjo[i-1] = arranjo[i];
                    arranjo[i] = tmp;
                    trocou = true;
                }
            }
            
        } while (trocou);
    }
    
    private final static int SEED = 0;
}
