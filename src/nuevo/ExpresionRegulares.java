package nuevo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionRegulares {

	public static void main(String[] args) {
		// Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);

		// Pattern pattern = Pattern.compile("[a-z&&[def]]");
		// Pattern pattern = Pattern.compile("[a-d[m-p]]");
		// Pattern pattern = Pattern.compile("[a-d[m-p]]");
		// Pattern pattern = Pattern.compile("[a-z&&[^bc]]");
		// Pattern pattern = Pattern.compile("[a-z&&[^m-p]]");
		// Pattern pattern = Pattern.compile("\\d+");
		// Pattern pattern = Pattern.compile("\\h");
		// Pattern pattern = Pattern.compile("\\s"); // Matcher matcher =
		// pattern.matcher("3i"); si tiene espacio cumple
		// Pattern pattern = Pattern.compile("\\s"); 
		//Patorn PROD- CON 3 LETRAS
//		Pattern pattern = Pattern.compile("^PROD-.{3}");
//		Matcher matcher = pattern.matcher("PROD-528");
		// EL TEXTO NO COMIENZE CON NUMERO
		Pattern pattern = Pattern.compile("^\\D.");
		Matcher matcher = pattern.matcher("L528");

		// boolean matchFound = matcher.find();
		System.out.println(matcher.find() ? "si cumple" : "no cumple");

		// System.out.println("/");//Pattern.matches("\\s"," ")?"si cumple(metodo)":"no
		// cumple(metodo)");
	}
}
