package br.com.mvcHospitalar.model;

import java.util.ArrayList;
import java.util.List;

public class Medico {

	private int id;
	private String nome;
	private String especialidade;
	private String crm;
	private boolean isPlantao;
	List<Paciente> pacientes = new ArrayList<>();
	
	public Medico(int id, String nome, String especialidade, String crm, boolean isPlantao, List<Paciente> pacientes) {
		this.id = id;
		this.nome = nome;
		this.especialidade = especialidade;
		this.crm = crm;
		this.isPlantao = isPlantao;
		this.pacientes = pacientes;
	}

	public Medico() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public boolean isPlantao() {
		return isPlantao;
	}

	public void setPlantao(boolean isPlantao) {
		this.isPlantao = isPlantao;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
}
