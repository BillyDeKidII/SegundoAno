/**
 * Autor: Ricardo I. A. e Silva (ricardoinacio@me.com)
 * Data: 23/10/2015
 * Descrição: Editor de grafos para disciplina de laboratório de programação II
 * Licença: Este código fonte é livre e segue a licença BSD, disponivel em 
 *          http://pt.wikipedia.org/wiki/Licen%C3%A7a_BSD
 *          De maneira geral, voce é livre pra fazer o que quiser, mas deve 
 *          gentilmente dar os créditos aos autores originais.
 */
import java.awt. * ;
import java.awt.event. * ;
import javax.swing. * ;

import Grafos. * ;

public class EditorGrafos extends JFrame
{
   /**
    * Ponto de início do programa. Informa que é um aplicativo gráfico e passa o controle
    * para o construtor do método. Utiliza uma segunda thread para isso.
    * 
    * @param args Argumentos recebidos da linha de comando.
    */
   public static void main(String[] args)
   {
      // Código que inicializa o aplicativo gráfico
      SwingUtilities.invokeLater(new Runnable()
      {@Override
         public void run()
         {
            new EditorGrafos();
         }
      });
   }

   /**
    * O construtor do aplicativo Desenhista. É aqui que todos os elementos da interface gráfica são
    * construídos, configurados e posicionados.
    * 
    * @see javax.swing.JFrame
    */
   public EditorGrafos()
   {
      // Carregando arquivos de recursos antes de mais nada
      iconNovoGrafo = new ImageIcon(getClass().getResource("imagens/document302.png"));
      iconCarregarGrafo = new ImageIcon(getClass().getResource("imagens/open131.png"));
      iconGravarGrafo = new ImageIcon(getClass().getResource("imagens/download174.png"));
      iconAdicionarVertice = new ImageIcon(getClass().getResource("imagens/plus79.png"));
      iconMoverVertice = new ImageIcon(getClass().getResource("imagens/pointer35.png"));
      iconNovaAresta = new ImageIcon(getClass().getResource("imagens/vector18.png"));
      iconRemoverVertice = new ImageIcon(getClass().getResource("imagens/delete96.png"));
      iconRenomearVertice = new ImageIcon(getClass().getResource("imagens/pencil41.png"));
      
      actNovoGrafo = new NovoGrafoAction(iconNovoGrafo);
      actCarregarGrafo = new CarregarGrafoAction(iconCarregarGrafo);
      actGravarGrafo = new GuardarGrafoAction(iconGravarGrafo);
      actAdicionarVertice = new AdicionarVerticeAction(iconAdicionarVertice);
      actMoverVertice = new MoverVerticeAction(iconMoverVertice);
      actNovaAresta = new LigarVerticesAction(iconNovaAresta);
      actRemoverVertice = new RemoverVerticeAction(iconRemoverVertice);
      actRenomearVertice = new RenomearVerticeAction(iconRenomearVertice);


      ButtonGroup bgEdicao = new ButtonGroup();
      bgEdicao.add(new JToggleButton(actAdicionarVertice));
      bgEdicao.add(new JToggleButton(actMoverVertice));
      bgEdicao.add(new JToggleButton(actNovaAresta));
      bgEdicao.add(new JToggleButton(actRemoverVertice));
      bgEdicao.add(new JToggleButton(actRenomearVertice));

      // Campo para abrigar e organizar os botões e campos de entrada
      JToolBar tbBotoes = new JToolBar();
      tbBotoes.add(new JButton(actNovoGrafo));
      tbBotoes.add(new JButton(actCarregarGrafo));
      tbBotoes.add(new JButton(actGravarGrafo));

      tbBotoes.addSeparator();
      for (AbstractButton ab: java.util.Collections.list(bgEdicao.getElements()))
      {
         tbBotoes.add(ab);
      }

      // Cria e configura a tela do desenhista
      desenhista = new DesenhistaGrafo();
      desenhista.setPreferredSize(new Dimension(LARGURA, ALTURA));

      // Container que organiza o posicionamento dos botões e da tela
      Container organizacao = getContentPane();
      organizacao.setLayout(new BorderLayout());
      organizacao.add(desenhista, BorderLayout.CENTER);
      organizacao.add(tbBotoes, BorderLayout.PAGE_START);

      // Configurações de comportamento do aplicativo
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setTitle("Desenhista de Grafos - Lab. Comp. II");
      this.mudarModoUI(ModoUI.DESENHISTA_FECHADO);
      this.setVisible(true);
      this.requestFocus();
   }

   private void mudarModoUI(ModoUI novoModo)
   {
      switch (novoModo)
      {
      case DESENHISTA_FECHADO:
         desenhista.setVisible(false);
         actGravarGrafo.setEnabled(false);
         actAdicionarVertice.setEnabled(false);
         actMoverVertice.setEnabled(false);
         actNovaAresta.setEnabled(false);
         actRemoverVertice.setEnabled(false);
         actRenomearVertice.setEnabled(false);
         break;

      case DESENHISTA_ABERTO:
         desenhista.setVisible(true);
         actGravarGrafo.setEnabled(true);
         actAdicionarVertice.setEnabled(true);
         actMoverVertice.setEnabled(true);
         actNovaAresta.setEnabled(true);
         actRemoverVertice.setEnabled(true);
         actRenomearVertice.setEnabled(true);
         break;
      }
      this.pack();
   }

   /** Atributos privados da classe*/
   // Elementos (widgets) da nossa interface
   private DesenhistaGrafo desenhista;
   private ImageIcon iconNovoGrafo;
   private ImageIcon iconCarregarGrafo;
   private ImageIcon iconGravarGrafo;
   private ImageIcon iconAdicionarVertice;
   private ImageIcon iconMoverVertice;
   private ImageIcon iconNovaAresta;
   private ImageIcon iconRemoverVertice;
   private ImageIcon iconRenomearVertice;

