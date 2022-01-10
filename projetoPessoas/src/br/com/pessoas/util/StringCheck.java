package br.com.pessoas.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCheck {

	public static boolean stringCheck(String str) {
		Pattern p = Pattern.compile("[!@#$%&*()_+=|<>?{}\\\\[\\\\]-,.;:]");
		Matcher m = p.matcher(str);
		return !m.find();
	}
}
