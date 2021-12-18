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
	public Aluno(String name, String phone, Date birthdate, Double finalGrade) {
		// chama o construtor padrao da classe pai e inclui a nota final(propriedade
		// adicional da classe)
		super(name, phone, birthdate);
		this.setFinalGrade(finalGrade);
	}

	/**
	 * Sobrescricao do metodo "toString" visando otimizar o output das informacoes
	 * gerado pelos metodos de consulta e entregues ao usuario
	 */
	@Override
	public String toString() {
		return "\nAluno \nNome: " + getName() + " \nTelefone: " + getPhone() + " \nData de nascimento: "
				+ DateManager.printDate(getBirthdate()) + "\nNota final: " + getFinalGrade() + " \nData de cadastro: " + getRegisterDate()
				+ " \nÚltima atualização: " + getLastUpdate()
				+ "\n------------------------------------------------------------\n";
	}

}
