import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * The test class OrdenacoesTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrdenacoesTest
{
    final Integer[] arr1 = { 1 };
    final Integer[] arr2 = { 1, 2 };
    final Integer[] arr3 = { 2, 1 }, 
        arr3_correto = { 1, 2 };
    final Integer[] arr4 = { 2, 1, 3 }, 
        arr4_correto = { 1, 2, 3 };
    final Integer[] arr6 = { 1, 2, 1, 2, 1, 2, 1 }, 
        arr6_correto = { 1, 1, 1, 1, 2, 2, 2 };
    final Integer[] arr7 = { 1, -2, 3, 7, 4, 6, 8 }, 
        arr7_correto = { -2, 1, 3, 4, 6, 7 ,8 };
    
    public void testarBolhaUmElemento() {
        Integer[] copia = Arrays.copyOf(arr1, arr1.length);
        Ordenacoes.bubblesort(copia);
        assertArrayEquals(arr1,copia);
    }
    
    public void testarBolhaDoisElementosPreordenados() {
        Integer[] copia = Arrays.copyOf(arr2, arr2.length);
    }
    
    public void testarBolhaDoisElementos() {
        Integer[] copia = Arrays.copyOf(arr3, arr3.length);
    }
    
    public void testarBolhaTresElementos() {
        Integer[] copia = Arrays.copyOf(arr4, arr4.length);
    }
    
    public void testarBolhaVariosElementosRepetidos() {
        Integer[] copia = Arrays.copyOf(arr6, arr6.length);
    }
    
    public void testarBolhaVariosElementosComNegativos() {
        Integer[] copia = Arrays.copyOf(arr7, arr7.length);
    }
}
