import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ArvoreTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ArvoreTest{
    @Test
    public void testarInsercao(){
        Node n1 = new Node(1);        
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        
        Arvore arvore = new Arvore();
        arvore.inserir(n1);
        arvore.inserir(n2);
        arvore.inserir(n3);
        arvore.inserir(n4);
        
        arvore.imprimirArvore();
    }
}
