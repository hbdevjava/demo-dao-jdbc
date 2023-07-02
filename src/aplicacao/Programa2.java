package aplicacao;

import java.util.List;

import model.dao.DepartamentoDAO;
import model.dao.FabricaDAO;
import model.entities.Departamento;


public class Programa2 {

	public static void main(String[] args) {
		
		
		DepartamentoDAO departamentoDao = FabricaDAO.createDepartamentoDAO();

		
		System.out.println("<<<<<< TESTE NUMERO 1: Departamento encontrarPorId() >>>>>>");
		Departamento dep = departamentoDao.encontrarPorId(1);
		System.out.println(dep);
		
		System.out.println();
		System.out.println("<<<<<< TESTE NUMERO 3: Departamento encontrarTodos() >>>>>>");
		List<Departamento> listaDep = departamentoDao.encontrarTodos();
		for (Departamento depart : listaDep) {
			System.out.println(depart);
		}
		
		System.out.println();
		System.out.println("<<<<<< TESTE NUMERO 4: Departamento inserir() >>>>>>");
		Departamento novoDepart = new Departamento(null, "Perfumaria");
		departamentoDao.inserir(novoDepart);
		System.out.println("novo id: " + novoDepart.getId());

		
		
		
	}

}
