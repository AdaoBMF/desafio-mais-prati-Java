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
import br.com.pessoas.util.UpdateManager;

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
		for (Individuo obj : individuos) {
			if (obj.getName().equalsIgnoreCase(search)) {
				ind = obj;
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

	/**
	 * Metotdo que realiza a edicao de um Individuo especifico
	 * 
	 * @param target
	 * @param prop
	 */
	public static void updateIndividuo(Individuo target, String prop) {
		Individuo ind = null;
		if (target instanceof Pessoa) {
			ind = (Pessoa) target;
		} else if (target instanceof Aluno) {
			ind = (Aluno) target;
			if (prop.equalsIgnoreCase("finalGrade"))
				UpdateManager.updateFinalGrade(ind);
		}
		if (ind != null) {
			switch (prop) {
			case "name":
				UpdateManager.updateName(ind);
				break;
			case "phone":
				UpdateManager.updatePhone(ind);
				break;
			case "birthdate":
				UpdateManager.updateBirthdate(ind);
				break;
			}
			UpdateManager.updateLastUpdate(ind);
		}
		Cli.showTxt(
				"Cadastro atualizado\n"
				+ind.toString()
				);
	}
	
	/**
	 * Metodo que exclui um individuo especifico
	 * 
	 * @param target
	 */
	public static void deleteIndividuo(Individuo target) {
		String name = target.getName();
		individuos.remove(target);
		Cli.showTxt(name +" removido com sucesso.");		
	}

	// testes
	/*
	 * SEQUENCIA DE EDICAO
	 * 
	 * APOS BUSCAR IND PERGUNTA: ACOES=> EDITAR / APAGAR / SAIR
	 * 
	 * EDITAR? => NOME / TELEFONE / NOTA / SAIR
	 * 
	 * NOVO VALOR? => EXECUTA => FEEDBACK
	 * 
	 * PROP? => NOME / TELEFONE / NOTA / SAIR
	 * 
	 * 
	 * APAGAR => APAGA => FEEDBACK
	 */

}
