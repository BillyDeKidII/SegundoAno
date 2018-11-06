import java.util.*;
/**
 * TabelaDispersão.java
 * 
 * @author Jose Ricardo Guidetti Junior
 * @version 09/25/2015
 */
public class TabelaDispersao // declaracao da classe
{
    
    private TabelaDispersao(int capacidade, int qntElementos) 
    {
        tabela = new Object[capacidade];
        this.qtdeElementos = qntElementos;
    }
    
     public TabelaDispersao(int capacidade) 
    {
        this(capacidade,0);
    }
    
    public TabelaDispersao() 
    {
        this(4);
    }
    
    
    /**
     * Insere o objeto na tabela em tempo médio de O(1).
     * 
     * @param o Objeto a ser inserido na tabela.
     */
    public void inserir(Object o) 
    {
        if(estaLotado()){
            expandir();
        }
        Node novo = new Node(o);
         if (o == null) 
         {
            remover(o);
            return;
        }
        int i = hash(o);
        Node aux = (Node)tabela[i];
        while(aux != null)
        {
            if(o.equals(aux.getValor()))
            {
                aux.setValor(o);
                return;
            }
            aux = aux.getProximo();
        }
        novo.setProximo((Node)tabela[i]);
        tabela[i] = novo;
        qtdeElementos++;
    }
    
    
    /**
     * Remove o objeto da tabela.
     * 
     * @param o Objeto a ser removido.
     * @return Objeto removido ou null, caso não haja objeto a ser removido.
     */
    public Object remover(Object o) 
    {
        int i = hash(o);
        if (o.equals(tabela[i])) 
        {
            o = tabela[i];
            tabela[i] = null;
            qtdeElementos--;
        }
        else 
        {
            o = null;
        }
        return o;
    }
    
    /**
     * Verifica se o objeto já consta na tabela.
     * 
     * @param o Objeto a ter a presença na tabela verificada.
     * @return Verdadeiro caso esteja na tabela.
     */
    public boolean haElemento(Object o) 
    {
        int i = hash(o);
        return o.equals(tabela[i]);
    }
    
    /**
     * Indica quantos elementos estão armazenados na coleção.
     */
    public int quantidadeElementos() 
    {
        return qtdeElementos;
    }
    
    public boolean isEmpty()         {return quantidadeElementos() == 0;}
    public boolean estaLotado()      {return quantidadeElementos() == tabela.length;} 
    
   private void expandir() {
            int novoTamanho = 2 * tabela.length;
            Object[] antiga = tabela;
            tabela = new Object[novoTamanho];
            qtdeElementos = 0;
            for (int i = 0; i < antiga.length; i++)
                  if (antiga[i] != null)
                        inserir(antiga[i]);

   }
   
    /**
     * Método que calcula a dispersão do objeto a ser inserido na tabela
     * 
     * @param o Objeto a ser inserido.
     * @return Valor de dispersão, índice onde será posicionado na tabela. Deve ser sempre >= 0.
     */
    private int hash(Object o) 
    {
        // Máscara binária que garante números inteiros >= 0
        return (o.hashCode() & 0x7fffffff) % tabela.length;
    }
   
   // variaveis privadas da classe TabelaDispersao
    private int qtdeElementos;
    private Object[] tabela;
}
