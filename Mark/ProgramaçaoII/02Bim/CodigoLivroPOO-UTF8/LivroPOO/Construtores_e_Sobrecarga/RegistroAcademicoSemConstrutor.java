/** 
 * A classe RegistroAcademicoSemConstrutor contém campos para representar
 * dados simples sobre um registro acadêmico.
 */
class RegistroAcademicoSemConstrutor // declaração da classe 
  {
 /**
  * Declaração dos campos da classe
  */
  private String nomeDoAluno; // O nome do aluno 
  private int númeroDeMatrícula; // O número de matrícula
  private byte códigoDoCurso; // O código do curso do aluno (1..4)
  private double percentualDeCobrança; // O percentual a ser cobrado do aluno, 0 a 100%

 /**
  * O método inicializaRegistroAcademicoSemConstrutor recebe argumentos para 
  * inicializar os campos da classe RegistroAcademicoSemConstrutor.
  * @param n o nome do aluno
  * @param m o número de matrícula
  * @param c o código do curso
  * @param p o percentual de bolsa
  */
  public void inicializaRegistroAcademicoSemConstrutor(String n,int m,byte c,double p)
    {
    nomeDoAluno = n; númeroDeMatrícula = m; 
    códigoDoCurso = c; percentualDeCobrança = p;
    } // fim do método inicializaRegistroAcademicoSemConstrutor

 /**
  * O método calculaMensalidade calcula e retorna a mensalidade do aluno usando
  * o código do seu curso e o percentual de cobrança.
  * @return o valor da mensalidade do aluno
  */
  public double calculaMensalidade()
    {
    double mensalidade = 0; // valor deve ser inicializado 
    // Primeiro, dependendo do curso do aluno, determina a mensalidade básica
    if (códigoDoCurso == 1) // Arquitetura
      mensalidade = 450.00;
    if (códigoDoCurso == 2) // Ciência da Computação
      mensalidade = 500.00;
    if (códigoDoCurso == 3) // Engenharia da Computação
      mensalidade = 550.00;
    if (códigoDoCurso == 4) // Zootecnia
      mensalidade = 380.00;
    // Agora calcula o desconto com o percentual de cobrança. Se o percentual de
    // cobrança for zero, a mensalidade também o será.
    if (percentualDeCobrança == 0) mensalidade = 0; 
    // Senão, calculamos com uma fórmula simples.
    else mensalidade = mensalidade * 100.0 / percentualDeCobrança;
    return mensalidade;
    } // fim do método calculaMensalidade

  } // fim da classe RegistroAcademicoSemConstrutor
