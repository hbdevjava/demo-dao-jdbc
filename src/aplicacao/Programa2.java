package aplicacao;

import model.dao.DepartamentoDAO;
import model.dao.FabricaDAO;
import model.dao.VendedorDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Programa2 {

	public static void main(String[] args) {
		
		
		DepartamentoDAO departamentoDao = FabricaDAO.createDepartamentoDAO();

		
		System.out.println("<<<<<< TESTE NUMERO 1: Departamento encontrarPorId() >>>>>>");
		Departamento dep = departamentoDao.encontrarPorId(1);
		System.out.println(dep);
		
		
		
		
		
	}

}
