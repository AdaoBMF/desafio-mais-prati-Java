package br.com.pessoas.model;

import java.util.Date;

import br.com.pessoas.util.DateManager;

/**
 * Classe funcional baseada na classe pai Individuo
 * 
 * @author Adao Vieira
 *
 */
public class Aluno extends Individuo {

	/**
	 * Construtor da classe Aluno
	 * 
	 * @param name
	 * @param phone
	 * @param birthdate
	 * @param finalGrade
	 */
	public Aluno(String name, String phone, Date birthdate,int ID, Double finalGrade) {
		super(name, phone, birthdate, ID);
		this.setFinalGrade(finalGrade);
	}

	/**
	 * Sobrescricao do metodo "toString" visando otimizar o output das informacoes
	 * gerado pelos metodos de consulta e entregues ao usuario
	 */
	@Override
	public String toString() {
		return "\nAluno ID " + this.getID() + " \nNome: " + getName() + " \nTelefone: " + getPhone() + " \nData de nascimento: "
				+ DateManager.printDate(getBirthdate()) + "\nNota final: " + getFinalGrade() + " \nData de cadastro: "
				+ DateManager.printDateTime(getRegisterDate()) + " \nÚltima atualização: "
				+ DateManager.printDateTime(getLastUpdate())
				+ "\n------------------------------------------------------------\n";
	}

}
