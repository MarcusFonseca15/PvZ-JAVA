package visual;

import modelo.Campo;
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


import visual.BarraSelect;

public class PvZGame extends JPanel {
	//DESENHAR AS MATRIZES DE PLANTAS, ZUMBIS, PROJETEIS
	
    private Campo campo;           //Referenciar o estado atual do jogo
    private int celulaSize;
    private BarraSelect barraSelect;
    
    //IMAGENS
    private Image cortadorImg; //1
    private Image girassolImg; //2
    
    /*
    0: Vazio;
    1: Cortador;
    2: Girassol;
    3: Atirador;
    4: Bomba-cereja;
    5: Barreira-Noz;
    6: Congelador;
    7: Planta Carnívora.
*/
    public PvZGame(Campo campo, int celulaSize, BarraSelect barraSelect) {
    	//RECEBER O VALOR (Construtor)
        this.campo = campo;
        this.celulaSize = celulaSize;
        this.barraSelect = barraSelect;

        //INICIALIZAR CAMPO
        setPreferredSize(new Dimension(
            campo.getMatPla()[0].length * celulaSize + 15,
            campo.getMatPla().length * celulaSize + 35
        ));

        //PATH DO CORTADOR
        cortadorImg = new ImageIcon("src/visual/assets/Cortador/Cortador.png").getImage();
        girassolImg = new ImageIcon("src/visual/assets/Plantas/Girassol.png").getImage();

        
        //ADICIONAR OUVINTE DE MOUSE
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if (barraSelect.getPlantaSelectTipo() != -1) {
                    int x = e.getX();
                    int y = e.getY();

                    int linha = y / celulaSize;
                    int coluna = x / celulaSize;
                    
                    if (linha >= 0 && linha < campo.getMatPla().length && //limites da matriz
                    coluna >= 0 && coluna < campo.getMatPla()[0].length) {

                    //plantar
                    campo.plantar(barraSelect.getPlantaSelectTipo(), linha, coluna);
                        repaint();
                    }
                
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharCampo(g);
    }


    private void desenharCampo(Graphics g) {
        int[][] matPla = campo.getMatPla();  //Atualizar

        double prop = 0.7; //proporção das plantas
        
        for (int i = 0; i < matPla.length; i++) {
            for (int j = 0; j < matPla[i].length; j++) {
            	//CORTADOR
                if (matPla[i][j] == 1) { 
                    g.drawImage(cortadorImg, j * celulaSize, i * celulaSize, celulaSize, celulaSize, null);
                }
                //GIRASSOL
                if (matPla[i][j] == 2) {
                	g.drawImage(girassolImg, j* celulaSize, i * celulaSize, celulaSize, celulaSize, null);
                }
                //ERVILHA

                //BATATA

                //NÓZ

                //PLANTA CARNIVORA

                //GELO
                
            }
        }
    }
    
}
