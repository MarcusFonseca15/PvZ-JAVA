package controlador;

import modelo.Planta;
import modelo.Campo;
import visual.PvZGame;
import visual.BarraSelect;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class MouseControlador extends MouseAdapter{
	//Click, Carrying
	
	private PvZGame jogoPanel;
	private BarraSelect barraSelect;
	private int carrying = -1;

	private Campo campo;

	
	public MouseControlador(Campo campo, PvZGame jogoPanel){
		this.campo = campo;
		this.jogoPanel = jogoPanel;
	}

	public void selecionarPlanta(int tipo) {
		carrying = tipo;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (carrying != -1) {
			//PLANTAR NA GRAMA
			if (campo.isGrama (e.getX(), e.getY())){
				campo.plantar(carrying, e.getX(), e.getY());
				carrying = -1; //Depois deseleciona
				selecionarPlanta(-1);
				barraSelect.slotPlanta = null;
				barraSelect.plantaSelectTipo = -1;
			} else {
				carrying = -1; //clicou fora, deseleciona
			}
		}

	}


	public void setJogoPanel(PvZGame jogoPanel) {
		this.jogoPanel = jogoPanel;
	}
}
