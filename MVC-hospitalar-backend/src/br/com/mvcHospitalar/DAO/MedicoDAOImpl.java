package br.com.mvcHospitalar.DAO;

import java.sql.Connection;
import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object listarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cadastrar(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub
		
	}

}
