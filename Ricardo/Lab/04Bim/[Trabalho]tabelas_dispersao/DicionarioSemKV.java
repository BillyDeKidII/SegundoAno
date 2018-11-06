
/**
 * DicionarioSemKV.java
 * 
 * @author Jose Ricardo Guidetti Junior
 * @version 2015/09/26
 */
public class DicionarioSemKV
{
 public DicionarioSemKV()
 {
   aurelio = new Entrada[ALFABETO];
   inicializaListas();
 }

 final void inserir(String palavra, String descricao)
 {
     aurelio[hash(palavra)].inserir(palavra, descricao);
 }
 
 final void inicializaListas()
 {
  for(int i = 0; i < ALFABETO; i++)
  {
   aurelio[i] = new Entrada();
  }
 }
 
 final int hash(String palavra)
 {
  palavra = palavra.toLowerCase();
  int pos =  palavra.charAt(PRIMEIRA_LETRA);   
  return pos - CONVERSAO;
 }
 
 // variaveis privadas da classe Dicionario
  private final int CONVERSAO = 97; // letra 'a' no alfabeto da tab. ASCII
  private final int PRIMEIRA_LETRA = 0;
  private final int ALFABETO = 26;
  private Entrada<String, String> aurelio[];
}
