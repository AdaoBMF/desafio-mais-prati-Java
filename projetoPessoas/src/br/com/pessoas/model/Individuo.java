package br.com.pessoas.model;

import java.util.Date;

import br.com.pessoas.util.DateManager;

/**
 * Classe pai que padroniza as cria��o das classes funcionais(Pessoa e Aluno)
 * 
 * @author Adao Vieira
 *
 */
public abstract class Individuo implements Comparable<Individuo> {

	// definicao das propriedades da classe
	private String name;
	private String phone;
	private Date birthdate;
	private Date registerDate;
	private Date fileUpdate;
	private Double finalGrade = null;

	/**
	 * Construtor padr�o da classe Individuo
	 * 
	 * @param name
	 * @param phone
	 * @param birthdate
	 * @param registerDate
	 */
	public Individuo(String name, String phone, String birthdate) {
		super();
		this.name = name;
		this.phone = phone;
		this.birthdate = DateManager.formDate(birthdate); //work in progress
		this.registerDate = new Date();
		this.fileUpdate = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.fileUpdate = birthdate;
	}

	public Date getRegisterDate() {
		return registerDate;
	}
	
	public Date getFileUpdate() {
		return fileUpdate;
	}

	public void setFileUpdate(Date fileUpdate) {
		this.fileUpdate = fileUpdate;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(double finalGrade) {
		this.finalGrade = finalGrade;
	}

	@Override
	public int compareTo(Individuo ind) {
		int check = 0;
		if (this.name.length() > ind.getName().length()) {

			for (int i = 0; i < ind.getName().length(); i++) {
				check = this.name.charAt(i) > ind.getName().charAt(i) ? 1
						: this.name.charAt(i) < ind.getName().charAt(i) ? -1 : 0;
				if (check != 0)
					return check;
			}

		} else {
			for (int i = 0; i < this.name.length(); i++) {
				check = this.name.charAt(i) > ind.getName().charAt(i) ? 1
						: this.name.charAt(i) < ind.getName().charAt(i) ? -1 : 0;
				if (check != 0)
					return check;
			}

		}
		return check;
	}
}
