/** 
 * A classe ComparaSimples contém métodos estáticos para a comparação de dois
 * valores do tipo inteiro. Esta classe demonstra o uso do operador condicional ?.
 */
class ComparaSimples // declaração da classe
  {
 /**
  * O método qualÉMaior retorna o maior dos dois valores passados como argumentos.
  * @param p1 o primeiro dos dois valores
  * @param p2 o segundo dos dois valores
  * @return o maior dos dois valores passados como argumentos
  */
  public static int qualÉMaior(int p1,int p2)
    {
    int valor = (p1 > p2 ? p1 : p2); // se p1 > p2, valor recebe p1, senão recebe p2
    return valor;
    } // fim do método qualÉMaior

 /**
  * O método qualÉMenor retorna o menor dos dois valores passados como argumentos.
  * @param p1 o primeiro dos dois valores
  * @param p2 o segundo dos dois valores
  * @return o menor dos dois valores passados como argumentos
  */
  public static int qualÉMenor(int p1,int p2)
    {
    // Não é necessário declarar uma variável temporária
    return (p1 < p2 ? p1 : p2); // se p1 > p2, retorna p1, senão retorna p2
    } // fim do método qualÉMenor

  } // fim da classe ComparaSimples
