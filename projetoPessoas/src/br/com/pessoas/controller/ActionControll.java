package br.com.pessoas.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.regex.Pattern;

import br.com.pessoas.UiControll.Cli;
import br.com.pessoas.model.Aluno;
import br.com.pessoas.model.Individuo;
import br.com.pessoas.model.Pessoa;
import br.com.pessoas.util.*;

/**
 * Classe que contem os metodos que efetuam as demandas(CRUD) do usuario
 * 
 * @author Adao Vieira
 *
 */
public class ActionControll {
	// Array que ira armazenar os objetos criados durante a sessao
	private static ArrayList<Individuo> individuos = new ArrayList<>();
	private static int idCounter = 1;

	/**
	 * metodo que cria um objeto Individuo(Pessoa/Aluno) e o armazena na Array
	 * individuos
	 */
	private static void register() {
		Individuo ind = null;
		Cli.showTxt("Nome: ");
		String name = Cli.getAlpha();
		Cli.showTxt("Telefone: (apenas n�meros de 8 a 15 digitos) ");
		String phone = Cli.getPhone();
		Cli.showTxt("Data de nascimento: (dd/mm/aaaa)\n");
		Date birthdate = DateManager.inputDate();
		Double finalGrade = Menu.gradeCheck() ? GradeManager.getGrade() : null;

		try {
			if (finalGrade == null) {
				ind = new Pessoa(name, phone, birthdate, idCounter);
				individuos.add(ind);
			} else {
				ind = new Aluno(name, phone, birthdate, idCounter, finalGrade);
				individuos.add(ind);
			}
			idCounter++;
			Cli.showTxt("Registro criado \n" + ind.toString());
		} catch (Exception e) {
			Cli.showTxt("N�o foi possivel concluir a inclus�o" + "\nErro: " + e.toString());
		}

	}

	/**
	 * Metodo que retorna um individuo pesquisado pelo nome completo
	 * 
	 * @param int ID
	 * @return Individuo
	 */
	private static Individuo getIndById(int ID) {
		Individuo ind = null;
		for (Individuo obj: individuos) {
			if (obj.getID() == ID) ind = obj;
		}
		return ind;
	}
	
	

	/**
	 * Metodo que auxilia/gerencia a edicao ou exclusao de um individuo
	 */
	private static void edit() {
		Individuo ind = null;
		int op = 0;
		int prop = 0;
		Cli.showTxt("Insira o ID do Registro: ");
		String targetStr = Cli.getTxt();
		Integer target = Pattern.matches("[0-9]", targetStr) ? Integer.parseInt(targetStr) : 0;
		try {
			ind = getIndById(target);
			Cli.showTxt(ind.toString());
		} catch (Exception e) {
			Cli.showTxt("Registro n�o encontrado");
		}
		if (ind != null) {
			op = Menu.menuEdit();
			switch (op) {
			case 1:
				prop = Menu.menuProp();
				if (prop == 5)
					break;
				updateIndividuo(ind, prop);
				break;
			case 2:
				deleteIndividuo(ind);
				break;
			case 3:
				break;
			}
		}
	}

	/**
	 * Metodo que lista todos os Individuos armazenados
	 */
	private static String listIndividuos() {
		if (individuos.size() > 0) {
			try {
				Collections.sort(individuos);
				return individuos.toString().replace(",", "");
			} catch (Exception e) {
				return "Nenhum Registro Encontrado";
			}
		} else {
			return "O Cadastro Est� Vazio";
		}
	}

	/**
	 * Metodo que lista todos Alunos cadastrados
	 * 
	 * @return String
	 */
	private static String listAlunos() {
		ArrayList<Aluno> arr = new ArrayList<>();
		Individuo ind = null;
		try {
			for (int i = 0; i < individuos.size(); i++) {
				ind = individuos.get(i);
				if (ind instanceof Aluno) {
					arr.add((Aluno) ind);
				}
			}
			if (arr.size() > 0) {
				Collections.sort(arr);
				return arr.toString().replace(",", "");
			} else {
				return "Nenhum Aluno registrado";
			}
		} catch (Exception e) {
			return "Nenhum Registro Encontrado";
		}
	}

	/**
	 * Metodo que lista todas pessoas cadastradas
	 * 
	 * @return String
	 */
	private static String listPessoas() {
		ArrayList<Pessoa> arr = new ArrayList<>();
		Individuo ind = null;
		try {
			for (int i = 0; i < individuos.size(); i++) {
				ind = individuos.get(i);
				if (ind instanceof Pessoa) {
					arr.add((Pessoa) ind);
				}
			}
			if (arr.size() > 0) {
				Collections.sort(arr);
				return arr.toString().replace(",", "");
			} else {
				return "Nenhuma Pessoa registrada";
			}
		} catch (Exception e) {
			return "Nenhum Registro Encontrado";
		}
	}

	/**
	 * Metotdo que realiza a edicao de um Individuo especifico
	 * 
	 * @param target
	 * @param prop
	 */
	private static void updateIndividuo(Individuo target, int prop) {
		Individuo ind = null;
		if (target instanceof Pessoa) {
			ind = (Pessoa) target;
		} else if (target instanceof Aluno) {
			ind = (Aluno) target;
			if (prop == 4)
				UpdateManager.updateFinalGrade(ind);
		}
		if (ind != null) {
			switch (prop) {
			case 1:
				UpdateManager.updateName(ind);
				break;
			case 2:
				UpdateManager.updatePhone(ind);
				break;
			case 3:
				UpdateManager.updateBirthdate(ind);
				break;
			}
			UpdateManager.updateLastUpdate(ind);
		}
		Cli.showTxt("Cadastro atualizado\n" + ind.toString());
	}

	/**
	 * Metodo que exclui um individuo especifico
	 * 
	 * @param target
	 */
	private static void deleteIndividuo(Individuo target) {
		boolean confirm = Menu.deleteAlert(target);
		if(confirm) {
			String name = target.getName();
			individuos.remove(target);
			Cli.showTxt("Registro " + name + " removido com sucesso. \n");
		}else {
			Cli.showTxt("Exclus�o cancelada \n");
		}
	}

	/**
	 * Metodo que inicia a execucao do aplicativo e controla o fluxo dos inputs e
	 * outputs/feedbacks
	 */
	public static void start() {
		boolean session = true;
		Integer op;
		Cli.showTxt("Bem vindo!\n" + "\nSistema de cadastro Foobar " + DateManager.printDateTime(new Date()));
		while (session) {
			op = Menu.menuPrincipal();
			switch (op) {
			case 1:
				register();
				break;
			case 3:
				edit();
				break;
			case 4:
				session = Menu.sessionAlert();
				break;
			case 5:
				Cli.showTxt(listIndividuos());
				break;
			case 6:
				Cli.showTxt(listPessoas());
				break;
			case 7:
				Cli.showTxt(listAlunos());
				break;
			case 8:
				continue;
			}
		}
		Cli.endSession();
	}
}
