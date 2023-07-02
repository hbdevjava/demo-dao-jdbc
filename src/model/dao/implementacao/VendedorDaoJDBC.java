package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.VendedorDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

public class VendedorDaoJDBC implements VendedorDAO {

	private Connection conn;// dependencia

	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(Vendedor Vendedor) {

	}

	@Override
	public void atualizar(Vendedor Vendedor) {

	}

	@Override
	public void deletarPorId(Integer id) {

	}

	@Override
	public Vendedor encontrarPorId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?");

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departamento dep = intanciarDepartamento(rs);
				Vendedor obj = intanciarVendedor(rs, dep);
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.fecharStatement(st);
			DB.fecharResultSet(rs);
		}
	}

	private Departamento intanciarDepartamento(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();// -> ESSE COD INSTANCIA UM DEPARTAMENTO
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	private Vendedor intanciarVendedor(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor obj = new Vendedor();// -> ESSE COD INSTANCIA UM VENDEDOR;
		obj.setId(rs.getInt("Id"));
		obj.setNome(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBasaSalarial((rs.getDouble("BaseSalary")));
		obj.setDataNascimento((rs.getDate("BirthDate")));
		obj.setDepartmento(dep);
		return obj;
	}

	@Override
	public List<Vendedor> encontrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
