package br.com.pessoas.UiControll;

import java.util.Scanner;

import br.com.pessoas.util.StringCheck;

/**
 * Classe responsavel por possibilitar a interacao do usuario via terminal
 * 
 * @author Adao Vieira
 *
 */
public class Cli {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * Metodo que recebe uma entrada(String) do usuario
	 * 
	 * @param msg
	 * @return String
	 */
	public static String getTxt() {
		boolean start = true;
		String entry = "";
		while (true) {
			if (start != true)
				Cli.showTxt("Insira um Valor Válido: ");
			entry = sc.nextLine().trim();
			if (!entry.equals("") && StringCheck.stringCheck(entry)) {
				return entry;
			}
			start = false;
		}
	}

	/**
	 * Metodo que recebe uma entrada(int) do usuario
	 * 
	 * @param msg
	 * @return int
	 */
	public static int getInt() {
		return Integer.parseInt(sc.nextLine());
	}

	/**
	 * Metodo que recebe uma entrada(double) do usuario
	 * 
	 * @param msg
	 * @return double
	 */
	public static double getDouble() {
		return Double.parseDouble(sc.nextLine().replace(",", "."));
	}

	/**
	 * Metodo que exibe um output destinado ao usuario
	 * 
	 * @param txt
	 */
	public static void showTxt(String txt) {
		System.out.print("\n" + txt);
	}

}
