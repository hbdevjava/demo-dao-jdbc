package model.dao;

import db.DB;
import model.dao.implementacao.VendedorDaoJDBC;

public class FabricaDAO {

	public static VendedorDAO createVendedorDAO() {
		return new VendedorDaoJDBC(DB.abrirConexao());
	}
	//-> A CLASSE FabricaDAO MOSTRA O METODO (QUANDO CHAMADO) .createVendedorDAO() QUE RETORNA O TIPO DA INTERFACE
	//VendedorDAO MAS INTERNAMENTE ELA VAI INSTANCIA UMA IMPLEMENTA��O VendedorDaoJDBC(null);
	//ISSO FAZ COM QUE VC NAO PRECISE EXPOR A IMPLEMENTA�AO DA CLASSE VendedorDaoJDBC(null) MOSTRA SOMENTE A INTERFACE
	//VendedorDAO EX: VendedorDAO vendedorDAO = FabricaDAO.createVendedorDAO();
	
	
	
}
