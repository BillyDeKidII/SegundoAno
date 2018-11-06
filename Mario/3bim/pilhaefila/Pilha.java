
/**
 * Write a description of class Pilha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pilha{
    private Node topo;

    /**
     * Constructor for objects of class Pilha
     */
    public Pilha(){
    }

    public void empilhar(Node node){
        if(pilhaVazia()){
            topo = node;
        }else{
            node.setProximo(topo);
            topo = node;
        }
    }
    
    public void desempilhar(){
        if(!pilhaVazia()){
            topo = topo.getProximo();
        }
    }
    
    public boolean pilhaVazia(){
        if(topo == null){
            return true;
        }else{
            return false;
        }
    }
    
    public Node getTopo(){
        return this.topo;
    }
    
    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        Node aux = topo;
        if(aux == null){
            return "[]";
        }else{
            while(aux.getProximo() != null){
                strBuilder.append(aux.getX() + "\n");
                aux = aux.getProximo();
            }
            strBuilder.append(aux.getX()+ "\n");
            return strBuilder.toString(); 
        }
    }
}
