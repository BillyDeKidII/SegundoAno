package Grafos;

/**
 * Classe Aresta que representa a aresta do grafo, nela são contém operações
 * para inicializar valores da aresta, como a origem, seu destino e também
 * a inserção do peso, definido como atributo da aresta.
 * 
 * @author José Ricardo Guidetti Junior
 * @version 11/17/2015
 */
public class Aresta<A> //Declaração da classe
{
    /**
     * Construtor da classe Aresta, que recebe como argumento duas vértices
     * e um valor representando o peso da aresta, nesse construtor são realizados
     * apenas a inicialização de seus valores
     * 
     * @param o, A <b>Origem</b> da aresta, do tipo <i>Vertice</i>.
     * @param d, O <b>Destino</b> da aresta, do tipo <i>Vertice</i>.
     * @param a, O <b>peso</b> do caminho da aresta
     */
    public Aresta(Vertice o, Vertice d, A a)
    {
        this.origem = o; 
        this.destino = d;
        this.atributos = a;
    }
    
    // Acessores dos atributos da aresta
    public Vertice getOrigem ( ){return origem;}
    public Vertice getDestino( ){return destino;}
    
    public A getAtributos ( )
    {
        return atributos;
    }
    
    // Modificadores dos atributos da aresta
    public void setOrigem ( Vertice o ){this.origem = o;}
    public void setDestino( Vertice d ){this.destino = d;}
    public void setPeso( A p ){this.atributos = p;}
    
    /** Variáveis privadas da classe Aresta*/
    private A atributos;    
    private Vertice origem;
    private Vertice destino;
}
