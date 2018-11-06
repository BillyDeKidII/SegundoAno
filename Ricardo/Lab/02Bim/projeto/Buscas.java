import java.util.Optional;

/**
 * Algoritmos de busca escritos em sala de aula.
 */
public class Buscas {
    
    /**
     * Busca pelo valor chave no arranjo arr e, se existir, retorna
     * o índice da ocorrência de chave em arr.
     * 
     * @param arr arranjo onde chave será busca.
     * @param chave valor a ser buscado.
     * @return índice de chave em arr, se existir.
     */
    public static Optional<Integer> busca(int[] arr, int chave) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == chave) {
                return Optional.of(i);
            }
        }
        
        return Optional.empty();
    }
    
    /**
     * Busca pelo valor chave no arranjo arr e, se existir, retorna
     * o índice da ocorrência de chave em arr.
     * 
     * @param arr arranjo onde chave será busca. PRECOND: estar ordenado.
     * @param chave valor a ser buscado.
     * @return índice de chave em arr, se existir.
     */
    public static Optional<Integer> buscaBinaria(int[] arr, int chave) {
        int l = 0;
        int r = arr.length;
        while (r - l > 1) {
            int meio = (r - l) / 2;
            if (arr[meio] == chave) {
                return Optional.of(meio);
            } else if (arr[meio] < chave) {
                r = meio;
            } else { // if (arr[meio] > chave)
                l = meio + 1;
            }
        }
        
        return Optional.empty();
    }
    
    /**
     * Busca pelo valor chave no arranjo arr e, se existir, retorna
     * o índice da ocorrência de chave em arr.
     * 
     * @param arr arranjo onde chave será busca. PRECOND: estar ordenado.
     * @param chave valor a ser buscado.
     * @return índice de chave em arr, se existir.
     */
    public static Optional<Integer> buscaBinariaRecursivo(int[] arr, int chave) {
      return null;  
    }
}
