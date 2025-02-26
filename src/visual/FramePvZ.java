package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import modelo.Campo;
import visual.assets.grama.*;
import visual.PvZGame;
import visual.BarraSelect;
import controlador.MouseControlador;


public class FramePvZ extends JFrame{
	

	//GRAMA
    int[][] grama = new int[10][5];
    Image gramaNormal, gramaMouseOver;
    
    //TAMANHO DAS CÉLULAS
    int celulaSize = 120;
    int alturaSementeira = 30;
    int larguraArea = grama.length * celulaSize +15;//colunas 
    int alturaArea = grama[0].length * celulaSize + 35; //linhas
    
    private Campo campo;
    private JPanel gramaPanel;
    private PvZGame jogoPanel;
    private BarraSelect barraSelect;
    private MouseControlador mouseControlador;
    

    public FramePvZ(Campo campo) {
        setTitle("Plants vs Zombies");
        setSize(larguraArea, alturaArea);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        this.campo = campo;
        setLayout(new BorderLayout()); //dividir em norte e centro
        
        
        //IMAGENS
        gramaNormal = new ImageIcon("src/visual/assets/grama/grama1.png").getImage();
        gramaMouseOver = new ImageIcon("src/visual/assets/grama/gramaMouseOver.png").getImage();
        
        //BARRA DE SELEÇÃO
        //MouseControlador mouseControlador = new MouseControlador(jogoPanel); //porque o BarraSelect pede
        barraSelect = new BarraSelect(celulaSize /*, mouseControlador*/);
        add(barraSelect, BorderLayout.NORTH);
        
        
        //INICIALIZAR A MATRIZ DA GRAMA
        for (int i = 0; i < grama.length; i++) {
            for (int j = 0; j < grama[i].length; j++) {
                grama[i][j] = 0;
            }
        }
        
      //PAINEL DE GRAMA (CAMADA INFERIOR)
        gramaPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenhaMatriz(g);
            }
        };
        
        /*---TEXTURA GRAMA
         * Grama Normal = 0
         * Grama MouseOver = 1
         * */
        gramaPanel.setPreferredSize(new Dimension(grama[0].length * celulaSize, grama.length * celulaSize));
        gramaPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX() / celulaSize;
                int y = e.getY() / celulaSize;
                if (x >= 0 && x < grama.length && y >= 0 && y < grama[0].length) {
                    for (int i = 0; i < grama.length; i++) {
                        for (int j = 0; j < grama[i].length; j++) {
                            grama[i][j] = 0;
                        }
                    }
                    grama[x][y] = 1;
                    gramaPanel.repaint();
                }
            }
        });
        
        //PANEL DO JOGO (CAMADA SUPERIOR)
        jogoPanel = new PvZGame(campo, celulaSize);
        jogoPanel.setOpaque(false); //!IMPORTANTE! Camada fica visivel abaixo

        
        //JLayeredPane ORGANIZAR AS CAMADAS
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(
            grama.length * celulaSize,    //Largura
            grama[0].length * celulaSize  //Altura
        ));
        
        gramaPanel.setBounds(0, 0, grama.length * celulaSize, grama[0].length * celulaSize);
        jogoPanel.setBounds(0, 0, grama.length * celulaSize, grama[0].length * celulaSize);

        layeredPane.add(gramaPanel, Integer.valueOf(0));  //INFERIOR
        layeredPane.add(jogoPanel, Integer.valueOf(1));  //SUPERIOR

        add(layeredPane);
        pack();
    }
    
    //COLOCAR A TEXTURA DA GRAMA
    public void desenhaMatriz(Graphics g) {
        for (int i = 0; i < grama.length; i++) {
            for (int j = 0; j < grama[i].length; j++) {
                Image imagem = (grama[i][j] == 1) ? gramaMouseOver : gramaNormal;
                g.drawImage(imagem, i * celulaSize, j * celulaSize, celulaSize, celulaSize, null);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Campo campo = new Campo();
            new FramePvZ(campo).setVisible(true);
        });
    }
}