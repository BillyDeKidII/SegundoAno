/** 
 * A classe Data contém campos e métodos que permitem a manipulação de datas.
 * Esta versão da classe tem os campos protegidos para evitar a sua manipulação 
 * incorreta - valores dos campos só podem ser acessados através de métodos.
 */
class Data // declaração da classe 
  {
  /**
   * Declaração dos campos da classe
   */
  private byte dia,mês; // dia e mês são representados por bytes
  private short ano; // ano é representado por um short

  /**
   * O método inicializaData recebe argumentos para inicializar os campos da classe
   * Data. Este método chama o método dataÉVálida para verificar se os argumentos
   * correspondem a uma data válida: se forem, inicializa os campos, caso contrário
   * inicializa todos os três campos com o valor zero.
   * @param d o argumento correspondente ao método dia
   * @param m o argumento correspondente ao método mês
   * @param a o argumento correspondente ao método ano
   */
  public void inicializaData(byte d,byte m,short a)
    {
    if (dataÉVálida(d,m,a)) // se a data for válida, inicializa os campos com os 
                            // valores passados como argumentos
      {
      dia = d; mês = m; ano = a;
      }
    else // caso contrário, inicializa os campos com zero
      {
      dia = 0; mês = 0; ano = 0;
      }
    } // fim do método inicializaData

  /**
   * O método retornaDia retorna o dia da data encapsulada, já que o campo dia, sendo
   * declarado como private, não poderá ser acessado diretamente de fora da classe.
   * @return o dia encapsulado pela classe
   */
  public byte retornaDia()
    {
    return dia;
    } // fim do método retornaDia

  /**
   * O método retornaMês retorna o mês da data encapsulada, já que o campo mês, sendo
   * declarado como private, não poderá ser acessado diretamente de fora da classe.
   * @return o mês encapsulado pela classe
   */
  public byte retornaMês()
    {
    return mês;
    } // fim do método retornaMês

  /**
   * O método retornaAno retorna o ano da data encapsulada, já que o campo ano, sendo
   * declarado como private, não poderá ser acessado diretamente de fora da classe.
   * @return o ano encapsulado pela classe
   */
  public short retornaAno()
    {
    return ano;
    } // fim do método retornaAno

  /**
   * O método dataÉVálida recebe três valores como argumentos e verifica de maneira 
   * simples se os dados correspondem a uma data válida. Se a data for válida, retorna
   * a constante booleana true, caso contrário, retorna a constante booleana false.
   * Vale a pena notar que este algoritmo é simples e incorreto, um dos exercícios 
   * sugere a implementação do algoritmo correto.
   * @param d o argumento correspondente ao método dia
   * @param m o argumento correspondente ao método mês
   * @param a o argumento correspondente ao método ano
   * @return true se a data for válida, false se não for válida
   */
  public boolean dataÉVálida(byte d,byte m,short a)
    {
    if ((d >=1) &&      // se o dia for maior ou igual a 1  E
        (d <= 31) &&    // se o dia for menor ou igual a 31  E
        (m >= 1) &&     // se o mês for maior ou igual a 1  E
        (m <= 12))      // se o mês for menor ou igual a 12  ENTÃO
      return true;      // a data é válida, retorna true
    else
      return false;     // a data não é válida, retorna false
    } // fim do método dataÉVálida

  /**
   * O método éIgual recebe uma instância da própria classe Data como argumento e
   * verifica se a data representada pela classe e pela instância que foi passada é
   * a mesma. A comparação é feita comparando os campos da data um a um.
   * @param outraData uma instância da própria classe Data
   * @return true se a data encapsulada for igual à passada, false caso contrário
   */
  public boolean éIgual(Data outraData)
    {
    if ((dia == outraData.dia) &&    // se os dois dias forem iguais E
        (mês == outraData.mês) &&    // se os dois meses forem iguais E
        (ano == outraData.ano))      // se os dois anos forem iguais então
      return true;      // a data é igual, retorna true
    else
      return false;     // a data é diferente, retorna false
    } // fim do método éIgual

  /**
   * O método mostraData não recebe argumentos nem retorna valores. Este método somente
   * imprime os valores dos campos, formatados de forma que uma barra ("/") seja
   * impressa entre eles. Quando o valor do ano for impresso, uma quebra de linha 
   * também será impressa.
   */
  public void mostraData()
    {
    System.out.print(dia);
    System.out.print("/");
    System.out.print(mês);
    System.out.print("/");
    System.out.println(ano);
    }  // fim do método mostraData

  } // fim da classe Data
