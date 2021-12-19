package br.com.pessoas.util;

import br.com.pessoas.UiControll.Cli;

public class TerminalManager {
	public static void clear(){
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		}catch(Exception e) {
			Cli.showTxt("Não foi possível limpar a tela");
		}
	}
}
