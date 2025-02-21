package controlador;

import java.util.Random;

public class GameController {
//CONTROLAR O FLUXO DO JODO, TODA A LÓGICA DE MATRIZES E INTERAÇÕES
	
	private int[][] grama = new int[5][10];
    private int[][] matPla = new int[5][10];  //Matriz de plantas
    private int[][] matZo = new int[5][10];   //Matriz de zumbis
    private int[][] matProj = new int[5][10]; //Matriz de projéteis
    private int sol = 50;
    
	public GameController(){
		
		

	}
	
//SPAW ALEATORIO DE ZUMBIS
public void spawnZumbi() {
        Random random = new Random();
        int linha = random.nextInt(5);
        matZo[linha][9] = 1; //ultima coluna
    }

//MOVER ZUMBIS
public void moverZumbis() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (matZo[i][j] == 1) {
                    matZo[i][j] = 0;
                    matZo[i][j - 1] = 1;
                }
            }
        }
    } //fim moverZumbis


public int[][] getMatPla() {
	return matPla;
	}
public int[][] getMatZo() {
	return matZo;
	}
public int[][] getMatProj() {
	return matProj;
	}
public int getSol() { return sol; }
}
