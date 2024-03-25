package br.com.mvcHospitalar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.mvcHospitalar.model.Medico;
import br.com.mvcHospitalar.util.ConnectionFactory;

public class MedicoDAOImpl implements GenericDAO {

	private Connection conn;

	public MedicoDAOImpl() throws Exception {
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
		String sql = "SELECT * FROM medico";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Medico medico = new Medico();
				medico.setId(rs.getInt("id"));
				medico.setNome(rs.getString("Nome"));
				lista.add(medico);
			}
		} catch (SQLException ex) {
			System.out.println("Problemas na DAO ao listar Medico! " + ex.getMessage());
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
		Medico medico = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM medico WHERE id = (?)";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				medico = new Medico();
				medico.setId(rs.getInt("id"));
				medico.setNome(rs.getString("nome"));
			}

		} catch (SQLException ex) {
			System.out.println("Problemas na DAO ao listar Medico por id! " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar conexão! " + e.getMessage());
				e.printStackTrace();
			}
		}

		return medico;
	}

	@Override
	public boolean cadastrar(Object object) {
		Medico medico = (Medico) object;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO medico (nome) VALUES (?)";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, medico.getNome());
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
		Medico medico = (Medico) object;
		PreparedStatement stmt = null;
		String sql = "UPDATE medico SET nome = ? WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, medico.getNome());
			stmt.setInt(2, medico.getId());
			stmt.execute();
			return true;
		} catch (Exception e) {
			System.out.println("Problemas na DAO ao alterar medico " + e.getMessage());
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
		String sql = "DELETE FROM medico WHERE id = (?)";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
		} catch (Exception e) {
			System.out.println("Problemas na DAO ao excluir medico! " + e.getMessage());
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
