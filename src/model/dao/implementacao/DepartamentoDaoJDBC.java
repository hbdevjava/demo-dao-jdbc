package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"DELETE FROM Department "
					+ "WHERE "
					+ "Id = ?");

			st.setInt(1, id);
			
			int linhasAfetadas = st.executeUpdate();
			
			if(linhasAfetadas == 0) {
				System.out.println("Id nao existe");
			}else {
				System.out.println("Deletado com Sucesso");
			}
			
			
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} 
		finally {
			DB.fecharStatement(st);
			DB.fecharConexao();;
		}
		
	}

	@Override
	public Departamento encontrarPorId(Integer id) {
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				st = conn.prepareStatement(
					"SELECT * FROM department WHERE Id = ?");
				st.setInt(1, id);
				rs = st.executeQuery();
				if (rs.next()) {
					Departamento obj = new Departamento();
					obj.setId(rs.getInt("Id"));
					obj.setName(rs.getString("Name"));
					return obj;
				}
				return null;
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			finally {
				DB.fecharStatement(st);
				DB.fecharResultSet(rs);
			}
		
	}

	@Override
	public List<Departamento> encontrarTodos() {
		
		return null;
	}

}
