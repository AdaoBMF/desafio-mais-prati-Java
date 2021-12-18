package br.com.pessoas.util;

import java.util.Date;

import br.com.pessoas.UiControll.Cli;
import br.com.pessoas.model.Individuo;

public class UpdateManager {
	
	public static void updateName(Individuo target) {
		Cli.showTxt("Nome: ");
		String name = Cli.getTxt();
		target.setName(name);
	}
	
	public static void updatePhone(Individuo target) {
		Cli.showTxt("Telefone: ");
		String phone = Cli.getTxt();
		target.setPhone(phone);
	}
	
	public static void updateBirthdate(Individuo target) {
		Date date = DateManager.inputDate();
		target.setBirthdate(date);
	}
	
	public static void updateFinalGrade(Individuo target) {
		Double grade = GradeManager.getGrade();
		target.setFinalGrade(grade);
	}
	
	public static void updateLastUpdate(Individuo target) {
		Date date = new Date();
		target.setLastUpdate(date);
	}
	
}
