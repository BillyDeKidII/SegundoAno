package Grafos;

//importações para utilizar as coleções do Java.
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * 
 * @author José Ricardo Guidetti Junior
 * @version 11/18/2015
 */
public class GrafoAdjacencias < V, A > implements Grafo < V, A > // declaração da classe
{
  /**
   * Construtor da classe GrafoAdjacencias para inicialização das coleções
   */
  public GrafoAdjacencias()
  {
    this.vertices = new ArrayList < Vertice < V >> (); // lista para guardar os vértices
    this.adjacencias = new ArrayList < Aresta < A >> (); // lista para guardar as arestas
  }

  /**
   * Nesse método retornamos uma coleção de vertices
   * 
   * @return vertices, Lista conténdo os vértices guardados.
   */
  @Override
  public List < Vertice < V >> vertices()
  {
    return this.vertices;
  }

  /**
   * No método arestas retornamos uma lista que contém as arestas guardadas.
   * 
   * @return adjacencias, Um ArrayList conténdo as arestas
   */
  @Override
  public List < Aresta < A >> arestas()
  {
    return this.adjacencias;
  }

  /**
   * No método arestasIncidentes, mostra uma lista de Arestas que contém todas arestas  que são ligadas
   * umas com as outras
   * 
   * @return List<Aresta<A>>, Lista contendo as arestas incidentes
   */
  @Override
  public List < Aresta < A >> arestasIncidentes(Vertice < V > v)
  {
    ArrayList < Aresta < A >> incidentes = new ArrayList();
    for (Aresta a: adjacencias)
    {
      if (a == null) break;

      if ((a.getOrigem().equals(v)) || (a.getDestino().equals(v)))
      {
        incidentes.add(a);
      }
    }
    return incidentes;
  }


  @Override
  public Vertice < V > oposto(Vertice < V > v, Aresta < A > e)
  {
    for (Aresta a: this.arestas())
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
  public List < Vertice < V >> verticesFim(Aresta < A > e)
  {
    List < Vertice < V >> n = new ArrayList();

    n.add(e.getOrigem());

    n.add(e.getDestino());

    return n;
  }

  @Override
  public boolean saoAdjacentes(Vertice < V > v, Vertice < V > w)
  {
    // retorna true se v e w sao adjacentes
    for (Vertice vs: v.getAdjacentes())
    {
      if (vs.equals(w))
      {
        return true;
      }
    }
    return false;
    //throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
  }

  /**
   * No método mudarPeso recebe como argumento um vértice e um novo Atributo(o nome) a ser inserido
   * no vértice.
   * 
   * @param v, Referência para o vértice.
   * @param x, Novo atributo do vértice.
   * 
   * @return atributo, Retorna o novo atributo do vértice.
   */
  @Override
  public V mudarPeso(Vertice < V > v, V x)
  {
    v.setAtributos(x);
    return v.getAtributos();
  }

  /**
   * No método mudarPeso recebe como argumento uma aresta e o novo atributo(um identificador) 
   * a ser inserido na aresta.
   * 
   * @param e, Referência da aresta
   * @param x, Novo atributo da aresta.
   * 
   * @return
   */
  @Override
  public A mudarPeso(Aresta < A > e, A x)
  {
    e.setPeso(x);
    return e.getAtributos();
    //throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
  }

  /**
   * No método inserirVertice, recebe como argumento um atributo (um identificador) do vértice, e
   * cria-se um novo vértice passando para ele o argumento recebido, logo em seguida inserimos o 
   * novo vértice na lista de vértices.    
   * 
   * @param x, Atributo do vértice
   * 
   * @return ins, retorna o vértice inserido
   * 
   */
  @Override
  public Vertice < V > inserirVertice(V x)
  {
    Vertice < V > ins = new Vertice < V > (x);
    vertices.add(ins);
    return ins;
    //throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
  }

  /**
   * No método inserirAresta tem como objetivo inserir uma aresta no grafo, no método 
   * recebemos por parâmetro dois vértices e um atributo (o peso) para serem inseridos 
   * a lista de adjacencias do grafo.
   * 
   * @param v, Referência do vértice atual da aresta.
   * @param w, Referência do vértice a ser conectado o destino da aresta.
   * @param x, Atributo da aresta ou peso.
   * 
   * @return ins, retorna a aresta inserida.
   */
  @Override
  public Aresta < A > inserirAresta(Vertice < V > v, Vertice < V > w, A x)
  {
    Aresta < A > ins = new Aresta(v, w, x); //Cria-se uma nova aresta.
    adjacencias.add(new Aresta(v, w, x)); //Adiciona a lista de adjancencias
    return ins;
  }

  /**
   * No método removerVertice recebe com argumento um vértice de referência para ser removido
   * da lista de vértices do grafo, para isso ha de criar uma nova lista auxiliar e percorremos
   * 
   * @param v, Vértice para remover
   * 
   * @return atributos, retorna o atributo (o nome) do vértice removido.
   */
  @Override
  public V removerVertice(Vertice < V > v)
  {
    //
    ArrayList < Aresta < A >> aux = new ArrayList();

    for (Aresta a: adjacencias)
    {
      if (a == null)
      {
        break;
      }

      if ((a.getOrigem().equals(v)) || (a.getDestino().equals(v)))
      {
        aux.add(a);
      }
    }

    for (Aresta ar: aux)
    {
      if (ar == null)
      {
        break;
      }
      adjacencias.remove(ar);
    }

    for (Vertice ve: this.vertices)
    {
      if (ve.equals(v))
      {
        vertices.remove(ve);
        return v.getAtributos();
      }
    }
    return null;
  }


  /**
   * No método removerAresta recebemos como argumento uma aresta para ser removida,
   * nela então restauramos os valores para nulo e logo em seguida removemos da lista
   * de adjacências (que guarda as arestas).
   * 
   * @param e, Aresta para ser removida.
   * 
   * @return atributo, retorna o atributo (o peso) da aresta removida.
   */

  @Override
  public A removerAresta(Aresta < A > e)
  { // Colocamos os valores da origem e destino da aresta para nulo
    e.setOrigem(null);
    e.setDestino(null);

    adjacencias.remove(e); // E removemos essa aresta da lista de adjacências
    return e.getAtributos(); // retorna o atributo da aresta
  }

  /** Atributos privados da classe GrafoAdjacencias*/
  private ArrayList < Vertice < V >> vertices;
  private ArrayList < Aresta < A >> adjacencias;
}