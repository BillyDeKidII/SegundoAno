
/**
 * Lista.java
 * 
 * @author Jose Ricardo
 * @version 2015/26/09
 */
public class Lista
{
   public Lista()
   {}
   
   public Lista(Object c, Object v, Lista p)
   {
    this.chave = c;
    this.valor = v;
    this.prox = p;
   }
   
   public Object getChave()
   {return chave;}

   public void setChave(Object c)
   {this.chave = c;}
   
   public Object getValor()
   {return valor;}

   public void setDesricao(Object v)
   {this.valor = v ;}

   public Lista getProx()
   {return prox;}

   public void setProx(Lista p)
   {this.prox = p;}

   // variaveis privadas da classe Lista
   private Object chave;
   private Object valor;
   private Lista prox;
}
