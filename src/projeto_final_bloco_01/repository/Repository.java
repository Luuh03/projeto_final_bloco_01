package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Principal;

public interface Repository {

	public void cadastrar(Principal midia);
	public void listarTodos();
	public void listarPorNSerie(int numeroSerie);
	public void atualizar(Principal midia);
	public void deletar(int numeroSerie);
	
}
