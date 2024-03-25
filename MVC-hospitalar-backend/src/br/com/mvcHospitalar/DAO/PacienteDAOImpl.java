package br.com.mvcHospitalar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.mvcHospitalar.model.Paciente;
import br.com.mvcHospitalar.util.ConnectionFactory;

public class PacienteDAOImpl implements GenericDAO {

	private Connection conn;

	public PacienteDAOImpl() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public List<Object> listarTodos() {	
		
		List<Object> lista = new ArrayList<Object>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM paciente";
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setId(rs.getInt("id"));
				paciente.setNome(rs.getString("Nome"));
				paciente.setCpf(rs.getString("CPF"));
				paciente.setIdade(rs.getInt("Idade"));
				lista.add(paciente);
			}
		} catch (SQLException ex) {
			System.out.println("Problemas na DAO ao listar Paciente! " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar conexão! " + e.getMessage());
			}
		}
		return lista;
	}

	@Override
	public Object listarPorId(int id) {
		Paciente paciente = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM paciente WHERE id = (?)";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				paciente = new Paciente();
				paciente.setId(rs.getInt("id"));
				paciente.setNome(rs.getString("nome"));
			}

		} catch (SQLException ex) {
			System.out.println("Problemas na DAO ao listar Paciente por id! " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar conexão! " + e.getMessage());
				e.printStackTrace();
			}
		}

		return paciente;
	}

	@Override
	public boolean cadastrar(Object object) {
		Paciente paciente = (Paciente) object;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO paciente (nome) VALUES (?)";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, paciente.getNome());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
			System.out.println("Problemas na DAO ao cadastrar medico " + ex.getMessage());
			ex.printStackTrace();
			return false;
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, null);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar conexão! " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean alterar(Object object) {
		Paciente paciente = (Paciente) object;
		PreparedStatement stmt = null;
		String sql = "UPDATE medico SET nome = ? WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, paciente.getNome());
			stmt.setInt(2, paciente.getId());
			stmt.execute();
			return true;
		} catch (Exception e) {
			System.out.println("Problemas na DAO ao alterar paciente " + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, null);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar conexão! " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	@Override
	public void excluir(int id) {
		PreparedStatement stmt = null;
		String sql = "DELETE FROM paciente WHERE id = (?)";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
		} catch (Exception e) {
			System.out.println("Problemas na DAO ao excluir paciente! " + e.getMessage());
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, null);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar conexão! " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
