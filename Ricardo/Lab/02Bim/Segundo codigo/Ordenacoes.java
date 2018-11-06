
/**
 * Write a description of class Ordenacoes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ordenacoes {
    
    public static class OperacoesOrdenacao {
        public int qtdeComps = 0;
        public int qtdeEscrs = 0;
        
        @Override
        public String toString() {
            return
                "Comparações: " + qtdeComps + 
                ", escritas: " + qtdeEscrs;
        }
    }
    
    /**
     * Ordena crescentemente o arranjo pelo algoritmo da bolha,
     * in-place.
     * @param arr arranjo de inteiros a ser ordenado.
     */
    public static OperacoesOrdenacao bubblesort(int[] arr) {
        OperacoesOrdenacao medicoes = new OperacoesOrdenacao();
        
        boolean houveTroca;
        do {
            houveTroca = false;
            for (int i = 1; i < arr.length; i++) {
                medicoes.qtdeComps++;
                if (arr[i-1] > arr[i]) {
                    medicoes.qtdeEscrs += 2;
                    trocar(arr, i-1, i);
                    houveTroca = true;
                }
            }
        } while(houveTroca);
        
        return medicoes;
    }
    
    /**
     * Ordena crescentemente o arranjo pelo algoritmo da seleção,
     * in-place.
     * @param arr arranjo de inteiros a ser ordenado.
     */
    public static OperacoesOrdenacao selectionsort(int[] arr) {
        OperacoesOrdenacao medicoes = new OperacoesOrdenacao();
        
        // Para cada posição, encontrar o elemento correto
        for (int i = 0; i < arr.length - 1; i++) {
            
            // Encontrar o menor elemento após o "i"
            int indiceMenor = i;
            for (int j = i+1; j < arr.length; j++) {
                medicoes.qtdeComps++;
                if (arr[indiceMenor] > arr[j]) {
                    indiceMenor = j;
                }
            }
            
            // Coloca o elemento correto na posicao
            medicoes.qtdeEscrs += 2;
            trocar(arr, i, indiceMenor);
        }
        
        return medicoes;
    }
    
    /**
     * Ordena crescentemente o arranjo pelo algoritmo da inserção,
     * in-place.
     * @param arr arranjo de inteiros a ser ordenado.
     */
    public static OperacoesOrdenacao insertionsort(int[] arr) {
        OperacoesOrdenacao medicoes = new OperacoesOrdenacao();
        
        // Comprar cada carta
        for (int i = 1; i < arr.length; i++) {
            // Carta comprada
            int seguro = arr[i];
            
            // Deslocar cartas para a direita, para abrir o espaço
            // correto da carta comprada.
            int j = i-1;
            while (j >= 0 && seguro < arr[j]) {
                medicoes.qtdeComps++;
                
                medicoes.qtdeEscrs++;
                arr[j+1] = arr[j];
                j--;
            }
            medicoes.qtdeComps++;
            
            // Colocar a carta no lugar
            medicoes.qtdeEscrs++;
            arr[j+1] = seguro;
        }
        
        return medicoes;
    }
    
    
    private static void trocar(int[] arr, int i, int j) {
        int seguro = arr[i];
        arr[i] = arr[j];
        arr[j] = seguro;
    }
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private Ordenacoes() {}
}
