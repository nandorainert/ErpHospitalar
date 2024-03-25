package br.com.mvcHospitalar.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.mvcHospitalar.DAO.GenericDAO;
import br.com.mvcHospitalar.DAO.PacienteDAOImpl;
import br.com.mvcHospitalar.model.Paciente;

public class PacienteController {
	public List<Paciente> listarTodos() {
		try {
			GenericDAO dao = new PacienteDAOImpl();
			List<Paciente> lista = new ArrayList<Paciente>();

			for (Object object : dao.listarTodos()) {
				lista.add((Paciente) object);
			}

			return lista;

		} catch (Exception ex) {
			System.out.println("Problemas na Controller para listar paciente " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean cadastrar(Paciente paciente) {
		try {
			GenericDAO dao = new PacienteDAOImpl();
			dao.cadastrar(paciente);
			return true;
		} catch (Exception ex) {
			System.out.println("Problemas na controller para cadastrar paciente " + ex.getMessage());
			ex.printStackTrace();
			return false;
		}

	}
	
	public boolean alterar(Paciente paciente) {
		try {
			GenericDAO dao = new PacienteDAOImpl();
			dao.alterar(paciente);
			return true;
		} catch (Exception ex) {
			System.out.println("Problemas na controller para alterar paciente " + ex.getMessage());
			ex.printStackTrace();
			return false;
		}

	}

	public void excluir(int id) {
		try {
			GenericDAO dao = new PacienteDAOImpl();
			dao.excluir(id);
		} catch (Exception ex) {
			System.out.println("Problemas na controller para alterar paciente " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public Paciente listarPorId(int id) {
		try {
			GenericDAO dao = new PacienteDAOImpl();
			Paciente paciente = (Paciente) dao.listarPorId(id);
			return paciente;
		} catch (Exception e) {
			System.out.println("Problemas na Controller para listar paciente por id " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
