/*package controlador;

import java.awt.event.MouseListener;

import modelo.Planta;
public class MouseControlador implements MouseListener{
	//Click, Carrying, Free
	
	private Planta plantaSelecionada = null;
	private boolean carrying = false;
	
	public void selecionarPlanta(Planta planta) {
		if (carrying && plantaSelecionada == planta) {
			//Clicou na mesma planta da BarraSelect -> Deseleciona
			plantaSelecionada = null;
			carrying = false;
		} else {
			plantaSelecionada = planta;
			carrying = true;
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		if (carrying) {
			//Clica na grama, planta ela e carrying false
			//Clica na planta selecionada de novo, deseleciona
		}
	}

}
*/