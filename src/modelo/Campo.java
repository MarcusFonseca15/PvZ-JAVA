package modelo;

import java.util.Random;

public class Campo {
	//ESTADO ATUAL DAS MATRIZES NO CAMPO (SEM A LOGICA) E O QUE ELAS CONTEM E SEUS DADOS
	//SOBREPOSIÇÃO ENTRE TODAS AS MATRIZES EM UM SÓ
	//VERIFICAR SE CÉLULA ESTÁ OCUPADA
	
	private int[][] grama = new int[5][10];
    private int[][] matPla = new int[5][10];  //Matriz de plantas
    private int[][] matZo = new int[5][10];   //Matriz de zumbis

    int celulaSize;
    
public Campo(int linhas, int colunas, int celulaSize) {
    this.matPla = new int[linhas][colunas];
    this.celulaSize = celulaSize;

        iniciarCortadores();
    }

private void iniciarCortadores() {
        for (int i = 0; i < 5; i++) {
            matPla[i][0] = 1;
        }
    }//fim initCortadores

    //Se canto clicado for grama vazia(0) retorna true, senao false
    public boolean isGrama(int linha, int coluna){
        return matPla[linha][coluna] == 0;
    }

    public void plantar(int tipo, int linha, int coluna) {
    
        if (isGrama(linha, coluna)) {
            matPla[linha][coluna] = tipo;
        } else {
            System.out.println("Não é possível plantar aqui [" + linha + ", " + coluna + "]");
        }
    }

// //ADIÇÃO E REMOÇÃO DE ELEMENTOS NA MATRIZ ?????? inspirar na logica do kill zumbi
// public void addPlanta(int linha, int coluna) {
//     matPla[linha][coluna] = 1;
// }

// public void removePlanta(int linha, int coluna) {
//     matPla[linha][coluna] = 0;
// }

// public void addZumbi(int linha, int coluna) {
//     matZo[linha][coluna] = 1;
// }

// public void killZumbi(int linha, int coluna) {
//     matZo[linha][coluna] = 0;
// }


//MÉTODOS VALIDAÇÕES DE ESTADO
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