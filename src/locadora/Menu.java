package locadora;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		int opcao;

		while (true) {
			
			System.out.println("*******************************************");
			System.out.println("                                           ");
			System.out.println("          LOCADORA TÚNEL DO TEMPO          ");
			System.out.println("                                           ");
			System.out.println("*******************************************");
			System.out.println("                                           ");
			System.out.println("    1_ Cadastrar novo produto              ");
			System.out.println("    2_ Listar todas as mídias de vídeo     ");
			System.out.println("    3_ Consultar mídias por ID             ");
			System.out.println("    4_ Atualizar cadastro de mídia         ");
			System.out.println("    5_ Deletar mídia                       ");
			System.out.println("    6_ Sair                                ");
			System.out.println("                                           ");
			System.out.println("*******************************************");
			System.out.println("Digite a opção desejada:                   ");
			System.out.println("                                           ");

			opcao = leia.nextInt();
			
			if(opcao == 6) {
				System.out.println("\nFinalizando programa.");
				leia.close();
				System.exit(0);
			}
			
			switch(opcao) {
				case 1:
					System.out.println("\nCadastrar novo produto");
					
					keyPress();
					break;
				case 2:
					System.out.println("\nListar todas as mídias de vídeo");

					keyPress();
					break;
				case 3:
					System.out.println("\nConsultar mídias por ID");

					keyPress();
					break;
				case 4:
					System.out.println("\nAtualizar cadastro de mídia");

					keyPress();
					break;
				case 5:
					System.out.println("\nDeletar mídia");

					keyPress();
					break;
				default:
					System.out.println("\nOpção inválida! Tente novamente.");

					keyPress();
					break;
			}
		}
		
	}
	
	public static void keyPress() {
		try {
 
			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();
 
		} catch (IOException e) {
 
			System.err.println("Você pressionou uma tecla diferente de enter!");
 
		}
	}

}
