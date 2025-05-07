package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Principal;

public interface Repository {

	public void cadastrar(Principal principal);
	public void listarTodos();
	public void listarPorNSerie(int numeroSerie);
	public void atualizar(Principal principal);
	public void deletar(int numeroSerie);
	
}
