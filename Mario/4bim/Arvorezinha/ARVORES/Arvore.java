package ARVORES;

/**
 * 
 */
public class Arvore {

    /** Construtor da classe Arvore*/
    public Arvore() {
        raiz = null; // iniciliazamos
    }
    
    public void inserir(int valor) {
        size++; // incrementamos o contador dos nodos
        inserirAuxiliar(raiz, valor);
    }
    
    private void inserirAuxiliar(Node node, int valor) {
        if( isEmpty() ) {// caso a árvore esteja vazia
            raiz = new Node(valor); //adiciona um novo Nodo e setamos o seu valor recebido.
        } else  // caso não esteja vazia
            if( valor < node.getValor() ) 
            {/* Caso o valor dado seje menor que o valor do nodo atual*/
                // vamos para esquerda
                if( node.getEsquerda() == null ){
                    node.setEsquerda(new Node(valor));// aqui já achamos o maior valor da direita, 
                                                      //entao inserimos um novo nó 
                }else{
                    inserirAuxiliar(node.getEsquerda(), valor);// vamos para a esquerda
                }
            }else
            {/* Caso o valor dado seje maior ou igual que o valor do nodo atual*/
                // vamos para direita
                if( node.getDireita() == null ) {
                    node.setDireita(new Node(valor));// aqui já achamos o maior valor da direita, 
                                                      //entao inserimos um novo nó 
                }else{
                    inserirAuxiliar(node.getDireita(), valor);// vamos para a direita
                }
        }
    } 
 
    public void remover(int valor) {
        size--; // decrementamos o contador dos nodos.
        removerAuxiliar(raiz, valor);
    }
    
    private Node removerAuxiliar( Node node, int valor ) {
        if(node == null)return node; // caso o nodo atual seje nulo não fazemos mais nada;
        else if(valor < node.getValor())node.setEsquerda(removerAuxiliar(node.getEsquerda(), valor)); 
        else if(valor > node.getValor())node.setDireita(removerAuxiliar(node.getDireita() ,valor));
        else
        {
           if(node.getEsquerda() == null && node.getDireita() == null){
               node = null;
               return node;
            } 
            else if(node.getEsquerda() == null){
                Node temp = node;
                node = node.getDireita();
                return node;
            } else if(node.getDireita() == null){
                Node temp = node;
                node = node.getEsquerda();
                return node;
            }
            else{
                Node temp = buscaMin(node.getDireita());
                node.setValor(temp.getValor());
                node.setDireita(removerAuxiliar(node.getDireita(), temp.getValor()));
            }
        }
        return node;
    }
    
    public Node busca(int key) {
        return search_recursively(key, raiz);
    }
    
    private Node search_recursively(int k, Node node) {
        if(node == null || node.getValor() == k) {
            return node;
        }
        else if( k < node.getValor() ) {
            return search_recursively(k,node.getEsquerda());
        }
        else {
            return search_recursively(k,node.getDireita());
        }
    }
    
    private Node buscaMin(Node root){
        while(root.getEsquerda() != null){
            root = root.getEsquerda();
        }
        return root;
    }
    
    private boolean isEmpty() {
        return contaNodes(raiz) == 0;
    }
    
    private int contaNodes( Node root ) {
        if( root == null ) {
            return 0;
        } else {
            int cont = 1;
            cont += contaNodes(root.getEsquerda());
            cont += contaNodes(root.getDireita());
            return cont;
        }
    }
    
   
    /** Atributos privados da classe Arvore.java*/
    private Node raiz;
    private int size;
}