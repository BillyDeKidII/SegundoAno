

public class GrafoComListaAdjacencia
{
    public static class Aresta // Declaração da classe Aresta
    {   
        /* Campos privados da classe Aresta */
        private int v1, v2, peso;

       /**
        * Construtor padrão
        */
        public Aresta ( ) { this(0,0,-1); }

       /**
        * Construtor para a classe Aresta, que recebe argumento para 
        * inicializar os campos da classe.
        *@param v1, origem do aresta
        *@param v2, destino do aresta
        *@param peso, peso do caminho da aresta  
        */
        public Aresta ( int v1, int v2, int peso)
        { 
            this.v1 = v1; 
            this.v2 = v2; 
            this.peso = peso; 
        }

        /** Acessores dos atributos */
        public int peso () { return this.peso; }
        public int v1   () { return this.v1  ; }
        public int v2   () { return this.v2  ; }
    }
    
    private int cab[], prox[], peso[];
    private int pos[]; // posção atual ao se percorrer os adjs de um vértice v
    private int numVertices, proxDisponivel;
    
    public GrafoComListaAdjacencia(int numVertices, int numArestas) 
    {
       int tam = numVertices + 2*numArestas;
       this.cab  = new int[tam]; this.prox = new int[tam];
       this.peso = new int[tam]; this.numVertices = numVertices;
       this.pos  = new int[this.numVertices];
       for(int i = 0; i < this.numVertices; i+= 1)
       {
           this.prox[i] = 0;
           this.cab[i]  = i;
           this.peso[i] = 0;
           this.pos[i]  = i;
       }
       this.proxDisponivel = this.numVertices;
    }

    public void insereAresta(int v1, int v2, int peso)
    {
    	if(this.proxDisponivel == this.cab.length)
    		System.out.println("Não ha espaco disponivel para a aresta");
		else
		{
			int ind = this.proxDisponivel += 1;
			this.prox[this.cab[v1]] = ind;
			this.prox[ind] = 0; this.peso[ind] = peso;
		} 
    }

    public boolean existeAresta(int v1, int v2)
    {
    	for(int i = this.prox[v1]; i != 0; i = this.prox[i])
    		if(this.cab[i] == v2) return true;
    	return false;
    }

    public boolean listaAdjVazia(int v)
    {
    	return (this.prox[v] == 0);
    }

    public Aresta primeiroListaAdj(int v)
    {
    	// Retorna se a primeira aresta que o vértice v participa ou
    	// null se a lista de adjacência de v for vazia
    	this.pos[v] = v;
    	return this.proxAdj(v);
    }

    public Aresta proxAdj(int v)
    {
    	// Retorna se a proxima aresta que o vértice v participa ou
    	// null se a lista de adjacência de v for vazia
    	this.pos[v] = this.prox[this.pos[v]];
    	if(this.pos[v] == 0) return null;
    	else return new Aresta(v,this.cab[pos[v]], this.peso[pos[v]]);
    }

    public Aresta retiraAresta(int v1, int v2)
    {
    	int i;
    	for (i = v1; this.prox[i] != 0 ; i = this.prox[i]) 
    		if(this.cab[this.prox[i]] == v2) break;
    	int ind = this.prox[i];
    	if(this.cab[ind] == v2) // Encontrou aresta
		{
			Aresta aresta = new Aresta(v1, v2, this.peso[ind]);
			this.cab[ind] = this.cab.length; // marca como removido
			if(this.prox[ind] == 0) this.cab[v1] = i; // último vértice
			this.prox[i] = this.prox[ind];
			return aresta;
    	}else return null;
    }

    public void imprime()
    {
    	for (int i = 0; i< this.numVertices; i += 1) 
    	{
    		System.out.println("Vertice " + i + ":");
    		for (int j = this.prox[i]; j != 0 ; j = this.prox[j])
		 		System.out.println(" "+this.cab[j]+"("+this.peso[j]+")");
    	}
	}	

	public int numVertices() { return this.numVertices; }
}

