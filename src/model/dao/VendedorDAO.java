package model.dao;

import java.util.List;

import model.entities.Vendedor;


public interface VendedorDAO {

	void inserir(Vendedor Vendedor);
	void atualizar(Vendedor Vendedor);
	void deletarPorId(Integer id);
	public Vendedor encontrarPorId(Integer id);
	List<Vendedor> encontrarTodos();
}
