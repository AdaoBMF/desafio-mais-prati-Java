package br.com.pessoas.model;

import java.util.Date;

/**
 * Classe funcional baseada na classe pai Individuo
 * 
 * @author Adao Vieira
 *
 */
public class Pessoa extends Individuo {
	
	/**
	 * Construtor da classe Pessoa
	 * 
	 * @param name
	 * @param phone
	 * @param birthdate
	 */
	public Pessoa(String name, String phone, Date birthdate) {
		//chama o construtor padrao da classe pai(no caso desta classe é o suficiente)
		super(name, phone, birthdate);		
		
	}

	/**
	 * Sobrescricao do metodo "toString" visando otimizar o output das informacoes
	 * gerado pelos metodos de consulta e entregues ao usuario
	 */
	@Override
	public String toString() {
		return "\nPessoa \nNome: " + getName() + " \nTelefone: " + getPhone() + " \nData de nascimento: " 
				+ getBirthdate() + " \nData de cadastro: " + getRegisterDate() 
				+ " \nÚltima atualização: " + getFileUpdate()
				+"\n------------------------------------------------------------\n";
	}
	
}
