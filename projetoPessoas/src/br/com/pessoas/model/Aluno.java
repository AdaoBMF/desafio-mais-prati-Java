package br.com.pessoas.model;

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
	public Aluno(String name, String phone, String birthdate, Double finalGrade) {
		// chama o construtor padrao da classe pai e inclui a nota final(propriedade adicional da classe)
		super(name, phone, birthdate);
		this.setFinalGrade(finalGrade);
	}

	@Override
	public String toString() {
		return "\nAluno \nNome: " + getName() + " \nTelefone: " + getPhone() + " \nData de nascimento: "
				+ getBirthdate() + "Nota final: " + getFinalGrade() + " \nData de cadastro: " + getRegisterDate()
				+ " \nÚltima atualização: " + getFileUpdate()
				+ "\n------------------------------------------------------------\n";
	}

}
