package br.com.pessoas.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import br.com.pessoas.guiControll.Cli;
import br.com.pessoas.model.Aluno;
import br.com.pessoas.model.Individuo;
import br.com.pessoas.model.Pessoa;
import br.com.pessoas.util.DateManager;
import br.com.pessoas.util.GradeCheck;

/**
 * Classe que contem os metodos que efetuam as demandas(CRUD) do usuario
 * 
 * @author Adao Vieira
 *
 */
public class ActionControll {
	// Array que ira armazenar os objetos criados durante a sessao
	private static ArrayList<Individuo> individuos = new ArrayList<>();

	/**
	 * metodo que cria um objeto Individuo(Pessoa/Aluno) e o armazena na Array
	 * individuos
	 */
	public static void register() {
		Cli.showTxt("Nome: ");
		String name = Cli.getTxt();
		Cli.showTxt("Telefone: ((12)123456789) ");
		String phone = Cli.getTxt();
		Cli.showTxt("Data de nascimento: (dd/mm/aaaa) ");
		Date birthdate = DateManager.inputDate();
		Double finalGrade = GradeCheck.gradeCheck() ? GradeCheck.getGrade() : null;

		try {
			if (finalGrade == null) {
				Pessoa pessoa = new Pessoa(name, phone, birthdate);
				individuos.add(pessoa);
			} else {
				Aluno aluno = new Aluno(name, phone, birthdate, finalGrade);
				individuos.add(aluno);
			}
		} catch (Exception e) {
			Cli.showTxt("Não foi possivel concluir a inclusão" + "\nErro: " + e.toString());
		}

	}
	
	/**
	 * Metodo que lista todos os Individuos armazenados
	 */
	public static void listIndividuos() {
		Collections.sort(individuos);
		Cli.showTxt(individuos.toString().replace(",", ""));
	}
	
	/**
	 * Metodo que retorna um individuo pesquisado pelo nome
	 * 
	 * @param nome 
	 * @return Individuo
	 */
	public static Individuo getIndByName(String search) {
		Individuo ind = null;
		String name;
		for (int i = 0; i < individuos.size(); i++) {
			name = individuos.get(i).getName();
			if (name.equalsIgnoreCase(name)) {
				ind = individuos.get(i);
			}
		}
		return ind;
	}

	/**
	 * Metodo que lista todos Alunos dastrados
	 * 
	 * @return String
	 */
	public static String listAlunos() {
		ArrayList<Aluno> arr = new ArrayList<>();
		Individuo ind = null;
		for (int i = 0; i < individuos.size(); i++) {
			ind = individuos.get(i);
			if (ind instanceof Aluno) {
				arr.add((Aluno) ind);
			}
		}
		return arr.toString().replace(",", "");
	}

	/**
	 * Metodo que lista todas pessoas cadastradas
	 * 
	 * @return String
	 */
	public static String listPessoas() {
		ArrayList<Pessoa> arr = new ArrayList<>();
		Individuo ind = null;
		for (int i = 0; i < individuos.size(); i++) {
			ind = individuos.get(i);
			if (ind instanceof Pessoa) {
				arr.add((Pessoa) ind);
			}
		}
		return arr.toString().replace(",", "");
	}

	// testes

	

}
