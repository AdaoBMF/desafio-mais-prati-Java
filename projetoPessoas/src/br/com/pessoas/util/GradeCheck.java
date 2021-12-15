package br.com.pessoas.util;

import br.com.pessoas.guiControll.*;

/**
 * Classe auxiliar para validacao e captacao do valor da nota
 * 
 * @author Adao Vieira
 *
 */
public class GradeCheck {
	/**
	 * Metodo que pergunta se sera inserida uma nota e valida a resposta
	 * @return boolean
	 */
	public static boolean gradeCheck() {
		//indentifica a primeira execucao
		String check = "inicial";
		while(!check.equalsIgnoreCase("S") && !check.equalsIgnoreCase("N")){
			
			//se não for a primeira execucao mostra um warning
			if(!check.equals("inicial")) Cli.showTxt("Aviso!\nDigite apenas S ou N ");
			Cli.showTxt("Insrir nota? S/N ");
			check = Cli.getTxt();			
		}
		if(check.equalsIgnoreCase("S")) {
			return true;
		}else {				
			return false;
		}
	}
	
	/**
	 * Metodo que valida e captura a nota final
	 * 
	 * @return Double
	 */
	public static Double getGrade() {
		Double grade = null;
		while(grade == null) {
			try {
				Cli.showTxt("Digite a nota final: ");
				grade = Cli.getDouble();				
			}catch (Exception e) {
				grade = null;
				Cli.showTxt("Aviso!"
						+" \nEntrada invalida. "
						+"\nDigite apenas valores numéricos");
			}
		}
		return grade;
	}

}
