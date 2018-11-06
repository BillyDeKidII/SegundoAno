
/**
 * Node.java
 * 
 * @author José Ricaro Guidetti Junior
 * @version 08/04/2015 21:32
 */
public class Node
{
    private int valor;
    private Node esquerda;
    private Node direita;
    
    public Node(){}
    
    public Node(int valor){this.valor = valor;}
    
    public Node getEsquerda(){
        return esquerda;
    }
    
    public Node getDireita(){
        return direita;
    }    
    
    public int getValor(){
        return valor;
    }
    
    public void setValor(int valor){
        this.valor = valor;
    }
    
    public void setEsquerda(Node esquerda){
        this.esquerda = esquerda;
    }

    public void setDireita(Node direita){
        this.direita = direita;
    }
    
    public String toString() {
    String resultado = getEsquerda().getValor()+" <- "+getValor()+" -> "+getDireita().getValor();
    return resultado;
    }
    
}