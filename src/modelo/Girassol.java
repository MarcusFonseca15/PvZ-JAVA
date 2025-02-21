package modelo;

import modelo.Planta;

public class Girassol extends Planta {
	public Girassol() {
		super(50, 2); //durabil e tipo
	}
	
	public void fazerAcao() {
		//thread + random entre 5 e 15 segs pra gerar um sol na mesma
		//posição x e y do elemento
	}
}
