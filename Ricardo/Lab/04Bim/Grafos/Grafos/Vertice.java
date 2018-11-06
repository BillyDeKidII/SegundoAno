package Grafos;

//importação para utilização de coleções do Java.
import java.util.List;
import java.util.ArrayList;

/**
 * A Classe Vértice contém campos e método para manipulação do vértice e suas respectivas 
 * arestas, a classe também representa um vértice no grafo.
 * 
 * @author José Ricardo Guidetti Junior 
 * @version 11/18/2015
 */
public class Vertice<V> // declaração da classe
{
    /**
     * Construtor da classe Vertice recebe argumento para inicializar
     * 
     * @param atributos, Nome ou informação do vértice.
     */
    public Vertice(V atributos) 
    {
        this.atributos = atributos;
        this.adjacencias = new ArrayList<Vertice<V>>();
    }
    
    /*Métodos acessores da classe*/
    public V getAtributos() { return this.atributos; }
    public void setAtributos( V a) { this.atributos = a; }
    
    /**
     * No método getAdjacent pega a lista de adjacencias e retorna ela.
     * 
     * @return adjacencias, Retorna a lista de aresta desse vértice. 
     */
    public List<Vertice<V>> getAdjacentes() {
        return this.adjacencias;
    }
    
    public Aresta inserirAresta(Vertice vertice, Object x) 
    {
        Aresta aresta = new Aresta(this, vertice, x);
        
        this.arestas.add(aresta);
        
        return aresta;
    }
    
    public Aresta inserirAresta(Vertice vertice, Aresta aresta, Object x) 
    {
        aresta.setDestino(vertice);
        aresta.setOrigem(this);
        aresta.setPeso(x);
        
        this.arestas.add(aresta);
        
        return aresta;
    } 
    
    public void inserirAdjacentes(Vertice adj)
    {
        this.adjacencias.add(adj);
    }
    
    public String toString(){
        return "atributos -> "+getAtributos();
    }
    
    public void removerVizinhos() {
        this.arestas = new ArrayList<Aresta>();
    }
    
    /**Atributos privados da classe Vertice*/
    private V atributos;
    
    private boolean visitado = false;
    
    private List<Vertice<V>> adjacencias = new ArrayList<Vertice<V>>();
    private List<Aresta> arestas = new ArrayList<Aresta>();
}
