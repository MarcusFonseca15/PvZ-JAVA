package modelo;
import modelo.Planta;

public class Card {
    private String nome;
    private int preco;
    private int rechargeTempo;
    private boolean disponivel;

    private Class<?extends Planta> tipoPlanta; //o tipo de planta associada ao card para PLANTAR

    public Card(String nome, int preco, int rechargeTempo, Class<?extends Planta> tipoPlanta){
        this.nome = nome;
        this.preco = preco;
        this.rechargeTempo = rechargeTempo;
        this.disponivel = true;
        this.tipoPlanta = tipoPlanta;
    }

    public void iniciarRecharge(){
        this.disponivel = false;
        //INICIAR TEMPORIZADOR PRA REATIVAR O CARD DEPOIS QUE FOI COMPRADO (Segundo o tipo de planta)
    }

    public boolean isDisponivel(){
        return this.disponivel;
    }

    public Planta criarPlanta(){
        try{
            return tipoPlanta.getDeclaredConstructor().newInstance();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }

}
