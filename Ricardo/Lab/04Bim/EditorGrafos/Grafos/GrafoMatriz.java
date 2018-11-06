package Grafos;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class GrafoMatriz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrafoMatriz<V, A> implements Grafo<V, A>
{
    /**
     * Constructor for objects of class GrafoMatriz
     */
    public GrafoMatriz() {
    }
    
    @Override
    public List<Vertice<V>> vertices() {
        throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
    }
    
    @Override
    public List<Aresta<A>> arestas() {
        throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
    }
    
    @Override
    public List<Aresta<A>> arestasIncidentes(Vertice<V> v) {
        throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
    }
    
    @Override
    public Vertice<V> oposto(Vertice<V> v, Aresta<A> e) {
        throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
    }
    
    @Override
    public List<Vertice<V>> verticesFim(Aresta<A> e) {
        throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
    }
    
    @Override
    public boolean saoAdjacentes(Vertice<V> v, Vertice<V> w) {
        throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
    }
    
    @Override
    public V mudarPeso(Vertice<V> v, V x) {
        throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
    }
    
    @Override
    public A mudarPeso(Aresta<A> e, A x) {
        throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
    }
    
    @Override
    public Vertice<V> inserirVertice(V x) {
        throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
    }
    
    @Override
    public Aresta<A> inserirAresta(Vertice<V> v, Vertice<V> w, A x) {
        throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
    }
    
    @Override
    public V removerVertice(Vertice<V> v) {
        throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
    }
    
    @Override
    public A removerAresta(Aresta<A> e) {
        throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
    }
    
    private ArrayList<Vertice<V>> vertices;
    private Aresta<A>[][] matrizArestas;
}
