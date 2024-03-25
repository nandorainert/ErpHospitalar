package br.com.mvcHospitalar.controller;

import java.util.ArrayList;
import java.util.List;
import br.com.mvcHospitalar.DAO.GenericDAO;
import br.com.mvcHospitalar.DAO.MedicoDAOImpl;
import br.com.mvcHospitalar.model.Medico;

public class MedicoController {
	public List<Medico> listarTodos() {
		try {
			GenericDAO dao = new MedicoDAOImpl();
			List<Medico> lista = new ArrayList<Medico>();

			for (Object object : dao.listarTodos()) {
				lista.add((Medico) object);
			}

			return lista;

		} catch (Exception ex) {
			System.out.println("Problemas na Controller para listar medico " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean cadastrar(Medico medico) {
		try {
			GenericDAO dao = new MedicoDAOImpl();
			dao.cadastrar(medico);
			return true;
		} catch (Exception ex) {
			System.out.println("Problemas na controller para cadastrar medico " + ex.getMessage());
			ex.printStackTrace();
			return false;
		}

	}
	
	public boolean alterar(Medico medico) {
		try {
			GenericDAO dao = new MedicoDAOImpl();
			dao.alterar(medico);
			return true;
		} catch (Exception ex) {
			System.out.println("Problemas na controller para alterar medico " + ex.getMessage());
			ex.printStackTrace();
			return false;
		}

	}

	public void excluir(int id) {
		try {
			GenericDAO dao = new MedicoDAOImpl();
			dao.excluir(id);
		} catch (Exception ex) {
			System.out.println("Problemas na controller para alterar medico " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public Medico listarPorId(int id) {
		try {
			GenericDAO dao = new MedicoDAOImpl();
			Medico paciente = (Medico) dao.listarPorId(id);
			return paciente;
		} catch (Exception e) {
			System.out.println("Problemas na Controller para listar medico por id " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
}
