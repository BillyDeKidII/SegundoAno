/** 
 * A classe EventoAcademico representa um evento acadêmico, como um congresso ou
 * encontro, que se realiza em determinado período entre datas, local, e com um certo
 * número de participantes.
 */
class EventoAcademico // declaração da classe 
  {
 /**
  * Declaração dos campos da classe
  */
  private String nomeDoEvento,localDoEvento;
  private Data inícioDoEvento,fimDoEvento;
  private int númeroDeParticipantes;
     
 /**
  * O construtor para a classe EventoAcademico, que recebe argumentos para 
  * inicializar os campos da classe.
  * @param i o início do evento
  * @param f o início do evento
  * @param n o nome do evento
  * @param l o local do evento
  * @param num o número de participantes do evento
  */
  EventoAcademico(String n,String l,Data i,Data f,int num)
    {
    nomeDoEvento = n;  localDoEvento = l;
    // É necessário inicializar as instâncias internas da classe Data, e não somente
    // igualá-las aos valores passados, caso contrário elas simplesmente serão outras 
    // referências para instâncias da classe Data na classe que chamou o construtor.
    inícioDoEvento = new Data(); 
    inícioDoEvento.inicializaData(i.retornaDia(),i.retornaMês(),i.retornaAno());
    fimDoEvento = new Data(); 
    fimDoEvento.inicializaData(f.retornaDia(),f.retornaMês(),f.retornaAno());
    númeroDeParticipantes =  num;
    } // fim do construtor

  /**
   * O método toString não recebe argumentos, e retorna uma string contendo os valores 
   * dos campos da classe formatados.
   * @return uma string com os valores dos campos formatados como um relatório simples
   */
  public String toString()
    {
    String relatório = ""; // no início do método a string é vazia
    relatório = relatório + "Evento: "+nomeDoEvento+"\n";
    relatório = relatório + "Local:  "+localDoEvento+"\n";
    relatório = relatório + "De:     "+inícioDoEvento.retornaDia()+"/"+
                                       inícioDoEvento.retornaMês()+"/"+
                                       inícioDoEvento.retornaAno()+" a "+
                                       fimDoEvento.retornaDia()+"/"+
                                       fimDoEvento.retornaMês()+"/"+
                                       fimDoEvento.retornaAno()+"\n";
    relatório = relatório + "Participantes: "+númeroDeParticipantes+"\n";
    return relatório;
    } // fim do método toString

  } // fim da classe EventoAcademico 
