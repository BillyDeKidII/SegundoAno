/** 
 * A classe Comparavel encapsula um valor do tipo double e tem métodos que
 * permitem comparar este valor com outros passados como argumentos de diversas 
 * formas, exemplificando o uso dos comparadores de Java.
 */
class Comparavel // declaração da classe
  {
 /**
  * Declaração dos campos da classe
  */
  private double valor; // o valor encapsulado, que será comparado com outros

 /**
  * O construtor para a classe Comparavel, que recebe um argumento do tipo double
  * para inicializar o único campo da classe.
  * @param v o valor a ser encapsulado
  */
  Comparavel(double v)
    {
    valor = v;
    } // fim do construtor com um argumento
  
 /**
  * O método toString possibilita a impressão de instâncias desta classe.
  * @return o valor encapsulado convertido para uma string
  */
  public String toString()
    {
    return ""+valor; // converte para string via concatenação
    } // fim do método toString
  
 /**
  * O método éIgualA retorna o valor booleano true se o valor encapsulado nesta classe
  * for igual ao passado como argumento.
  * @param v1 o valor a ser comparado para igualdade
  * @return true se os valores forem iguais, false se forem diferentes
  */
  public boolean éIgualA(double v1)
    {
    if (valor == v1) return true; // comparação de igualdade de valores
    else return false;
    } // fim do método éIgualA
  
 /**
  * O método éIgualA retorna o valor booleano true se o valor encapsulado nesta classe
  * for igual aos passados como argumento.
  * @param v1 um valor a ser comparado para igualdade
  * @param v2 outro valor a ser comparado para igualdade
  * @return true se os valores forem iguais, false se forem diferentes
  */
  public boolean éIgualA(double v1,double v2)
    {
    if ((valor == v1) && (valor == v2)) // ambos os valores são iguais ao encapsulado
      return true; 
    else return false;  
    } // fim do método éIgualA
  
 /**
  * O método éMaiorQue retorna o valor booleano true se o valor encapsulado nesta 
  * classe for maior que o passado como argumento.
  * @param v1 o valor a ser comparado 
  * @return true se o valor encapsulado for maior que o passado como argumento,
  *         false caso contrário
  */
  public boolean éMaiorQue(double v1)
    {
    if (valor > v1) return true; // o valor encapsulado é maior que o argumento
    else return false;
    } // fim do método éMaiorQue

 /**
  * O método éMaiorQue retorna o valor booleano true se o valor encapsulado nesta 
  * classe for maior que os passados como argumentos.
  * @param v1 um valor a ser comparado
  * @param v2 outro valor a ser comparado 
  * @return true se o valor encapsulado for maior que os passados como argumentos,
  *         false caso contrário
  */
  public boolean éMaiorQue(double v1,double v2)
    {
    if ((valor > v1) && (valor > v2)) // o valor encapsulado é maior que os argumentos
      return true;
    else return false;
    } // fim do método éMaiorQue

 /**
  * O método éMenorQue retorna o valor booleano true se o valor encapsulado nesta 
  * classe for menor que o passado como argumento.
  * @param v1 o valor a ser comparado 
  * @return true se o valor encapsulado for menor que o passado como argumento,
  *         false caso contrário
  */
  public boolean éMenorQue(double v1)
    {
    if (valor < v1) return true; // o valor encapsulado é menor que o argumento
    else return false;
    } // fim do método éMenorQue
  
 /**
  * O método éMenorQue retorna o valor booleano true se o valor encapsulado nesta 
  * classe for menor que os passados como argumentos.
  * @param v1 um valor a ser comparado 
  * @param v2 outro valor a ser comparado 
  * @return true se o valor encapsulado for menor que os passados como argumentos,
  *         false caso contrário
  */
  public boolean éMenorQue(double v1,double v2)
    {
    if ((valor < v1) && (valor < v2)) // o valor encapsulado é menor que os argumentos
      return true; 
    else return false;
    } // fim do método éMenorQue
  
  } // fim da classe Comparavel
