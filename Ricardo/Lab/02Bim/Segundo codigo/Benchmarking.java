import java.util.Random;

public final class Benchmarking
{
    public static void benchmark() {
        int[] arrDecrescente = UteisArranjo.novoArranjoCrescente(200);
        System.out.println("Bubble -> " +
            Ordenacoes.bubblesort(UteisArranjo.clonarArranjo(arrDecrescente)));
        System.out.println("Selection -> " +
            Ordenacoes.selectionsort(UteisArranjo.clonarArranjo(arrDecrescente)));
        System.out.println("Insertion -> " +
            Ordenacoes.insertionsort(UteisArranjo.clonarArranjo(arrDecrescente)));
    }
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private Benchmarking() {}        
}
