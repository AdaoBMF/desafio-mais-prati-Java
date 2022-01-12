package br.com.pessoas.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.pessoas.UiControll.Cli;

/**
 * Classe auxiliar para gerenciar datas
 * 
 * @author Adao Vieira
 *
 */
public class DateManager {

	private static DateFormat dayF = new SimpleDateFormat("dd/MM/yyyy");
	private static DateFormat dayTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static String printDate(Date entry) {
		return dayF.format(entry);
	}

	public static String printDateTime(Date entry) {
		return dayTime.format(entry);
	}

	/**
	 * Metodo auxiliar que recebe e valida a entrada do dia que ira compor a data
	 * 
	 * @return String
	 */
	private static Integer inputDay() {
		int day = 0;
		Boolean first = true;
		while (day == 0) {
			if (!first) {
				Cli.showTxt("Aviso!\nEntrada inválida\n \nDigite apenas números de 1 a 31");
			}
			Cli.showTxt("Digite o dia do mês ");
			try {
				Integer entry = Cli.getInt();
				if (entry > 0 && entry <= 31) {
					day = entry;
				}
			} catch (Exception e) {
			}

			first = false;
		}
		return day;
	}

	/**
	 * Metodo auxiliar que recebe e valida a entrada do mes(numeral) que ira compor
	 * a data
	 * 
	 * @return String
	 */
	private static Integer inputMonth() {
		int month = 0;
		Boolean first = true;
		while (month == 0) {
			if (!first) {
				Cli.showTxt("Aviso!\nEntrada inválida\n \nDigite apenas números de 1 a 12");
			}
			Cli.showTxt("Digite o nº do mês ");
			try {
				Integer entry = Cli.getInt();
				if (entry > 0 && entry <= 12) {
					month = entry;
				}
			} catch (Exception e) {
			}
			first = false;
		}
		return month;
	}

	/**
	 * Metodo auxiliar que recebe e valida a entrada do ano que ira compor a data
	 * 
	 * @return String
	 */
	private static Integer inputYear() {
		int year = 0;
		Boolean first = true;
		while (year == 0) {
			if (!first) {
				Cli.showTxt("Aviso!\nEntrada inválida \n\n Digite um ano válido");
			}
			Cli.showTxt("Digite o ano ");
			try {
				Integer entry = Cli.getInt();
				if (entry >= 1920 && entry <= 2021) {
					year = entry;
				}
			} catch (Exception e) {
			}
			first = false;
		}
		return year;
	}

	/**
	 * Metodo que recebe as entradas do usuario, valida, formata e retorna em
	 * formato Date
	 * 
	 * @return Date
	 */
	public static Date inputDate() {
		Date date = null;
		String str = "";
		Boolean check = true;
		while(check) {
			Integer day = inputDay();
			Integer month = inputMonth();
			Integer year = inputYear();
			if(EntryCheck.dateCheck(day, month, year)) {
				str = String.format("%s/%s/%s", day, month, year);
				check = false;
			}else {
				Cli.showTxt("Aviso! \nData Inválida \n");
			}
		}
		try {
			date = dayF.parse(str);
		} catch (ParseException e) {
			System.out.print("Não foi possivel armazenar a data");
			System.out.print(e.toString());
		}
		return date;
	}

}
