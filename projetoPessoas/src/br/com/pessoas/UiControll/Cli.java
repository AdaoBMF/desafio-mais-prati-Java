package br.com.pessoas.UiControll;

import java.util.Scanner;

import br.com.pessoas.util.EntryCheck;

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
	 * @return String
	 */
	public static String getTxt() {
		boolean first = true;
		String entry = "";
		while (true) {
			if (!first) {
				Cli.showTxt("Insira uma Entrada V�lida: ");
			}
			entry = sc.nextLine().trim();
			if (!entry.equals("")) {
				return entry;
			}
			first = false;
		}
	}
	
	public static String getAlpha() {
		
		boolean first = true;
		String entry = "";
		while (true) {
			if (!first) {
				Cli.showTxt("Insira uma Entrada V�lida: (apenas letras) ");
			}
			entry = sc.nextLine().trim();
			if (!entry.equals("") && EntryCheck.alphaCheck(entry)) {
				return entry;
			}
			first = false;
		}
	}
	
	
	/**
	 * Metodo que capta e valida numero de telefone com 10 a 12 digitos
	 * 
	 * @return string numerica
	 */
	public static String getPhone() {
		boolean first = true;
		String entry = "";
		while (true) {
			if (!first) {
				Cli.showTxt("Insira um N�mero V�lido: (apenas n�meros de 8 a 15 digitos)");
			}
			entry = sc.nextLine().trim();
			if (!entry.equals("") && EntryCheck.PhoneCheck(entry)) {
				return entry;
			}
			first = false;
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
		// Caso usado em OS configurado em ingles  o tratamento ( "," <-> "." )deve ser invertido 
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
