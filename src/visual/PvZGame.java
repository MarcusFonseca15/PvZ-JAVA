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
    private Image ervilhaImg; //3
    private Image batataImg;  //4
    private Image nozImg;     //5
    private Image carnivoraImg; //6
    private Image geloImg;      //7
    
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
        ervilhaImg = new ImageIcon("src/visual/assets/Plantas/Ervilha.png").getImage();
        batataImg = new ImageIcon("src/visual/assets/Plantas/batata.png").getImage();
        nozImg = new ImageIcon("src/visual/assets/Plantas/Noz.png").getImage();
        carnivoraImg = new ImageIcon("src/visual/assets/Plantas/Carnivora.png").getImage();
        geloImg = new ImageIcon("src/visual/assets/Plantas/Gelo.png").getImage();

        
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
                if (matPla[i][j] == 3) {
                	g.drawImage(ervilhaImg, j* celulaSize, i * celulaSize, celulaSize, celulaSize, null);
                }
                //BATATA
                if (matPla[i][j] == 4) {
                	g.drawImage(batataImg, j* celulaSize, i * celulaSize, celulaSize, celulaSize, null);
                }
                //NÓZ
                if (matPla[i][j] == 5) {
                	g.drawImage(nozImg, j* celulaSize, i * celulaSize, celulaSize, celulaSize, null);
                }
                //PLANTA CARNIVORA
                if (matPla[i][j] == 6) {
                	g.drawImage(carnivoraImg, j* celulaSize, i * celulaSize, celulaSize, celulaSize, null);
                }
                //GELO
                if (matPla[i][j] == 7) {
                	g.drawImage(geloImg, j* celulaSize, i * celulaSize, celulaSize, celulaSize, null);
                }
                
            }
        }
    }
    
}
