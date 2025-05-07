package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.Controller;
import projeto_final_bloco_01.model.Estendida;
import projeto_final_bloco_01.model.Principal;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		Controller midias = new Controller();
		
		int opcao, numeroSerie, anoLancamento, tipo;
		float valor;
		String nome, generos, bluray;
		
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
					
					System.out.print("\nDigite o nome da mídia: ");
					leia.skip("\\R");
					nome = leia.nextLine();
					
					System.out.print("Digite os gêneros da mídia: ");
					generos = leia.nextLine();
					
					System.out.print("Digite o ano de lançamento: ");
					anoLancamento = leia.nextInt();
					
					System.out.print("Digite o tipo da mídia (1- DVD, 2- Fita VHS): ");
					tipo = leia.nextInt();
					
					System.out.print("Digite o valor: ");
					valor = leia.nextFloat();
					
					switch(tipo) {
						case 1 -> {
							System.out.print("O DVD é em BluRay? ");
							leia.skip("\\R");
							bluray = leia.next();
							midias.cadastrar(new Estendida(midias.gerarNumero(), nome, generos, anoLancamento, tipo, valor, bluray));
						}
					}
					
					keyPress();
					break;
				case 2:
					System.out.println("\nListar todas as mídias de vídeo");

					midias.listarTodos();
					
					keyPress();
					break;
				case 3:
					System.out.println("\nConsultar mídias por ID");

					System.out.print("\nDigite o número de série da midia que deseja encontrar: ");
					numeroSerie = leia.nextInt();
					
					midias.listarPorNSerie(numeroSerie);
					
					keyPress();
					break;
				case 4:
					System.out.println("\nAtualizar cadastro de mídia");

					System.out.print("\nDigite o número de série da midia: ");
					numeroSerie = leia.nextInt();
					
					Optional<Principal> midia = midias.buscarNaCollection(numeroSerie);
					
					if(midia.isPresent()) {
						System.out.print("\nDigite o nome da mídia: ");
						leia.skip("\\R");
						nome = leia.nextLine();
						
						System.out.print("Digite os gêneros da mídia: ");
						generos = leia.nextLine();
						
						System.out.print("Digite o ano de lançamento: ");
						anoLancamento = leia.nextInt();
						
						System.out.print("Digite o valor: ");
						valor = leia.nextFloat();
						
						tipo = midia.get().getTipo();
						
						switch(tipo) {
							case 1 -> {
								System.out.print("O DVD é em BluRay? ");
								leia.skip("\\R");
								bluray = leia.next();
								midias.atualizar(new Estendida(numeroSerie, nome, generos, anoLancamento, tipo, valor, bluray));;
							}
						}
					} else
						System.out.printf("\nA mídia com o número de série %d não foi encontrada!", numeroSerie);
					
					keyPress();
					break;
				case 5:
					System.out.println("\nDeletar mídia");
					
					System.out.print("\nDigite o número de série da mídia: ");
					numeroSerie = leia.nextInt();
					
					midias.deletar(numeroSerie);

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
