package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Optional;

import projeto_final_bloco_01.model.Principal;
import projeto_final_bloco_01.repository.Repository;

public class Controller implements Repository {
	
	ArrayList<Principal> listaMidias = new ArrayList<Principal>();
	int numero = 0;
	
	// Métodos CRUD
	public void cadastrar(Principal midia) {
		listaMidias.add(midia);
		System.out.println("\nNova mídia cadastrada com sucesso!");
	}
	
	@Override
	public void listarTodos() {
		for(var midia : listaMidias)
			midia.visualizar();
	}
	
	@Override
	public void listarPorNSerie(int numeroSerie) {
		Optional<Principal> midia = buscarNaCollection(numeroSerie);
		
		if(midia.isPresent())
			midia.get().visualizar();
		else
			System.out.printf("\nA mídia com o número de série %d não foi encontrada!", numeroSerie);
	}



	@Override
	public void atualizar(Principal midia) {
		Optional<Principal> buscaMidia = buscarNaCollection(midia.getNumeroSerie());
			
		if(buscaMidia.isPresent()) {
			listaMidias.set(listaMidias.indexOf(buscaMidia.get()), midia);
			System.out.printf("\nMídia de número %d excluída com sucesso!", midia.getNumeroSerie());
		}
		else
			System.out.printf("\nA mídia com o número de série %d não foi encontrada!", midia.getNumeroSerie());
	}



	@Override
	public void deletar(int numeroSerie) {
		Optional<Principal> midia = buscarNaCollection(numeroSerie);
		
		if(midia.isPresent())
			if(listaMidias.remove(midia.get()) == true)
				System.out.printf("\nMídia de número %d excluída com sucesso!", numeroSerie);
			else
				System.out.printf("\nA mídia com o número de série %d não foi encontrada!", numeroSerie);
	}
	
	
	// Métodos Auxiliares
	public int gerarNumero() {
		return ++numero;
	}
	
	public Optional<Principal> buscarNaCollection(int numero) {
		for(var conta : listaMidias) {
			if(conta.getNumeroSerie() == numero)
				return Optional.of(conta);
		}
		
		return Optional.empty();
	}

}
