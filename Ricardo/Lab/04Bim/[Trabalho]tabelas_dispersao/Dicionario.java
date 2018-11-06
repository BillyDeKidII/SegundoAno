import java.util.*; //import para utilizao da colecao Queue E LinkedList

/** Dicionario.java
 * 
 * @author Jose Ricardo Guidetti Junior
 * @version 2015/09/26
 */
public class Dicionario<K, V> // declaracao da classe
{
  // classe de node para insercoes, 
 private static class Node<K,V> 
 {
  //variaveis privadas da classe Node
  private K chave; // referencia da palavra do dicionario 
  private V valor; // referencia da descricao da palavra
  private Node prox;    // referencia da proxima palavra do dicionario
 
 /**
  * O construtor da classe Node recebe argumentos para inicializar os campos
  * da classe.
  */
  public Node(K chave, V valor, Node prox)  
  { //inicializando variaveis
    this.chave  = chave;
    this.valor  = valor;
    this.prox = prox;
  }
 }
 
  /**
  * O construtor da classe Dicionario inicializa 
  *  o arranjo tabela com tamanho fixo 26 [0.25].
  */
 public Dicionario() 
 {
  aurelio = new Node[ALFABETO];
  inicializaListas();

 }  
 
 final void inicializaListas()
 {
  for(int i = 0; i < ALFABETO; i++)
  {
   aurelio[i] = null;
  }
 }
 
 private int hash(Object palavra) 
 {//recebe uma palavra e transforma em tudo minusculo
  palavra = palavra.toString().toLowerCase();

  // variavel 'pos', recebe a primeira letra da palavra 
  //em formato ASCII
  int pos =  palavra.toString().charAt(PRIMEIRA_LETRA);    

  //e fazemos uma conta para descobrir a posicao exata da letra.
  //sendo 'a' == 97, assim caso o 'pos' for igual 'a', ou seja 97,
  // entao basicamente fazemos 'a' - 'a', ou seja 97 - 97 asism
  //  retornando indice [0] e caso for a letra 'b', sera 98, assim ficando b - a,
  // ou seja, 98-97 == retornando indice 1. E assim por diante.
  return pos - CONVERSAO; // pos - 'a' ou pos - 97; retornando o indice
 } 
 
 /**
  * Retorna o numero de entradas
  *  AS == O(1)
  */
 public int tamanho() 
 {return n;} 
 
 /**
  * Indica se esta vazio.
  *  AS == O(1)
  */
 public boolean estaVazia() 
 {return tamanho() == 0;}

 
 /**
  * Recupera todos os elementos associados à chave k, ou retorna
  * null se não houver nenhum.
  *  AS == O(1), caso for o primeiro elemento, senao O(n)
  */
 public V encontrar(Object chave)
 {
  int i = hash(chave);
  //percorre o
  for (Node aux = aurelio[i]; aux != null; aux = aux.prox) 
  {
   if (chave.equals(aux.chave)){
    return (V) aux.valor;
   }
  }
  return null;
 }
 
  /**
   * Insere uma entrada (k, v), onde k é a chave e v é o elemento.
   * AS == O(1), caso for o primeiro elemento, senao O(n)
   */
 public void inserir(K chave, V elemento) 
 {
   if (elemento == null) 
   {
     remover(chave);
     return;
   }
   int i = hash(chave);
   //percorre a tabela ate o local falado pelo hash
   for (Node aux = aurelio[i]; aux != null; aux = aux.prox) 
   {
     if (chave.equals(aux.chave)) 
     {
       aux.valor = elemento;
       return;
     }
   }
   n++;    // incrementamos    e
   // e criamos novo elemento com as suas respectivas descricoes
   aurelio[i] = new Node(chave, elemento, aurelio[i]); 
 } 

 /**
  * Remove a entrada e.
  * retorno de.
  */
 public void remover(K chave)
 {
  //... da listao ou da tabela ?
 } 


 /**
  * Retorna uma coleção com todas as entradas do mapa.
  * retorno de O(n)
  */
 public Iterable<K> entradas()  
 {
   Queue<K> entradas = new LinkedList<K>();//criamos uma lista
   for (int i = 0; i < ALFABETO; i++) //percorremo ela
   {
     for (Node aux = aurelio[i]; aux != null; aux = aux.prox) 
     {
       entradas.add((K) aux.chave);//adicionamos o mesmo elementos do dicionario na lista
     }
   }
   return entradas;//retornamos a lista
 }

 /* Variaveis privadas da classe dicionario*/
 private int n;            // quantidade de insercoes
 private final int ALFABETO = 26;   // tamanho da tabela de hash
 private final int CONVERSAO = 97; // letra 'a' no alfabeto da tab. ASCII
 private final int PRIMEIRA_LETRA = 0;
 private Node[] aurelio; //tabela dicionario hash   
}

