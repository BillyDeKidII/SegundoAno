import java.util.*;

public class Arvore {
    private Node raiz;
    private int tamanho;
    Node auxNode;

    public Arvore(){
        tamanho = 0;
    }
    public void inserir(Node no){
        /*if(raiz == null){
            this.raiz = node;
        }else{
            Node aux = raiz;
            boolean repetido = true;
            while(aux.getNodeDireita() != null){
                if(node.getX() == aux.getX() || node.getX() == raiz.getX()) repetido = false;
                if(node.getX() > aux.getX()){
                    aux = aux.getNodeDireita();
                }else{
                    aux = aux.getNodeEsquerda();
                }
            }
            
            if(repetido){ 
                if(node.getX() > aux.getX()){
                    aux.setNodeDireita(node);
                }else{
                    aux.setNodeEsquerda(node);  
                }
                tamanho++;                                          8
            }                                                   2      10   
        }*/                                    // 9
        Arvore auxArvore;
       
      
        if (this.raiz == null) {
            this.raiz = no;
        } else {
            auxNode = raiz;
            if (no.getX() > auxNode.getX()) {
                if (auxNode.getNodeDireita() != null) {
                    auxNode = auxNode.getNodeDireita();
                    inserir(auxNode.getNodeDireita());
                }else{
                    auxNode.setNodeDireita(no);
                }
            } else if (no.getX() < this.raiz.getX()) {
                if (no.getNodeEsquerda() != null) {
                    auxNode = auxNode.getNodeEsquerda();
                    inserir(auxNode.getNodeEsquerda());
                }else{
                    auxNode.setNodeEsquerda(no);
                }
            }
        }
    }
    
    public int nivel(){
        Node aux = raiz;
        int nivel = 0;
        if (aux == null) throw new IllegalArgumentException("Arvore vazia.");
        Deque<NodeNivel> fila = new ArrayDeque<>(); 

        fila.add(new NodeNivel(aux, nivel)); 

        while (!fila.isEmpty()) {
            NodeNivel atual = fila.removeFirst(); 

            if (atual.no.getNodeEsquerda() != null) {
                fila.add(new NodeNivel(atual.no.getNodeEsquerda(), atual.nivel+1));
            }
            if (atual.no.getNodeDireita() != null) {
                fila.add(new NodeNivel(atual.no.getNodeDireita(), atual.nivel+1));
            }

            if (atual.nivel > nivel) {
                nivel = atual.nivel;
            }
        }

        return nivel;
    }
    
    public int altura(Node raiz){
        if (raiz == null) return 0;

        return (int)Math.max(altura(raiz.getNodeEsquerda())+1, altura(raiz.getNodeDireita())+1);
    }
    
    public void imprimirArvore(){
        Node no = raiz;
        if (no == null) throw new IllegalArgumentException("Arvore vazia");
        Deque<Node> fila = new ArrayDeque<>();
        fila.add(no);
        while (!fila.isEmpty()) {
            Node atual = fila.removeFirst();
            System.out.printf("%s, ", atual.getX());
            if (atual.getNodeEsquerda() != null) fila.add(atual.getNodeEsquerda());
            if (atual.getNodeDireita() != null) fila.add(atual.getNodeDireita());
        }
    }
}