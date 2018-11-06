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
    private int numVertices;
    private ArrayList<Aresta<A>> adjacencias;
   
    /**
     * Constructor for objects of class GrafoMatriz
     */
    public GrafoMatriz() {
        this.vertices = new ArrayList<Vertice<V>>();
        this.adjacencias = new ArrayList<Aresta<A>>();
        this.matrizArestas = (Aresta<A>[][])new Aresta[vertices.size()][vertices.size()];
    }
    
    @Override
    public List<Vertice<V>> vertices() {
       return  this.vertices;
    }
    
    @Override
    public List<Aresta<A>> arestas() {
       return this.adjacencias;
    }
    
    @Override
    public List<Aresta<A>> arestasIncidentes(Vertice<V> v) {
        ArrayList<Aresta<A>> incidentes = new ArrayList();
        
        for (Aresta a : this.adjacencias) {
            if (a == null) break;
            
            if((a.getOrigem().equals(v)) || (a.getDestino().equals(v))) {
                incidentes.add(a);
            }
        }
        
        return incidentes;
    }
    
    @Override
    public Vertice<V> oposto(Vertice<V> v, Aresta<A> e) {
      for (Aresta a: this.adjacencias)
      {
          if (a.equals(e))
          {
            if (v.equals(a.getOrigem()))
            {
              return a.getDestino();
            }
            else
            {
              return a.getOrigem();
            }
          }
      }
      return null; //chegou aqui não existe
    }
    
    @Override
    public List<Vertice<V>> verticesFim(Aresta<A> e) {
        List < Vertice < V >> n = new ArrayList();

        n.add(e.getOrigem());

        n.add(e.getDestino());

        return n;
    }
    
    @Override
    public boolean saoAdjacentes(Vertice<V> v, Vertice<V> w) {
        for(Aresta a: this.adjacencias){            
            if (a == null) break;
            
            if(a.getOrigem().equals(v)){
                if(a.getDestino().equals(w)) return true; 
                
            }else if(a.getDestino().equals(v)){                
                if(a.getOrigem().equals(w)) return true;                
            }
        }
        return false;
    }
    
    private int indiceVertice(Vertice<V> v) {
        int i = 0;
        for (Vertice ve : this.vertices) {
            if (ve == null) break;
            if (ve.equals(v)) {
                return i;
            }
            i++;
        }
        return i;
    }
    
    @Override
    public V mudarPeso(Vertice<V> v, V x) {
        v.setAtributos(x);
        return v.getAtributos();
    }
    
    @Override
    public A mudarPeso(Aresta<A> e, A x) {
        e.setPeso(x);
        return e.getAtributos();
    }
    
    @Override
    public Vertice<V> inserirVertice(V x) {
        Vertice<V> ins = new Vertice<V>(x);
        vertices.add(ins);
        if (vertices.size() >= matrizArestas.length) {
            Aresta<A>[][] aux = (Aresta<A>[][])new Aresta[vertices.size()*2][vertices.size()*2];
            for (int i = 0; i < matrizArestas.length; i++) {
                for (int j = 0; j < matrizArestas.length; j++) {
                    aux[i][j] = matrizArestas[i][j];
                }
            }
            matrizArestas = aux;
        }
        return ins;
        //throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
    }
    
    @Override
    public Aresta<A> inserirAresta(Vertice<V> v, Vertice<V> w, A x) {
        Aresta<A> ins = new Aresta(v, w, x);
        adjacencias.add(ins);
        
        matrizArestas[indiceVertice(v)][indiceVertice(w)] = ins;
        
        return ins;
    }
    
    @Override
    public V removerVertice(Vertice<V> v) {
      ArrayList<Aresta<A>> aux = new ArrayList();
        for (Aresta a : this.adjacencias ) {
            if (a == null) break;
            
            if ((a.getOrigem().equals(v)) || (a.getDestino().equals(v))) {
                aux.add(a);
            }
        }
        
        for (Aresta a : aux) {
            if (a == null) break;
            matrizArestas[indiceVertice(a.getOrigem())][indiceVertice(a.getDestino())] = null;
            adjacencias.remove(a);
        }
        
        for (Vertice vert : vertices) {
            if (vert.equals(v)) {
                vertices.remove(vert);
                return v.getAtributos();
            }
        }
        
        return null;
    }
    
    @Override
    public A removerAresta(Aresta<A> e) {
        e.setOrigem(null);
        e.setDestino(null);

        adjacencias.remove(e); // E removemos essa aresta da lista de adjacências
        return e.getAtributos(); // retorna o atributo da aresta
    }
    
    private ArrayList<Vertice<V>> vertices;
    private Aresta<A>[][] matrizArestas;
}
