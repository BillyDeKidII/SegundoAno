
/**
 * Entradas.java
 * 
 * @author Jose Ricardo Guidetti Junior
 * @version 2015/26/09/
 */
public interface metodos<K,V>
{
    /**
     * Retorna o número de entradas.
     */
    int tamanho();
    
    /**
     * Indica se está vazio.
     */
    boolean estaVazia();
    
    /**
     * Recupera um elemento associado à chave k, 
     * ou retorna null se não houver nenhum
     */
    V encontrar(K chave);
    
    /**
     * Recupera todos os elementos associados à chave k, ou retorna
     * null se não houver nenhum.
     */
    V encontrarTodos(K chave);
    
    /**
     * Insere uma entrada (k, v), onde k é a chave e v é o elemento.
     */
    void inserir (K chave,V valor);
    
    /**
     * Remove a entrada e.
     */
    void remover(Object e);
    
    /**
     * Retorna uma coleção com todas as entradas do mapa.
     */
    Iterable<K> entradas();
}
