package modelo;

public class Projetil {
    private int dano;
    private String imagePath;

    public Projetil(int dano, String imagePath){
        this.dano = dano;
        this.imagePath = imagePath;
    }

    //public void efeitoEspecial(Zumbi zumbi);

    //SERÁ O OBJETO ESTÁTICO. O QUE IRÁ MOVE-LO SERÁ A CLASSE DE ANIMAÇÕES NO CONTROLADOR
    //Ela irá ter movimento vertical, horizontal, elipses, etc
}
