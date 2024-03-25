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

		return null;
	}

	@Override
	public boolean cadastrar(Object object) {

		return false;
	}

	@Override
	public boolean alterar(Object object) {

		return false;
	}

	@Override
	public void excluir(int id) {

	}

}
