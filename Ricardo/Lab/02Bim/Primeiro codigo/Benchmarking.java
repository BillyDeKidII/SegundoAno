import java.util.Random;

public class Benchmarking
{
    public static void benchmark() {
        
        TabelaTempos tabela = new TabelaTempos();
        
        final int MENOR = 1000, MAIOR = 20000, PASSO = 1000;
        //System.out.println("Bubblesort, Selectionsort");
        for (int length = MENOR; length <= MAIOR; length += PASSO) {
            int[] arranjoOriginal = novoArranjoAleatorio(length);
            int[] arranjo = new int[length];
            
            final int REPETICOES = 10;
            long tempoMedioBubble = 0;
            long tempoMedioSelection = 0;
            for (int i = 0; i < REPETICOES; i++) {
                clonarArranjo(arranjo, arranjoOriginal);
                
                long tempoInicio = System.currentTimeMillis();
                bubblesort(arranjo);
                long tempoFim = System.currentTimeMillis();
                tempoMedioBubble += tempoFim - tempoInicio;
                
                tempoInicio = System.currentTimeMillis();
                selectionsort(arranjo);
                tempoFim = System.currentTimeMillis();
                tempoMedioSelection += tempoFim - tempoInicio;
            }
            tempoMedioBubble /= REPETICOES;
            tempoMedioSelection /= REPETICOES;
            
            System.out.println("Passo length = " + length);
            tabela.anotarAmostra(length, tempoMedioBubble, tempoMedioSelection);
        }
        
        tabela.setTitulo("Benchmarking Algoritmos Ordenação");
        tabela.setEtiquetaX("Length");
        tabela.setEtiquetaY("Tempo (ms)");
        tabela.setLegendas("Bubblesort", "Selectionsort");
        tabela.exibirGraficoXY();
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
