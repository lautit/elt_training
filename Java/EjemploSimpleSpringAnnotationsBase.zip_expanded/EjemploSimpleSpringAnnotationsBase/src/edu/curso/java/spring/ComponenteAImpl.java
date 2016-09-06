package edu.curso.java.spring;

import org.springframework.stereotype.Component;

@Component
public class ComponenteAImpl implements ComponenteA {

	public ComponenteAImpl() {
		System.out.println("Creando un ComponenteAImpl");
	}

	@Override
	public void hacerMetodoA() {
		System.out.println("hacerMetodoA() in " + this.getClass());
	}

}
