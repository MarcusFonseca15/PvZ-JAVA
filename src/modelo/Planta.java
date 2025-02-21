package modelo;

public abstract class Planta {
	int durabil;
	int tipo;
	
	public Planta(int durabil, int tipo) {
		this.durabil = durabil;
		this.tipo = tipo;
		
	}//do public Planta
	
	public abstract void fazerAcao();
	
	public int getDurabil() {return durabil;}
	
}
