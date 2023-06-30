package aplicacao;

import java.util.Date;

import model.entities.Departamento;
import model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {

		Departamento depart = new Departamento(1, "Books");
		Vendedor vendedor = new Vendedor(21, "Vikas", "vk@outlook.com", new Date(), 3000.89, depart);
		
		System.out.println(depart);
		System.out.println();
		System.out.println(vendedor);
		
		
		
		
	}

}
