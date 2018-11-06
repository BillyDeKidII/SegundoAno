public class Grafo // Declaração da classe Grafo
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

	/** Atributos privados da classe Grafo */
	private int mat[][]; // peso do tipo inteiro
	private int pos[];   // posição atual ao se percorrer os adjs de um vértice v
	private int numVertices;	// total de vertices
	
    /**
     * Construtor para a classe Grafo, que inicializa os campos da classe.
     * A matriz que contém os pesos são inicializados como 0, e o arranjo
     * é inicilizado como -1, sendo representação de valores nulos.
     *
     * @param numVertices, total de vértices e tamanho da matriz e do arranjo
     */
	public Grafo ( int numVertices )
	{
		this.mat = new int [ numVertices ][ numVertices ];
		this.pos = new int [ numVertices ];
		this.numVertices = numVertices;
		for ( int i = 0; i < this.numVertices; i += 1 ) 
		{
			for ( int j = 0; j < this.numVertices; j += 1 ) this.mat[ i ][ j ] = 0;
				this.pos[ i ] = -1;
		}
	}
	
    public void inserAresta ( int v1, int v2, int peso)
    {
    	this.mat[ v1 ][ v2 ] = peso;
    }
    
    public boolean existeAresta ( int v1, int v2 )
    {
    	return (this.mat[ v1 ][ v2 ] > 0);
    }
    
    public boolean listaAdjVazia ( int v )
    {
    	for ( int i = 0; i < this.numVertices; i += 1 ) 
    		if ( this.mat[ v ][ i ] > 0 ) return false;
    	return true;
    }
    
    public Aresta primeiroListaAdj ( int v )
    {// Retorna a primeira areta que o vértice v participa ou
     //	null se a lista de adjacência de v for vazia
    	this.pos[ v ] = -1;
    	return this.proxAdj( v );
    }
    public Aresta proxAdj ( int v ) 
    {// Retorna a próxima aresta que o vértice v participa ou 
     // null se a lista de adjacência de v estiver no fim
    	this.pos[ v ] += 1;
    
    	while ( (this.pos[ v ] < this.numVertices) &&
    	 	(this.mat[ v ][ this.pos[ v ]]  == 0 ) ) this.pos[ v ] += 1;
    
    	if( this.pos[ v ] == this.numVertices ) return null;
    	else return new Aresta ( v, this.pos[ v ] , this.mat[ v ][this.pos[ v ]] );
    }
    
    public Aresta retiraAresta ( int v1, int v2 ) 
    {
    	if( this.mat[ v1 ][ v2 ] == 0 ) return null; // Aresta não existe
    	else{
    		Aresta aresta = new Aresta( v1, v2, this.mat[ v1 ][ v2 ] );
    		this.mat[ v1 ][ v2 ] = 0; 
    		return aresta;
    	}
    }
    
    public void imprime () 
    {
    	System.out.print( " " );
    	for ( int i = 0; i < this.numVertices; i += 1 )
    	
    		System.out.print( i + " " );
    		System.out.println( " " );
    	for ( int i = 0; i < this.numVertices; i += 1 )
    	{
    		System.out.print( i + " " );
    		for ( int j = 0; j < this.numVertices; j += 1 )
    				System.out.print( this.mat[ i ][ j ] + " " );
    			System.out.println( " " );
    	}		
    }
    
    public int numVertices () 
    {
    	return this.numVertices;
    }
}