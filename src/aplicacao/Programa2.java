package aplicacao;

import java.util.List;
import java.util.Scanner;

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
		
//		System.out.println();
//		System.out.println("<<<<<< TESTE NUMERO 4: Departamento inserir() >>>>>>");
//		Departamento novoDepart = new Departamento(null, "Vestuario");
//		departamentoDao.inserir(novoDepart);
//		System.out.println("novo id: " + novoDepart.getId());

		System.out.println();
		System.out.println("<<<<<< TESTE NUMERO 5: Departamento atualizar() >>>>>>");
		Departamento departemento_2 = departamentoDao.encontrarPorId(1);
		departemento_2.setName("Musica");
		departamentoDao.atualizar(departemento_2);
		System.out.println("Atualizado");
		
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("<<<<<< TESTE NUMERO 6: Departamento deletarPorId() >>>>>>");
		System.out.print("Entre com o Id do Departamento que deseja excluir: ");
		int id = sc.nextInt();
		departamentoDao.deletarPorId(id);
		

		sc.close();
		
		
	}

}
