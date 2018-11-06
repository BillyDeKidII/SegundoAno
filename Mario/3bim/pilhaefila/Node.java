import java.lang.Math;

public class Node{
    private int x;
    private Node proximo;
    
    public Node(){
        x = (int) (Math.random() * 100);
    }

    public Node(int _x){
        this.x = _x;
    }
    
    public int getX(){ return this.x; }
    
    public Node getProximo(){ return this.proximo; }
    
    public void setX(int _x){ this.x = _x; }
    
    public void setProximo(Node _proximo){ 
        this.proximo = _proximo;
    }
}
