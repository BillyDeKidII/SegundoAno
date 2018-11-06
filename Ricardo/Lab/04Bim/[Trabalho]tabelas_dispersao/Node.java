/**
* Node.java
*
* @Author: Jose Ricardo Guidetti Junior
* @Version: 2015/09/25
*
*/

public class Node
{
 private Object valor;
 private Node proximo;
 public int count;
 public Node(){}

 public Node(Object valor)
 {
     this.valor = valor;
 }

 public Node getProximo(){
   return proximo;
 }    

 public Object getValor(){
   return valor;
 }

 public void setValor(Object valor){
   this.valor = valor;
 } 

 public void setProximo(Node proximo){  
   this.proximo= proximo;
   ++count;
 }
 
 public String toString() {
   String resultado = getValor()+"";
   return resultado;
 }
}
