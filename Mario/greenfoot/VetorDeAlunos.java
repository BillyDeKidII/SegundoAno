import java.util.Arrays;
/**
 * Write a description of class Vetor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VetorDeAlunos
{
    // instance variables - replace the example below with your own
    private Aluno alunos[];
    private int ultimaPosicao;
    /**
     * Construtor 
     */
    public VetorDeAlunos(){
        alunos = new Aluno[20];
        ultimaPosicao = 0;
    }
    
    
    /**
     * Metodo para inserir aluno na lista. Este metodo insere o aluno na ultima posiçao
     * disponivel
     * @params  Aluno aluno - Aluno a ser inserido no vetor.
     * 
     */
    public void inserir(Aluno aluno){
      if(ultimaPosicao < espacoAlocado())
      {
       this.alunos[ultimaPosicao] = aluno;
       ultimaPosicao++;
      }
    }
    
    
    /**
     * Metodo para inserir aluno na lista. Este metodo insere o aluno na ultima posiçao
     * disponivel
     * @params  Aluno aluno - Aluno a ser inserido no vetor.
     *          int indice  - posiçao onde o aluno sera inserido. 
     */
    public void inserir(Aluno aluno, int indice){
        for(int i = ultimaPosicao - 1; i >= indice; i-=1) {
            alunos[i+1] = alunos[i];
        }
        alunos[indice] = aluno;
        ultimaPosicao++;
    }
    
    
    /**
     * Metodo para remover aluno na lista. Este metodo remove o aluno passado como parametro.
     * 
     * @params  Aluno aluno - Aluno a ser inserido no vetor.
     * 
     */
    public void remover(Aluno aluno, int indice)
    {
    
    }
    
    
    /**
     * Metodo para remover aluno na lista. Este metodo remove o aluno passado na posicao do indice.
     * 
     * @params  int indice  - posiçao que sera removida.
     * 
     */
    public void remover(int indice)
    {
    }
    
    
    public boolean existe(Aluno aluno){
        for(int i = 0; i < ultimaPosicao; i++) {
            if(aluno.equals(alunos[i])) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo para retornar um aluno da lista, dado um indice.
     * 
     * @params  int indice  - posiçao 
     * 
     */
    public Aluno get(int indice){
        return alunos[indice];
    }

    /**
     * Metodo para retornar o ultimo aluno da lista.
     * 
     * 
     */
    public Aluno getUltimo(){
        return alunos[ultimaPosicao - 1];
    }
    
  
    
    /**
     * Metodo para retornar o tamanho da lista.
     * 
     * @params  int indice  - posiçao 
     * 
     */    
    public int tamanho(){
        return ultimaPosicao;
    }
    
    
    public int espacoAlocado(){
        return alunos.length;
    }
    
    
    @Override
    public String toString(){
        return Arrays.toString(alunos);
    }
}
