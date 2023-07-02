package aplicacao;

import java.util.Date;

import model.dao.FabricaDAO;
import model.dao.VendedorDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {

//		Departamento depart = new Departamento(1, "Books");
//		Vendedor vendedorr = new Vendedor(21, "Vikas", "vk@outlook.com", new Date(), 3000.89, depart);

		VendedorDAO vendedorDAO = FabricaDAO.createVendedorDAO();
		System.out.println("<<<<<< TESTE NUMERO 1: Vendedor encontrarPorId() >>>>>>");
		Vendedor vendedor = vendedorDAO.encontrarPorId(5);
		System.out.println(vendedor);

//		System.out.println(depart);
//		System.out.println();
//		System.out.println(vendedorr);
		
		

	}

}
