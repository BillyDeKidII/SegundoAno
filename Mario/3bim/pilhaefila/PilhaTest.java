

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PilhaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PilhaTest{
    Pilha pilha;
    /**
     * Default constructor for test class PilhaTest
     */
    public PilhaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        pilha = new Pilha();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testarEmpilhar(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        
        System.out.println(pilha);
        pilha.empilhar(n1);
        System.out.println(pilha);
        assertEquals(1, pilha.getTopo().getX());
        
        pilha.empilhar(n2);
        System.out.println(pilha);
        assertEquals(2, pilha.getTopo().getX());
        
        pilha.empilhar(n3);
        System.out.println(pilha);
        assertEquals(3, pilha.getTopo().getX());
        
        pilha.empilhar(n4);
        System.out.println(pilha);
        assertEquals(4, pilha.getTopo().getX());
    }
    
    @Test
    public void testarDesempilhar(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        
        System.out.println(pilha);
        pilha.empilhar(n1);
        pilha.empilhar(n2);
        pilha.empilhar(n3);
        pilha.empilhar(n4);
        System.out.println(pilha);
        
        pilha.desempilhar();
        System.out.println(pilha);
        assertEquals(3, pilha.getTopo().getX());
        
        pilha.desempilhar();
        System.out.println(pilha);
        assertEquals(2, pilha.getTopo().getX());
        
        pilha.desempilhar();
        System.out.println(pilha);
        assertEquals(1, pilha.getTopo().getX());        
    }
}
