package edu.curso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Principal0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		SoyUnComponent soyUnComponent = (SoyUnComponent) appContext.getBean("soyUnComponent");
		//SoyUnComponent soyUnComponent = appContext.getBean(SoyUnComponent.class);
		
		soyUnComponent.setTexto("Hola a todos");
		soyUnComponent.saludar();
	}

}
