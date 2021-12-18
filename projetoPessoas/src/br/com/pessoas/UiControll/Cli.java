package br.com.pessoas.UiControll;

import java.util.Scanner;



/**
 * Classe responsavel por possibilitar a interacao do usuario via terminal
 * 
 * @author Adao Vieira
 *
 */
public class Cli {
	
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * metodo que recebe uma entrada(String) do usuario
	 * 
	 * @param msg
	 * @return String 
	 */
	public static String getTxt() {		
		return sc.nextLine();
	}

	/**
	 * metodo que recebe uma entrada(int) do usuario
	 * 
	 * @param msg
	 * @return int 
	 */
	public static int getInt() {
		return Integer.parseInt(sc.nextLine());
	}
	
	/**
	 * metodo que recebe uma entrada(double) do usuario
	 * 
	 * @param msg
	 * @return double 
	 */
	public static double getDouble() {
		return Double.parseDouble(sc.nextLine().replace(",", "."));
	}
	
	/**
	 * metodo que exibe um output destinado ao usuario
	 * 
	 * @param txt
	 */
	public static void showTxt(String txt){
		System.out.print("\n"+txt);
	}

}
