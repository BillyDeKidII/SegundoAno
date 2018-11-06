/**
 * Autor: Ricardo I. A. e Silva (ricardoinacio@me.com)
 * Data: 23/10/2015
 * Descrição: Editor de grafos para disciplina de laboratório de programação II
 * Licença: Este código fonte é livre e segue a licença BSD, disponivel em 
 *          http://pt.wikipedia.org/wiki/Licen%C3%A7a_BSD
 *          De maneira geral, voce é livre pra fazer o que quiser, mas deve 
 *          gentilmente dar os créditos aos autores originais.
 */

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;
import java.util.*;

import Grafos.*;

class DesenhistaGrafo extends JPanel
{       
    public DesenhistaGrafo() {
        setBorder(BorderFactory.createLoweredBevelBorder());
        setBackground(Color.WHITE);
        
        MouseDesenhista mouse = new MouseDesenhista();
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
    }
    
    public void setGrafo(Grafo<VAtribs, Integer> grafo) {
        this.grafo = grafo;
    }
    
    public void setModoEdicao(ModoEdicao novoModo) {
        this.modoEdt = novoModo;
    }

    public void adicionarVertice(Point posicao) {
        VAtribs novo = new VAtribs(posicao, "V" + (grafo.vertices().size() + 1));
        grafo.inserirVertice(novo);
        this.repaint();
    }
    
    public void moverVertice(Point posicao) {
        Point vPos = this.vertSobMouse.getAtributos().getPosicao();
        vPos.move(posicao.x, posicao.y);
    }
    
    /**
     * Método responsável por desenhar o arranjo, além de outros elementos gráficos secundários e
     * auxiliares. É aqui que os alunos deverão trabalhar. Porém devem evitar de fazerem um código
     * demasiadamente grande, devem separar em métodos auxiliares (subrotinas) sempre que possível.
     * 
     * @param g Pincel do desenhista.
     * @see java.awt.Graphics, java.swing.Graphics2D
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Dimension dim = getSize();
        StringBuilder txtDim = new StringBuilder("Dimensões da tela: ");
        txtDim.append(dim.width).append(" X ").append(dim.height); 
        g2d.drawString(txtDim.toString(), COMP_MARGEM_TXT, ALT_LINHA_TXT);  

        // Desenhar o grafo aqui
        for (Vertice<VAtribs> v : grafo.vertices()) {
            VAtribs av = v.getAtributos();
            Point pos = av.getPosicao();
            
            Stroke pontaPadrao = g2d.getStroke();
            g2d.setStroke(VERT_PERIMETRO);
            g2d.drawOval(pos.x-VERT_RAIO, pos.y-VERT_RAIO, VERT_DIAMETRO, VERT_DIAMETRO);
            if (v == vertSobMouse) {
                g2d.setColor(Color.YELLOW);
            }
            g2d.fillOval(pos.x-VERT_RAIO, pos.y-VERT_RAIO, VERT_DIAMETRO, VERT_DIAMETRO);
            g2d.setColor(Color.BLACK);
            g2d.setStroke(pontaPadrao);
            
            g2d.drawString(av.getNome(), pos.x, pos.y + VERT_DIAMETRO + ALT_LINHA_TXT);
        }
    }
    
    
    private Vertice<VAtribs> sobreVertice(Point objPos) {
        for (Vertice<VAtribs> v : grafo.vertices()) {
            Point vPos = v.getAtributos().getPosicao();
            if (vPos.distance(objPos) <= VERT_DIAMETRO) {
                return v;
            }
        }
        
        return null;
    }

    
    /**
     * Campos privados
     */
    private static final Integer COMP_MARGEM_TXT = 10;
    private static final Integer ALT_LINHA_TXT = 15;
    private static final Integer VERT_DIAMETRO = 12;
    private static final Integer VERT_RAIO = VERT_DIAMETRO / 2;
    private static final BasicStroke VERT_PERIMETRO = new BasicStroke(3);

    private Grafo<VAtribs, Integer> grafo = null;
    private ModoEdicao modoEdt = ModoEdicao.NENHUM;
    private Vertice<VAtribs> vertSobMouse;
    private Aresta<Integer> arestaSobMouse;
    
    public enum ModoEdicao {
        NENHUM, ADICIONAR_VERTICE, MOVER_VERTICE, MOVENDO_VERTICE, LIGAR_VERTICES, LIGANDO_VERTICES
    }
    
    private class MouseDesenhista extends MouseInputAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                switch (modoEdt) {
                    case ADICIONAR_VERTICE:
                        adicionarVertice(e.getPoint());
                }
            }
        }
        
        @Override
        public void mouseMoved(MouseEvent e) {
            Point mousePos = e.getPoint();
            Vertice<VAtribs> novoSob = sobreVertice(mousePos);
            if (vertSobMouse != novoSob) {
                vertSobMouse = novoSob;
                DesenhistaGrafo.this.repaint();
            }
        }
        
        @Override
        public void mousePressed(MouseEvent e) {
            
        }
        
        @Override
        public void mouseDragged(MouseEvent e) {
            switch (modoEdt) {
                case MOVENDO_VERTICE:
                    
            }
        }
    }
}