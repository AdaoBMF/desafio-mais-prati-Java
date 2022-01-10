package br.com.pessoas.model;

import java.util.Date;

/**
 * Classe pai que padroniza as criação das classes funcionais(Pessoa e Aluno)
 * 
 * @author Adao Vieira
 *
 */
public abstract class Individuo implements Comparable<Individuo> {
	
	private final Integer ID;
	private String name;
	private String phone;
	private Date birthdate;
	private Double finalGrade = null;
	private Date registerDate;
	private Date lastUpdate;

	/**
	 * Construtor padrão da classe Individuo
	 * 
	 * @param name
	 * @param phone
	 * @param birthdate
	 * @param registerDate
	 */
	public Individuo(String name, String phone, Date birthdate, int ID) {
		this.ID = ID;
		this.name = name;
		this.phone = phone;
		this.birthdate = birthdate;
		this.registerDate = new Date();
		this.lastUpdate = new Date();
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
		this.birthdate = birthdate;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date fileUpdate) {
		this.lastUpdate = fileUpdate;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(double finalGrade) {
		this.finalGrade = finalGrade;
	}
	
	public Integer getID() {
		return ID;
	}

	/**
	 * Sobrescricao do metodo "compareTo" para permitir que os objetos armazenados
	 * sejam classificados em ordem alfabetica tendo os nomes como parametro de
	 * classificacao
	 */
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
