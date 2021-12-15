package br.com.pessoas.model;

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
	public Pessoa(String name, String phone, String birthdate) {
		//chama o construtor padrao da classe pai(no caso desta classe � o suficiente)
		super(name, phone, birthdate);		
		
	}

	@Override
	public String toString() {
		return "\nPessoa \nNome: " + getName() + " \nTelefone: " + getPhone() + " \nData de nascimento: " 
				+ getBirthdate() + " \nData de cadastro: " + getRegisterDate() 
				+ " \n�ltima atualiza��o: " + getFileUpdate()
				+"\n------------------------------------------------------------\n";
	}
	
}
