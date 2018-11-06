
/**
 * Write a description of class OperadoresOrdenacoes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OperacoesOrdenacao {
    public int qtdeComps = 0;
    public int qtdeEscrs = 0;
    
    @Override
    public String toString() {
        return "Comparações: " + qtdeComps
            + ", escritas: " + qtdeEscrs;
    }
}
