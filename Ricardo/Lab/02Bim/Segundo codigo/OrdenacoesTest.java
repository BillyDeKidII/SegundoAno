import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrdenacoesTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrdenacoesTest
{
    final int[] arr1 = { 1 };
    final int[] arr2 = { 1, 2 };
    final int[] arr3 = { 2, 1 }, 
        arr3_correto = { 1, 2 };
    final int[] arr4 = { 2, 1, 3 }, 
        arr4_correto = { 1, 2, 3 };
    final int[] arr5 = { 1, 2, 3 };
    final int[] arr6 = { 1, 2, 1, 2, 1, 2, 1 }, 
        arr6_correto = { 1, 1, 1, 1, 2, 2, 2 };
    final int[] arr7 = { 1, -2, 3, 7, 4, 6, 8 }, 
        arr7_correto = { -2, 1, 3, 4, 6, 7 ,8 };
    
    public void testarBolhaUmElemento() {
        int[] copia = copiarArranjo(arr1);
        Ordenacoes.bubblesort(copia);
        assertArrayEquals(arr1,copia);
    }
    
    public void testarBolhaDoisElementosPreordenados() {
        int[] copia = copiarArranjo(arr1);
    }
    
    public void testarBolhaDoisElementos() {
        int[] copia = copiarArranjo(arr1);
    }
    
    public void testarBolhaTresElementos() {
        int[] copia = copiarArranjo(arr1);
    }
    
    public void testarBolhaVariosElementosRepetidos() {
        int[] copia = copiarArranjo(arr1);
    }
    
    public void testarBolhaVariosElementosComNegativos() {
        int[] copia = copiarArranjo(arr1);
    }
    
    public static int[] copiarArranjo(int[] orig) {
        int[] copia = new int[orig.length];
        for (int i = 0; i < copia.length; i++) {
            copia[i] = orig[i];
        }
        return copia;
    }
}
