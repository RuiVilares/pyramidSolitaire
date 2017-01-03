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
		System.out.println(" 2. Sair");

		int option = insertOption();
		switch (option) {
		case 1:
			play();
			break;
			
		case 2:
			return;

		default:
			System.err.println("Invalid option! Exiting...");
			break;
		}
	}
	
	@SuppressWarnings("resource")
	private static void play() throws IOException {
		
		Pyramid pyramid = new Pyramid();

		runGame(pyramid);

		System.out.println("\n\n- Primir Enter para retornar ao Menu...");
		new Scanner(System.in).nextLine();

		startMenu();
	}
	
	private static void runGame(Pyramid pyramid) throws IOException {

		while (!pyramid.isFinished()) {
			try
			 {
				System.out.println("- Jogada");
				System.out.print("Primir '9' para desistir || '0' para pedir carta auxiliar || selecionar coord <X>: ");
				int x = Integer.parseInt(buffer.readLine());
				if (x == 9) {
					System.out.println("Perdeste! Fim do jogo.");
					return;
				}
				else if (x == 0)
					pyramid.getAuxCard();
				else {
					System.out.print("Selecionar coord <Y>: ");
					int y = Integer.parseInt(buffer.readLine());
					if(checkValues(x,y))
						pyramid.selectCard(x, y);
					else
						System.out.println("\n- Valores incorretos. Tente novamente.");
				}	
			 }
			catch (NumberFormatException ex) {
		       System.out.println("\n- Entrada incorreta. Tente novamente.");
			}
		}
	}

	
	public static int insertOption() throws IOException {
		int option = 0;
		System.out.print("Inserir número: ");

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
