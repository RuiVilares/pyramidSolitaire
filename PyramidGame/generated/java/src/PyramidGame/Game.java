package PyramidGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.overture.codegen.runtime.Utils;
import org.overture.codegen.runtime.VDMSeq;

public class Game {

	public static boolean validOption = false;
	public static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		startMenu();
	 }
	
	public static void startMenu() throws IOException {
		System.out.println("\n               ##");
		System.out.println("             ######");
		System.out.println("           ##########");
		System.out.println("         ##############");
		System.out.println("       ##################");
		System.out.println("     ######################");
		System.out.println("   ##########################");
		System.out.println("        Pyramid Solitaire\n");

		System.out.println(" - Menu");
		System.out.println(" 1. Jogar");
		System.out.println(" 2. Instru��es");
		System.out.println(" 3. Sair");

		int option = insertOption();
		switch (option) {
		case 1:
			play();
			break;
		
		case 2:
			instructions();
			break;

		case 3:
			return;

		default:
			System.err.println(" - Op��o inv�lida! Saindo...");
			break;
		}
	}
	
	@SuppressWarnings("resource")
	private static void play() throws IOException {
		
		Pyramid pyramid = new Pyramid();

		runGame(pyramid);
		System.out.println("- - - - - - - - - - - - - - - - - - - - -\n");
		System.out.println(" - Primir Enter para retornar ao Menu...");
		new Scanner(System.in).nextLine();

		startMenu();
	}
	
	@SuppressWarnings("resource")
	private static void instructions() throws IOException {
		
		System.out.println("\n - - - - - - - - Instru��es - - - - - - - -");
		System.out.println(" - Objetivo: Retirar todas as cartas da pir�mide fazendo combina��es de cartas que tenham um valor combinado de 13 pontos.");
		System.out.println(" - Como Jogar: Selecionar, em primeiro lugar, a coordenada X (eixo horizontal) e, seguidamente, a coordenada Y (eixo vertical).");
		System.out.println(" -             � ainda poss�vel sair do jogo primindo 9 e pedir carta auxiliar primindo 0, quando s�o facultadas estas op��es.");
		System.out.println(" -             As cartas v�lidas para serem selecionadas s�o as 2 primeiras do baralho auxiliar, se existirem, e toda a carta da piramide (x,y) em que as cartas (x,y+1) e (x+1, y+1) j� tenham sido removidas.");
		System.out.println(" -             O jogo termina se n�o existirem jogadas possiv�is.");
		System.out.println(" - Regras: Cada jogada corresponde � sele��o de uma carta ou ao pedido de carta auxiliar.");
		System.out.println(" -         A cada sele��o de uma carta ser�o somados os pontos correspondentes �s figuras de cada carta.");
		System.out.println(" -         Atingindo os 13 pontos, as cartas selecionadas s�o removidas e o jogo continua.");
		System.out.println(" -         Caso o valor de 13 pontos seja excedido, as cartas s�o desselecionadas e o jogo mant�m-se igual.");
		System.out.println(" -         Podem ser pedidas cartas auxiliares at� se esgotar o baralho inicial.");
		System.out.println(" - Score: Cada carta removida incrementa em 10 pontos."); 
		System.out.println(" -        Remover todas as cartas do baralho traduz um bonus de 30 pontos e remover todas as cartas da piramide traduz 50 pontos."); 
		System.out.println(" -        Bonus de combina��es de 3 cartas = 10 pontos, e a cada carta a somar �s 3 acresce 10 pontos."); 
		System.out.println("- - - - - - - - - - - - - - - - - - - - -\n");
		System.out.println(" - Primir Enter para retornar ao Menu...");
		new Scanner(System.in).nextLine();

		startMenu();
	}
	
	private static void runGame(Pyramid pyramid) throws IOException {

		while (!pyramid.isFinished()) {
			try
			 {
				System.out.println(" - Jogada:");
				System.out.print("Primir '9' para desistir || '0' para pedir carta auxiliar || selecionar coord <X>: ");
				int x = Integer.parseInt(buffer.readLine());
				if (x == 9) {
					System.out.println(" - Perdeste! Fim do jogo.");
					return;
				}
				else if (x == 0) {
					if(pyramid.getAuxCard() == 0)
						return;
				}
				else {
					System.out.print("Selecionar coord <Y>: ");
					int y = Integer.parseInt(buffer.readLine());
					if(checkValues(x,y)) {
						if(pyramid.selectCard(x, y) == 0)
							return;
					} else
						System.out.println("\n - Valores incorretos. Tente novamente.");
				}	
			 }
			catch (NumberFormatException ex) {
		       System.out.println("\n - Entrada incorreta. Tente novamente.");
			}
		}
	}

	
	public static int insertOption() throws IOException {
		int option = 0;
		System.out.print("Inserir n�mero: ");

		try {
			option = Integer.parseInt(buffer.readLine());
		} catch (NumberFormatException ex) {
		}
		return option;
	}
	
	public static boolean checkValues(int xCoord, int yCoord) {

	    if (Utils.equals(yCoord, 0L) && cg_Utils.min(Pyramid.auxDeck.size(), 2L).longValue() >= xCoord) {
	        return true;
	    }
	    else if (!(Utils.equals(yCoord, 0L)) && ((VDMSeq) Utils.get(Pyramid.pyramidDeck, yCoord)).size() >= xCoord) {
	          return true;
	     }
	    else
	    	return false;
	}	
}
