package cursoJavaBasicoLoiane.aula20.labs;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		char[][] jogoDaVelha = new char[3][3];
		
		System.out.println("Jogador 1 = X");
		System.out.println("Jogador 2 = O");
		
		boolean ganhou = false;
		int jogada = 1;
		char sinal;
		int linha = 0, coluna = 0;
		
		while (!ganhou) {
			
			if (jogada % 2 == 1) { 		//jogador 1
				System.out.println("Vez do jogador 1. Escolha linha e coluna (1-3)");
				sinal = 'X';
			}else { 					//jogador 2
				System.out.println("Vez do jogador 2. Escolha linha e coluna (1-3)");
				sinal = 'O';
			}
			
			//VALIDA O INPUT DA LINHA
			boolean linhaValida = false;
			while(!linhaValida) {
				System.out.println("Entre com a linha (1, 2, 3)");
				linha = scan.nextInt();
				if (linha >=1 && linha <= 3) {
					linhaValida = true;
				}else {
					System.out.println("Entrada inválida, tente novamente");
				}
			}
			
			//VALIDA O INPUT DA COLUNA
			boolean colunaValida = false;
			while (!colunaValida) {
				System.out.println("Entre com a coluna (1, 2, 3)");
				coluna = scan.nextInt();
				if (coluna >=1 && coluna <= 3) {
					colunaValida = true;
				}else {
					System.out.println("Entrada inválida, tente novamente");
				}
			}
			
			linha--;
			coluna--;
			if (jogoDaVelha[linha][coluna] == 'X' || jogoDaVelha[linha][coluna] == 'O') {
				System.out.println("Posição já usada, tente novamente");
			}else {
				jogoDaVelha[linha][coluna] = sinal;
				jogada++;
			}
			
			//IMPRIME O TABULEIRO
			for (int i = 0; i < jogoDaVelha.length; i++) {
				for(int j = 0; j < jogoDaVelha[i].length; j++) {
					System.out.print(jogoDaVelha[i][j] + " | ");
				}
				System.out.println();
			}
			
			//VERIFICA SE TEM GANHADOR
			if(	(jogoDaVelha[0][0] == 'X' && jogoDaVelha[0][1] == 'X' && jogoDaVelha[0][2] == 'X') || //LINHA 1
				(jogoDaVelha[1][0] == 'X' && jogoDaVelha[1][1] == 'X' && jogoDaVelha[1][2] == 'X') || //LINHA 2
				(jogoDaVelha[2][0] == 'X' && jogoDaVelha[2][1] == 'X' && jogoDaVelha[2][2] == 'X') || //LINHA 3
				(jogoDaVelha[0][0] == 'X' && jogoDaVelha[1][0] == 'X' && jogoDaVelha[2][0] == 'X') || //COLUNA 1
				(jogoDaVelha[0][1] == 'X' && jogoDaVelha[1][1] == 'X' && jogoDaVelha[2][1] == 'X') || //COLUNA 2
				(jogoDaVelha[0][2] == 'X' && jogoDaVelha[1][2] == 'X' && jogoDaVelha[2][2] == 'X') || //COLUNA 3
				(jogoDaVelha[0][0] == 'X' && jogoDaVelha[1][1] == 'X' && jogoDaVelha[2][2] == 'X') ){  //DIAGONAL
			 
				ganhou = true;
				System.out.println("Parabéns, jogador 1 ganhou");
			}else if((jogoDaVelha[0][0] == 'O' && jogoDaVelha[0][1] == 'O' && jogoDaVelha[0][2] == 'O') || //LINHA 1
					(jogoDaVelha[1][0] == 'O' && jogoDaVelha[1][1] == 'O' && jogoDaVelha[1][2] == 'O') || //LINHA 2
					(jogoDaVelha[2][0] == 'O' && jogoDaVelha[2][1] == 'O' && jogoDaVelha[2][2] == 'O') || //LINHA 3
					(jogoDaVelha[0][0] == 'O' && jogoDaVelha[1][0] == 'O' && jogoDaVelha[2][0] == 'O') || //COLUNA 1
					(jogoDaVelha[0][1] == 'O' && jogoDaVelha[1][1] == 'O' && jogoDaVelha[2][1] == 'O') || //COLUNA 2
					(jogoDaVelha[0][2] == 'O' && jogoDaVelha[1][2] == 'O' && jogoDaVelha[2][2] == 'O') || //COLUNA 3
					(jogoDaVelha[0][0] == 'O' && jogoDaVelha[1][1] == 'O' && jogoDaVelha[2][2] == 'O') ){  //DIAGONAL
				 
					ganhou = true;
					System.out.println("Parabéns, jogador 2 ganhou");
			}else if (jogada > 9) {
				ganhou = true;
				System.out.println("Ninguém ganhou essa partida");
			}
		}
		
	}

}
