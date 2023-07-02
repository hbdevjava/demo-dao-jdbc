package model.dao.implementacao;

import java.sql.Connection;
import java.util.List;

import model.dao.DepartamentoDAO;
import model.entities.Departamento;

public class DepartamentoDaoJDBC implements DepartamentoDAO{

	private Connection conn;// dependencia	
	
	public DepartamentoDaoJDBC(Connection conn) {
		this.conn= conn;
	}

	@Override
	public void inserir(Departamento departamento) {
		
		
	}

	@Override
	public void atualizar(Departamento departamento) {

	}

	@Override
	public void deletarPorId(Integer id) {
		
		
	}

	@Override
	public void encontrarPorId(Integer id) {
		
		
	}

	@Override
	public List<Departamento> encontrarTodos() {
		
		return null;
	}

}
