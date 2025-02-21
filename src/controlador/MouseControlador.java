package controlador;

import modelo.Planta;
import modelo.Campo;
import visual.PvZGame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseControlador extends MouseAdapter{
	//Click, Carrying
	
	private PvZGame jogoPanel;
	private int plantaSelecionada = -1;
	private boolean carrying = false;
	private Campo campo;

	
	public MouseControlador(Campo campo){
		this.campo = campo;
		this.jogoPanel = jogoPanel;
	}

	public void selecionarPlanta(int tipo) {
		if (carrying && plantaSelecionada == tipo) {
			//Clicou na mesma planta da BarraSelect -> Deseleciona
			plantaSelecionada = -1;
			carrying = false;
		} else {
			plantaSelecionada = tipo;
			carrying = true;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		/*if (carrying) {
			if (campo.isGrama (e.getX(), e.getY())){
				campo.plantar(plantaSelecionada, e.getX(), e.getY());
				plantaSelecionada = -1;
				carrying = false;
			} else {
				plantaSelecionada = -1;
				carrying = false;
			}
			//Clica na grama, planta ela e carrying false
			//Clicou em outra parte, deseleciona
		}*/
	}

	public int getPlantaSelecionada(){
		return plantaSelecionada;
	}

	public boolean isCarrying(){
		return carrying;
	}

}
