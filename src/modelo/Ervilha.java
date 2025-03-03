package modelo;
import modelo.Planta;
import modelo.Projetil;

public class Ervilha extends Planta{
    public Ervilha() {
        super("Ervilha", 5, 3, 2, 10);
    }

    @Override
    public void agir() {
            //Zumbi na mesma linha atira
    }

    //Importar o projetil e fazer suas instancias nele. NAO POSSUI NENHUM EFEITO ESPECIAL
}
