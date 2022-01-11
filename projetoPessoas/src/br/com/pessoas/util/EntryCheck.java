package br.com.pessoas.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntryCheck {

	public static boolean stringCheck(String str) {
		Pattern p = Pattern.compile("[!@#$%&*()_+=|<>?{}\\\\[\\\\]-,.;:]");
		Matcher m = p.matcher(str);
		return !m.find();
	}
	
	public static Boolean checkDate(int day, int month, int year) {
		
		if(month == 2) {
			if(year %4 == 0) {
				return day > 0 && day <=29;
			}else {
				return day > 0 && day <=28;
			}
		}else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return day > 0 && day <= 31;
		}else {
			return day > 0 && day <= 30;
		}
	}

}