   // Controllers do programa
   private Action actNovoGrafo, actCarregarGrafo, actGravarGrafo;
   private Action actAdicionarVertice, actMoverVertice, actNovaAresta, actRemoverVertice, actRenomearVertice;

   // Modelos
   private Grafo < VAtribs, Integer > grafo;

   // substituindo numeros magicos
   private static final int LARGURA = 800;
   private static final int ALTURA = 600;

   private enum ModoUI
   {
      DESENHISTA_FECHADO, DESENHISTA_ABERTO
   }

   private class NovoGrafoAction extends AbstractAction
   {
      public NovoGrafoAction(String nome, Icon icon)
      {
         super(nome, icon);
         putValue(SHORT_DESCRIPTION, "Inicia um novo grafo.");
         putValue(MNEMONIC_KEY, KeyEvent.VK_N);
      }
      public NovoGrafoAction(Icon icon)
      {
         this(null, icon);
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {
         String[] implementacoes = {
            "Lista de Adjacências", "Matriz de Adjacências"
         };
         Object opcao = JOptionPane.showInputDialog(EditorGrafos.this, "Escolha a implementação do novo grafo:", "Novo grafo", JOptionPane.PLAIN_MESSAGE, iconNovoGrafo, implementacoes, implementacoes[0]);
         if (opcao == null)
         {
            return;
         }

         if (opcao.equals(implementacoes[0]))
         {
            grafo = new GrafoAdjacencias < VAtribs, Integer > ();
         }
         else
         { // if (opcao.equals(implementacoes[1])) {
            grafo = new GrafoMatriz < VAtribs, Integer > ();
         }

         desenhista.setGrafo(grafo);
         EditorGrafos.this.mudarModoUI(ModoUI.DESENHISTA_ABERTO);
      }
   }

   private class RemoverVerticeAction extends AbstractAction
   {
      public RemoverVerticeAction(String nome, Icon icon)
      {
         super(nome, icon);
         putValue(SHORT_DESCRIPTION, "Remove Vertice.");
         putValue(MNEMONIC_KEY, KeyEvent.VK_N);
      }
      public RemoverVerticeAction(Icon icon)
      {
         this(null, icon);
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {
         desenhista.setModoEdicao(DesenhistaGrafo.ModoEdicao.REMOVER_VERTICES);
      }
   }


   private class CarregarGrafoAction extends AbstractAction
   {
      public CarregarGrafoAction(String nome, Icon icon)
      {
         super(nome, icon);
         putValue(SHORT_DESCRIPTION, "Carregar um grafo guardado em arquivo.");
         putValue(MNEMONIC_KEY, KeyEvent.VK_C);
      }
      public CarregarGrafoAction(Icon icon)
      {
         this(null, icon);
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {
         EditorGrafos.this.mudarModoUI(ModoUI.DESENHISTA_ABERTO);
      }
   }

   private class GuardarGrafoAction extends AbstractAction
   {
      public GuardarGrafoAction(String nome, Icon icon)
      {
         super(nome, icon);
         putValue(SHORT_DESCRIPTION, "Guardar o grafo atual em arquivo.");
         putValue(MNEMONIC_KEY, KeyEvent.VK_S);
      }
      public GuardarGrafoAction(Icon icon)
      {
         this(null, icon);
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {

         }
   }

   private class AdicionarVerticeAction extends AbstractAction
   {
      public AdicionarVerticeAction(String nome, Icon icon)
      {
         super(nome, icon);
         putValue(SHORT_DESCRIPTION, "Aciona modo de adição de vértices.");
         putValue(MNEMONIC_KEY, KeyEvent.VK_V);
      }
      public AdicionarVerticeAction(Icon icon)
      {
         this(null, icon);
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {
         desenhista.setModoEdicao(DesenhistaGrafo.ModoEdicao.ADICIONAR_VERTICE);
      }
   }

   private class MoverVerticeAction extends AbstractAction
   {
      public MoverVerticeAction(String nome, Icon icon)
      {
         super(nome, icon);
         putValue(SHORT_DESCRIPTION, "Aciona modo de movimentação de vértices.");
         putValue(MNEMONIC_KEY, KeyEvent.VK_M);
      }
      public MoverVerticeAction(Icon icon)
      {
         this(null, icon);
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {
         desenhista.setModoEdicao(DesenhistaGrafo.ModoEdicao.MOVER_VERTICE);
      }
   }

    private class RenomearVerticeAction extends AbstractAction
   {
      public RenomearVerticeAction(String nome, Icon icon)
      {
         super(nome, icon);
         putValue(SHORT_DESCRIPTION, "Aciona modo de movimentação de vértices.");
         putValue(MNEMONIC_KEY, KeyEvent.VK_M);
      }
      public RenomearVerticeAction(Icon icon)
      {
         this(null, icon);
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {
         desenhista.setModoEdicao(DesenhistaGrafo.ModoEdicao.RENOMEAR_VERTICES);
      }
   }
   
   private class LigarVerticesAction extends AbstractAction
   {
      public LigarVerticesAction(String nome, Icon icon)
      {
         super(nome, icon);
         putValue(SHORT_DESCRIPTION, "Aciona modo de ligação de vértices.");
         putValue(MNEMONIC_KEY, KeyEvent.VK_L);
      }
      public LigarVerticesAction(Icon icon)
      {
         this(null, icon);
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {
         desenhista.setModoEdicao(DesenhistaGrafo.ModoEdicao.LIGAR_VERTICES);
      }
   }
}