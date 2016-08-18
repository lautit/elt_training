package edu.elt.java;

import edu.elt.java.dao.GestorDePersonas;
import edu.elt.java.dao.exceptions.GestorException;

import java.util.ArrayList;

import edu.elt.java.bo.Persona;

public class HolaMundo {

	public static void main(String[] args) {
		Persona mario = new Persona("Mario", "Petit", 31);
		GestorDePersonas hr = new GestorDePersonas();
		
		try {
			hr.alta(mario);
		} catch (GestorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Persona esMario = null;
		
		try {
			esMario = hr.buscar(mario.getIdPersona());
			
			System.out.println(esMario.toString());
			System.out.println(mario.equals(esMario));
			
		} catch (GestorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mario.setApellido("Gimenez");
		
		try {
			hr.actualizar(mario);
		} catch (GestorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Persona> personas;
		
		try {
			personas = hr.recuperarTodo();
			
			for(Persona persona : personas)
				System.out.println("[MAIN] recuperarTodo - Resultado: " + persona.toString());
			
		} catch (GestorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			hr.baja(mario.getIdPersona());
		} catch (GestorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Puto el que lee.");
	}
}
