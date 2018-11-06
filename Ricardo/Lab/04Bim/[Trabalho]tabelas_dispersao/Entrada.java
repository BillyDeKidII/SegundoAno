import java.util.*;
/**
 * ListaDinamica.java
 * 
 * @author Jose Ricardo Guidetti Junior
 * @version 2015/09/26
 */
public class Entrada<K,V>
{
    Lista primeiro;
    Lista ultimo;
    int tamanho = 0;
    public Entrada()
    {
     primeiro = null;
     ultimo = primeiro;
    }

    
     /**
     * Retorna o número de entradas.
     */
    public int tamanho(){
        return tamanho;
    }
    
    /**
     * Indica se está vazio.
     */
    public boolean estaVazia(){
        return tamanho() ==0;
    }
    
    /**
     * Insere uma entrada (k, v), onde k é a chave e v é o elemento.
     */
    public void inserir (K chave,V valor){
     if(primeiro == null)
      {
        primeiro = new Lista();
        ultimo = primeiro;
      } 
        Lista novo = new Lista(chave,valor,null);
        ultimo.setProx(novo);
        ultimo = novo;
        tamanho++;
    }
    
    /**
     * Remove a entrada e.
     */
    public void remover(Object e){
     if(primeiro == null){return;}
      Lista remove = primeiro.getProx();
      Lista sentinela = primeiro;
      if(primeiro != null)
      {
        while(remove != null)
        {
          if(remove.getValor().equals(e))
          {
           if(remove.getProx() == null)
           {
             ultimo = sentinela;
             ultimo.setProx(null);
             remove = null;
             tamanho--;
                 break;
            }else
            {
             sentinela.setProx(remove.getProx());
             remove.setProx(null);
             remove = null;
             tamanho--;
                break;
            }
           }
          remove = remove.getProx();
          sentinela = sentinela.getProx();
        }         
       } 
    
    }
    
    public void print()
    {
        if(primeiro == null){return;}
      Lista percorre = primeiro.getProx();
      while(percorre != null)
      {
        System.out.println("Palavra = "+percorre.getChave()+"\n"+
        "Descricao = "+ percorre.getValor());
        percorre = percorre.getProx();
      }      
    }
}
