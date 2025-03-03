package modelo;

import modelo.Planta;

public class Girassol extends Planta {

	//Random 10-20seg para geral sol
	//Criar variavel random e passar pro parametro de cooldown

	public Girassol() {
		super("Girassol", 3, 2, 10, 1);
	}
	
	@Override
    public void agir() {
            //Random 10-20seg para geral sol
			//Como alterar esse random dentro do parametro de cooldown?
    }
}
