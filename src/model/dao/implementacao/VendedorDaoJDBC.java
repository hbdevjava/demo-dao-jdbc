package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void inserir(Vendedor vendedor) {
		PreparedStatement st = null;
		try {
			conn = DB.abrirConexao();

			// EXAMPLE 1:
			st = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)", 
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, vendedor.getNome() );
			st.setString(2, vendedor.getEmail());
			st.setDate(3, new java.sql.Date(vendedor.getDataNascimento().getTime()));
			st.setDouble(4, vendedor.getBasaSalarial());
			st.setInt(5, vendedor.getDepartmento().getId());

			
			int linhasAfetadas = st.executeUpdate();
			
			if (linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					vendedor.setId(id);
				}
				DB.fecharResultSet(rs);//-> NESSE CASO TEM SE SER FECHADO AQUI POIS ELE SO EXISTE NO ESCOPO DO IF()
			}
			else {
				throw new DbException("Nenhuma linha afetada!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		
		finally {
			DB.fecharStatement(st);
			
		}
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
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName  "
					+ "FROM seller INNER JOIN department  " + "ON seller.DepartmentId = department.Id  "
					+ "ORDER BY name   ");
			
			rs = st.executeQuery();

			List<Vendedor> listaVendedores = new ArrayList<>();
			Map<Integer, Departamento> mapper = new HashMap<>();

			while (rs.next()) {// -> while pq pode zero dep ou varios deps
				Departamento depd = mapper.get(rs.getInt("DepartmentId"));
				if (depd == null) {

					Departamento departamento = intanciarDepartamento(rs);
					mapper.put(rs.getInt("DepartmentId"), depd);
				}
				Vendedor obj = intanciarVendedor(rs, depd);
				listaVendedores.add(obj);// ADICIONEI UM VENDEDOR A LISTA
				
			}
			return listaVendedores;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.fecharStatement(st);
			DB.fecharResultSet(rs);
		}

		
	

	}

	@Override
	public List<Vendedor> encontrarPorDepartamento(Departamento dep) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName  "
					+ "FROM seller INNER JOIN department  " + "ON seller.DepartmentId = department.Id  "
					+ "WHERE DepartmentId = ?   " + "ORDER BY name   ");
			st.setInt(1, dep.getId());
			rs = st.executeQuery();

			List<Vendedor> listaVendedores = new ArrayList<>();
			Map<Integer, Departamento> mapper = new HashMap<>();

			while (rs.next()) {// -> while pq pode zero dep ou varios deps
				Departamento depd = mapper.get(rs.getInt("DepartmentId"));
				if (depd == null) {

					Departamento departamento = intanciarDepartamento(rs);
					mapper.put(rs.getInt("DepartmentId"), depd);
				}
				Vendedor obj = intanciarVendedor(rs, dep);
				listaVendedores.add(obj);// ADICIONEI UM VENDEDOR A LISTA
				return listaVendedores;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.fecharStatement(st);
			DB.fecharResultSet(rs);
		}

		
	}

	
}
