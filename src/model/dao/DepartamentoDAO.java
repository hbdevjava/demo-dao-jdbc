package model.dao;

import java.util.List;

import model.entities.Departamento;

public interface DepartamentoDAO {
		
	
	void inserir(Departamento departamento);
	void atualizar(Departamento departamento);
	void deletarPorId(Integer id);
	void encontrarPorId(Integer id);
	List<Departamento> encontrarTodos();
}
