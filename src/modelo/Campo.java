package modelo;

import java.util.Random;

public class Campo {
	//ESTADO ATUAL DAS MATRIZES NO CAMPO (SEM A LOGICA) E O QUE ELAS CONTEM E SEUS DADOS
	//SOBREPOSIÇÃO ENTRE TODAS AS MATRIZES EM UM SÓ
	//VERIFICAR SE CÉLULA ESTÁ OCUPADA
	
	private int[][] grama = new int[5][10];
    private int[][] matPla = new int[5][10];  //Matriz de plantas
    private int[][] matZo = new int[5][10];   //Matriz de zumbis
    private int[][] matProj = new int[5][10]; //Matriz de projéteis
    
public Campo() {
        iniciarCortadores();
    }

private void iniciarCortadores() {
        for (int i = 0; i < 5; i++) {
            matPla[i][0] = 1;
        }
    }//fim initCortadores

//ADIÇÃO E REMOÇÃO DE ELEMENTOS NA MATRIZ
public void addPlanta(int linha, int coluna) {
    matPla[linha][coluna] = 1;
}

public void removePlanta(int linha, int coluna) {
    matPla[linha][coluna] = 0;
}

public void addZumbi(int linha, int coluna) {
    matZo[linha][coluna] = 1;
}

public void killZumbi(int linha, int coluna) {
    matZo[linha][coluna] = 0;
}


//VALIDAÇÕES DE ESTADO
public boolean temPlanta(int linha, int coluna) {
    return matPla[linha][coluna] == 1;
}

public boolean temZumbi(int linha, int coluna) {
    return matZo[linha][coluna] == 1;
}


// MÉTODOS GETTERS

public int[][] getGrama() {
    return grama;
} 
public int[][] getMatPla() {
	return matPla;
	}
public int[][] getMatZo() {
	return matZo;
	}

}