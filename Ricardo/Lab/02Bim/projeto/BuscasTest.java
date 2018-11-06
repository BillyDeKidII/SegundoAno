

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

/**
 * The test class BuscasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BuscasTest
{
    static final int[] arrUnitario = { 0 };
    static final int[] arrDuploOrdenado = { 0,1 };
    static final int[] arrDuploReverso = { 1,0 };
    static final int[] arrOrdenado = { 0,1,2,3,4,5,6,7,8,9 };
    static final int[] arrDesordenado = { 8,3,0,3,1,7,8,5,4,9,3,7 };
    
    @Test
    public void testBuscaArrUnitarioChaveExistente() {
        Optional<Integer> talvezInt = Buscas.busca(arrUnitario, 0);
        assertEquals(0, (int) talvezInt.get());
    }
    
    @Test
    public void testBuscaArrDuploOrdenadoChaveExistente() {
        assertEquals(1, (int) Buscas.busca(arrDuploOrdenado, 1).get());
    }
    
    @Test
    public void testBuscaArrDuploReversoChaveExistente() {
        assertEquals(0, (int) Buscas.busca(arrDuploReverso, 1).get());
    }
    
    @Test
    public void testBuscaArrDesordenadoChaveExistente() {
        assertEquals(7, (int) Buscas.busca(arrDesordenado, 5).get());
    }
    
    @Test
    public void testBuscaArrOrdenadoChaveExistente() {
        assertEquals(7, (int) Buscas.busca(arrOrdenado, 7).get());
    }
    
    @Test
    public void testBuscaArrOrdenadoChaveInexistente() {
        Optional<Integer> talvezInt = Buscas.busca(arrOrdenado, 10);
        //assertEquals(Optional.empty(), talvezInt);
        assertFalse(talvezInt.isPresent());
    }
}
