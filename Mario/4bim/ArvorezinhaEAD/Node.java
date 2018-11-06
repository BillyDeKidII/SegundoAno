public class Node{
    private int x;
    private Node direita;
    private Node esquerda;
    

    public Node(){
        this.x = (int) (Math.random() * 100);
    }
    
    public Node(int _x){
        this.x = _x;
    }
    
    public void setX(int _x){
        this.x = _x;
    }
    
    public void setNodeDireita(Node _node){
        this.direita = _node;
    }
    
    public void setNodeEsquerda(Node _node){
        this.esquerda = _node;
    }
    
    public int getX(){
        return this.x;
    }
    
    public Node getNodeDireita(){
        return this.direita;
    }
    
    public Node getNodeEsquerda(){
        return this.esquerda;
    }
}
