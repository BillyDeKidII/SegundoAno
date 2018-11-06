
/**
 * Write a description of class Ordenacoes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ordenacoes
{
    /**
     * Ordena crescentemente o arranjo pelo algoritmo da bolha,
     * in-place
     * @param arr arranjo de inteiros a ser ordenado 
     */
    public static void bubblesort(int [] arr)
    {
     boolean houveTroca;
     do
     {
      houveTroca = false;
      for(int i = 1; i < arr.length; i++)
      {
        if(arr[i-1] > arr[i])
        {
         trocar(arr, i-1, i);
         houveTroca = true;
        }
      }
     }while(houveTroca);
    }
    
    /**
     * Ordena crescentemente o arranjo pelo algoritmo da seleção,
     * in-place
     * @param arr arranjo de inteiros a ser ordenado 
     */
    public static void selectionsort(int [] arr)
    {
      for(int i=0; i < arr.length -1; i++)
      {
       int indiceMenor = i;
       for(int j = i+1; j < arr.length; j++)
       {
        if(arr[indiceMenor] < arr[j])
        {
           indiceMenor = j; 
        }
       }
       trocar(arr, i, indiceMenor);
      }
    }
    
    /**
     * Ordena crescentemente o arranjo pelo algoritmo da inserção
     * in-place
     * @param arr arranjo de inteiros a ser ordenado 
     */
    public static void insertionshort(int [] arr)
    {
      // Comprar cada carta
      for(int i = 1; i < arr.length; i++)
      {
       //Compra carta
       int seguro = arr[i];
       //Deslocar cartas para a direita, para abrir o espaço 
       //correto da carta comprada.
       int j = i-1;
       while(j >= 0 && seguro < arr[j])
       {
         arr[j+1] = arr[j];
         j--;
       }
       
       //Colocar a carta no lugar 
       arr[j] = seguro;
      }
    }
    
     private static void trocar (int[] arr, int i, int j)
    {
      int seguro = arr[i];
      arr[i] = arr[j];
      arr[j] = seguro;
    }
}