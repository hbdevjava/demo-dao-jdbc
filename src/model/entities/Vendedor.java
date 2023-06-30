package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Vendedor implements Serializable {
		
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String email;
	private Date dataNascimento;
	private Double BasaSalarial;
	private Departamento departmento;
	
	public Vendedor() {
		
	}

	

	public Vendedor(Integer id, String nome, String email, Date dataNascimento, Double basaSalarial,
			Departamento departmento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.BasaSalarial = basaSalarial;
		this.departmento = departmento;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public Double getBasaSalarial() {
		return BasaSalarial;
	}



	public void setBasaSalarial(Double basaSalarial) {
		BasaSalarial = basaSalarial;
	}



	public Departamento getDepartmento() {
		return departmento;
	}



	public void setDepartmento(Departamento departmento) {
		this.departmento = departmento;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(id, other.id);
	}



	@Override
	public String toString() {
		return "Vendedor id: " + id + ", nome: " + nome + ", email: " + email + ", dataNascimento: " + dataNascimento
				+ ", BasaSalarial: " + BasaSalarial + ", departmento: " + departmento;
	}

	

	
	
	
	
	
	
}
