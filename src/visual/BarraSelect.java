package visual;

import javax.swing.*;

import controlador.MouseControlador;
import modelo.Girassol;
import modelo.Planta;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class BarraSelect extends JPanel {
    private JPanel areaSol, areaPlantas, areaPa;
    private int alturaBarra = 85; //fixo
    private int celulaSize;

    private List<Integer> listaPlantas = new ArrayList<>(); //lista ordenada de plantas
    private JPanel slotPlanta = null;
    private int plantaSelectTipo = -1; 

    private MouseControlador mouseControlador;

    public BarraSelect(int celulaSize, MouseControlador controlador) {
        this.celulaSize = celulaSize;
        this.mouseControlador = controlador;

    	//AREA GERAL DA BARRA
        setPreferredSize(new Dimension(100, alturaBarra));
        setBackground(new Color(139, 69, 19));
        setLayout(new GridBagLayout());

        //INICIAR O GBC
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; //preenche vertc e horiznt
        gbc.gridy = 0; //linha q vai ser add
        gbc.weighty = 1.0; //ocupa max de epaço extra disponivel

        //AREA DO SOL (20%)
        areaSol = new JPanel();
        areaSol.setBackground(Color.YELLOW);
        gbc.gridx = 0; gbc.weightx = 0.2;
        add(areaSol, gbc);

        //AREA DAS PLANTAS (60%)
        areaPlantas = new JPanel(new GridLayout(1, 5, 2, 0)); //linha, coluna, Hgap, Vgap 
        areaPlantas.setOpaque(false);
        gbc.gridx = 1; gbc.weightx = 0.6;
        add(areaPlantas, gbc);

        addPlantaBarra(2);
        addPlantaBarra(3);
        addPlantaBarra(4);
        addPlantaBarra(5);
        addPlantaBarra(6);
        addPlantaBarra(7);
        
        /* PASSA ATUALIZAÇAO FUTURA PELA QNT SELECIONADA SER LIVRE
         (int i = 1; i < 5; i++) {
            JPanel slot = criarSlotPlanta(i + 1);
            areaPlantas.add(slot);
        }*/

        //AREA DA PÁ (20%)
        areaPa = new JPanel();
        areaPa.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 2; gbc.weightx = 0.2;
        add(areaPa, gbc);

    } //------------------------------FIM DO BARRA SELECT

    //ADD PLANTAS NA SEMENTEIRA (COM SEUS IDS)
    private void addPlantaBarra(int tipo) {
    	if (listaPlantas.contains(tipo)) return; //Evita repetição de mim mesmo rs
    	listaPlantas.add(tipo);
    	JPanel slot = criarSlotPlanta(tipo);
    	areaPlantas.add(slot);
    	revalidate();
    	repaint();
    }
    
    
    //CRIAR OS ESPAÇOS PRAS PLANTAS
    private JPanel criarSlotPlanta(int tipo) {
        JPanel slot = new JPanel();
        slot.setBackground(Color.GREEN);
        slot.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        slot.setLayout(new BorderLayout());
        
        //Iniciar Imagem e nome da planta pelo TIPO
        String nomePlanta = "";
        String pathImage = "";
        
        switch (tipo) {
        case 2: nomePlanta = "Girassol"; pathImage = "/visual/assets/Plantas/Girassol.png"; break;
        case 3: nomePlanta = "Ervilha"; pathImage = "/visual/assets/Plantas/Ervilha.png"; break;
        case 4: nomePlanta = "Carnívora"; pathImage = "/visual/assets/Plantas/Carnivora.png"; break;
        case 5: nomePlanta = "Noz"; pathImage = "/visual/assets/Plantas/Noz.png"; break;
        case 6: nomePlanta = "Gelo"; pathImage = "/visual/assets/Plantas/Gelo.png"; break;
        default: nomePlanta = "Desconhecida";
        }
        
        int tamPlanta = celulaSize/2; //de 120 para 60(sempre a metade)
        
        //ADD A IMAGEM DE CADA PLANTA
        ImageIcon imgPlantaOriginal = new ImageIcon(getClass().getResource(pathImage));
        Image imgPlantaSlot = imgPlantaOriginal.getImage().getScaledInstance(tamPlanta, tamPlanta, Image.SCALE_SMOOTH); 
        JLabel imgLabel = new JLabel(new ImageIcon(imgPlantaSlot));
        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        slot.add(imgLabel, BorderLayout.CENTER);
        
        //----------SELECIONAR PLANTA----------
        slot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selecionarPlanta(tipo, slot);
            }
        });
        
        return slot;
    }//FIM DO CRIAR SLOT PLANTA
    
    public void selecionarPlanta(int tipo, JPanel slot) {
        // CLICOU NA MESMA PLANTA = DESELECIONA
    	if (slotPlanta == slot) {
            slotPlanta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            slotPlanta = null;
            plantaSelectTipo = -1;
            mouseControlador.selecionarPlanta(-1); //deselecona
        } else {
            // CLICOU EM OUTRA PLANTA = SELECIONA NOVA
            if (slotPlanta != null)
                slotPlanta.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            slotPlanta = slot;
            plantaSelectTipo = tipo;
            mouseControlador.selecionarPlanta(tipo);
            slot.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        }
    }
    
}
