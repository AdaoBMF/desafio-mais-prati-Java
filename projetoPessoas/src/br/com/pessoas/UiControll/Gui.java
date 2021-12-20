package br.com.pessoas.UiControll;

import javax.swing.JOptionPane;

/**
 * Classe responsavel por controlar a interface grafica
 * 
 * @author Adao Vieira
 *
 */
public class Gui {
	/**
	 * metodo que exibe uma janela de dialogo para coletar uma entrada(String) do usuario
	 * 
	 * @param msg
	 * @return String 
	 */
	public static String getTxt(String msg) {
		boolean start = true;
		String entry = "";
		while(true) {
			if(start !=true) Gui.showTxt("Insira um Valor Válido"); 
			entry = JOptionPane.showInputDialog(msg).trim();
			if(!entry.equals("")) {
				return entry;
			}
			start =false;
		}
	}

	/**
	 * metodo que exibe uma janela de dialogo para coletar uma entrada(int) do usuario
	 * 
	 * @param msg
	 * @return int 
	 */
	public static int getInt(String msg) {
		return Integer.parseInt(JOptionPane.showInputDialog(msg));
	}
	
	/**
	 * metodo que exibe uma janela de dialogo para coletar uma entrada(double) do usuario
	 * 
	 * @param msg
	 * @return double 
	 */
	public static double getDouble(String msg) {
		return Double.parseDouble(JOptionPane.showInputDialog(msg).replace(",", "."));
	}
	
	/**
	 * metodo que cria uma janela de dialogo para exibir um output destinado ao usuario
	 * 
	 * @param txt
	 */
	public static void showTxt(String txt){
		JOptionPane.showMessageDialog(null, txt);
	}

}
