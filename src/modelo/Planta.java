package modelo;

public abstract class Planta {
	private String nome;
    private int durabilidade;
    private int tipo;
    private int cooldown;
    private int range;
	
	public Planta(String nome, int durabilidade, int tipo, int cooldown, int range) {
        this.nome = nome;
        this.durabilidade = durabilidade;
        this.tipo = tipo;
        this.cooldown = cooldown;
        this.range = range;
    }//do public Planta
	
	public abstract void agir(); //metodo geral pra cada planta fazer o seu
}
