package edu.elt.java;

public class HolaMundo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String frase = "Java es el mejor lenguaje de programación del mundo";
		System.out.println(frase);
		Integer caracteres = frase.length();
		System.out.println(caracteres);
		String fraseMayus = frase.toUpperCase();
		System.out.println(fraseMayus);
		String fraseConArroba = frase.replace(' ', '@');
		System.out.println(fraseConArroba);
		String[] palabras = frase.split(" ");
		for (String palabra : palabras)
			System.out.println(palabra);
		Integer mejor = frase.indexOf("mejor");
		System.out.println(mejor);
		String subFrase = frase.substring(10, 20);
		System.out.println(subFrase);
		boolean empiezaCon = frase.startsWith("Java");
		System.out.println(empiezaCon);
		boolean mandarina = frase.equals("mandarina");
		System.out.println(mandarina);
	}

}
