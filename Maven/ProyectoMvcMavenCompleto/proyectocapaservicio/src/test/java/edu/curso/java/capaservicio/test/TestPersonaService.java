package edu.curso.java.capaservicio.test;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.support.*;
import org.springframework.test.context.transaction.*;

import edu.curso.java.capadatos.bo.Persona;
import edu.curso.java.capaservicio.PersonaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
public class TestPersonaService  extends AbstractTransactionalJUnit4SpringContextTests  {

	@Autowired
	private PersonaService personaService;
		
	@Test
	@Rollback
	public void testGuardarNuevaPersona() {
		Persona persona = new Persona();
		persona.setNombre("Juan");
		persona.setApellido("Perez");
		long idGenerado = personaService.guardarNuevaPersona(persona);
		Assert.assertTrue("No se puedo guardar la persona en la base", idGenerado > 0);
	}
	
}
