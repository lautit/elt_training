package edu.curso.java.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Principal0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ComponenteA componenteA = (ComponenteA) appContext.getBean("componenteAImpl");
		componenteA.hacerMetodoA();
		
		ComponenteA componenteA2 = (ComponenteA) appContext.getBean("componenteAImpl");
		componenteA2.hacerMetodoA();
	}

}
