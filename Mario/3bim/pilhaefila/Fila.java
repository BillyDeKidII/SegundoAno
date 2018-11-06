
/**
 * 
 * @author Thiago Romão 
 * @version 1.0.6
 */
public class Fila{
    private Node primeiro;
    private Node ultimo;
    
    public Fila(){
        
    }
    
    public void enfileirar(Node node){//Pega node já criado e enfileira conforme possivel
        if(filaVazia()){
            primeiro = node;
            ultimo = node;
        }else{
            ultimo.setProximo(node);
            ultimo = node;
        }
    }
    
    public void desenfileirar(){//Pega na fila o ultimo e retira da fila
        primeiro = primeiro.getProximo();
    }
    
    public boolean filaVazia(){
        if((primeiro == null)&&(ultimo == null)){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        Node aux = primeiro;
        if(aux == null){
            return "[]";
        }else{
            strBuilder.append("[");
            while(aux.getProximo() != null){
                strBuilder.append(aux.getX() + "->");
                aux = aux.getProximo();
            }
            strBuilder.append(aux.getX());
            strBuilder.append("]");
            return strBuilder.toString(); 
        }
    }
    
    public Node getPrimeiro(){
        return this.primeiro;
    }
    
    public Node getUltimo(){
        return this.ultimo;
    }
}
