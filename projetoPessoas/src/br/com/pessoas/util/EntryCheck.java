package br.com.pessoas.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntryCheck {
	
	public static Boolean alphaCheck(String str) {
		Pattern p = Pattern.compile("[!@#$%&*()_+=|<>?{}\\\\[\\\\]-,.;:0-9]");
		Matcher m = p.matcher(str);
		return !m.find();
	}
	
	public static Boolean PhoneCheck(String str) {
		Pattern p = Pattern.compile("[!@#$%&*()_+=|<>?{}\\\\\\\\[\\\\\\\\]-,.;:A-z]");
		Matcher m = p.matcher(str);
		if(!m.find()) {
			return str.matches("\\d{8,15}");		
		}
		return false;
	}
	
	public static Boolean dateCheck(int day, int month, int year) {		
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

