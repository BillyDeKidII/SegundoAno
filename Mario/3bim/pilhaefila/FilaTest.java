

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FilaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FilaTest{
    Fila fila;
    /**
     * Default constructor for test class FilaTest
     */
    public FilaTest(){
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        fila = new Fila();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
    }
    
    @Test
    public void testarEnfileirar(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        System.out.println(fila);
        
        fila.enfileirar(n1);       
        System.out.println(fila);
        assertEquals(1, fila.getPrimeiro().getX());
        
        fila.enfileirar(n2);        
        System.out.println(fila);
        assertEquals(1, fila.getPrimeiro().getX());
        
        fila.enfileirar(n3);
        System.out.println(fila);
        assertEquals(1, fila.getPrimeiro().getX());
        
        fila.enfileirar(n4);
        System.out.println(fila);
        assertEquals(1, fila.getPrimeiro().getX());
    }
    
    @Test
    public void testarDesenfileirar(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        System.out.println(fila);        
        fila.enfileirar(n1);               
        fila.enfileirar(n2);                
        fila.enfileirar(n3);
        fila.enfileirar(n4);
        System.out.println(fila);

        assertEquals(1, fila.getPrimeiro().getX());
        fila.desenfileirar();
        System.out.println(fila);
        assertEquals(2, fila.getPrimeiro().getX());
        fila.desenfileirar();
        System.out.println(fila);
        assertEquals(3, fila.getPrimeiro().getX());
        fila.desenfileirar();
        System.out.println(fila);
        assertEquals(4, fila.getPrimeiro().getX());        
    }

}
