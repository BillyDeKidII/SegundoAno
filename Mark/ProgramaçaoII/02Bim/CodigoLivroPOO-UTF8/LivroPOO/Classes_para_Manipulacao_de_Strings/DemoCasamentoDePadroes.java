/**
 * A classe DemoCasamentoDePadroes mostra exemplos de uso da classe 
 * CasamentoDePadroes. 
 */
class DemoCasamentoDePadroes // declaraÃ§Ã£o da classe 
  {
 /**
  * O mÃ©todo main permite a execuÃ§Ã£o desta classe. Este mÃ©todo contÃ©m a declaraÃ§Ã£o
  * de duas instÃ¢ncias da classe CasamentoDePadroes, e as usa para verificar se 
  * algumas strings casam com aqueles padrÃµes.
  * @param argumentos os argumentos que podem ser passados para o mÃ©todo via linha
  *        de comando, mas que neste caso serÃ£o ignorados.
  */
  public static void main(String[] args)
    {
    CasamentoDePadroes datas = 
      new CasamentoDePadroes("1{1|2|3|4|5} de {janeiro|fevereiro|marÃ§o} de 200{1|2}");
    System.out.println(datas.casa("15 de fevereiro de 2001")); // true 
    System.out.println(datas.casa("11 de marÃ§o de 2002"));     // true
    System.out.println(datas.casa("31 de janeiro de 2003"));   // false
    CasamentoDePadroes horas = new CasamentoDePadroes("{00|04|08|12|16|20}:00:00");
    System.out.println(horas.casa("12:00:00"));         // true 
    System.out.println(horas.casa("12:00:01"));         // false
    System.out.println(horas.casa("12:00"));            // false
    System.out.println(horas.casa("12:00:00 de hoje")); // false
    System.out.println(horas.casa("Ã s 12:00:00"));      // false
    } // fim do mÃ©todo main

  } // fim da classe DemoCasamentoDePadroes
