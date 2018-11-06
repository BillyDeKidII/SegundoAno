import java.util.Arrays;
import java.util.function.Function;

public final class Benchmarking
{
    public static void benchmark() {
        final int DE = 2000, ATE = 8500, PASSO = 500, AMOSTRAGEM = 10;
        
        Medicao[] resultadosBubble = benchmarkOrdenacao(
            Ordenacoes::bubblesort, DE, ATE, PASSO, AMOSTRAGEM);
        Medicao[] resultadosSelection = benchmarkOrdenacao(
            Ordenacoes::selectionsort, DE, ATE, PASSO, AMOSTRAGEM);
        Medicao[] resultadosInsertion = benchmarkOrdenacao(
            Ordenacoes::insertionsort, DE, ATE, PASSO, AMOSTRAGEM);
        
        System.out.println("Qtde,bubblesort(ms),selectionsort(ms),insertionsort(ms)");
        
        TabelaTempos tabela = new TabelaTempos();
        
        for (int i = 0; i < resultadosBubble.length; i++) {
            assert resultadosBubble[i].qtdeElems == resultadosSelection[i].qtdeElems;
            assert resultadosBubble[i].qtdeElems == resultadosInsertion[i].qtdeElems;
            
            System.out.println(resultadosBubble[i].qtdeElems + ","
                + resultadosBubble[i].tempo + ","
                + resultadosSelection[i].tempo + ","
                + resultadosInsertion[i].tempo);
                
            tabela.anotarAmostra(resultadosBubble[i].qtdeElems,resultadosBubble[i].tempo,resultadosSelection[i].tempo,resultadosInsertion[i].tempo);
        }
        
        tabela.setTitulo("Benchmarking com média de 10 amostragens");
        tabela.setLegendas("BubbleSort", "SelectionSort", "InsertionSort");
        tabela.setEtiquetaX("Qtde Elementos");
        tabela.setEtiquetaY("Tempo (ms)");
        tabela.exibirGraficoXY();
    }
    
    /**
     * Método que realiza benchmarking de tempo de execução para um dado 
     * método de ordenação, variando a quantidade de elementos do arranjo
     * de entrada de um limite inferior até outro superior, por incrementos
     * configurável. Para remover interferência, utiliza média de amostragem
     * 
     * @param ordenacao Referência para o método de ordenação a ser mensurado.
     * @param de Limite inferior da quantidade de elementos do arranjo de entrada.
     * @param ate Limite superior da quantidade de elementos do arranjo de entrada.
     * @param passo Incremento na quantidade de elementos.
     * @param amostragem Quantidade de testes a serem feitos para cada incremento,
     *                   para tirada da mêdia e remoção de ruídos.
     * 
     * @return Arranjo com cada medição, ordenado crescentemente pela quantidade
     *         de elementos de entrada.
     */
    private static Medicao[] benchmarkOrdenacao(
            Function<Integer[], OperacoesOrdenacao> ordenacao,
            int de, int ate, int passo, int amostragem) {
        
        final int qtosResultados = (ate - de) / passo;
        Medicao[] resultados = new Medicao[qtosResultados];                
        for (int qtde = de, r = 0; qtde < ate; qtde += passo, r++) {            
            Integer[] arrDecrescente = UteisArranjo.novoArranjoDecrescente(qtde);
            
            long tTotal = 0;
            for (int amostra = 0; amostra < amostragem; amostra++) {
                Integer[] copia = Arrays.copyOf(arrDecrescente, arrDecrescente.length);
                
                long tInicio = System.currentTimeMillis();
                ordenacao.apply(copia);
                long tFinal = System.currentTimeMillis();
                
                tTotal += tFinal - tInicio;
            }
            
            long tMedia = tTotal / amostragem;
            resultados[r] = new Medicao(qtde, tMedia);
        }
        
        return resultados;
    }
    
    public static class Medicao {
        public int qtdeElems;
        public long tempo;
        
        public Medicao(int qtde, long tempo) {
            this.qtdeElems = qtde; this.tempo = tempo;
        }
    }
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private Benchmarking() {}        
}
