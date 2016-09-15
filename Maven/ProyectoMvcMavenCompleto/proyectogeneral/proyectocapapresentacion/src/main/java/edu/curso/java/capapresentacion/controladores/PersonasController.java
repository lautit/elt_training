package edu.curso.java.capapresentacion.controladores;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.curso.java.capadatos.bo.Persona;
import edu.curso.java.capapresentacion.controladores.form.PersonaForm;
import edu.curso.java.capaservicio.PersonaService;

@Controller
@RequestMapping(value="/personas")
public class PersonasController {

	@Autowired
	private PersonaService personaService;
	
	@RequestMapping(value="/listado", method = RequestMethod.GET)
	public String listado(Model model) {
		model.addAttribute("personas", personaService.recuperarPersonas());
		return "/personas/listado";
	}
	
	
	@RequestMapping(value="/ver", method = RequestMethod.GET)
	public String ver(@RequestParam("id") long id, Model model)  {
		Persona persona = personaService.buscarPersonaPorId(id);
		
	 	model.addAttribute("persona", persona);
	 	return "/personas/ver";
	}
	
	@RequestMapping(value="/editar", method = RequestMethod.GET)
	public String editar(@RequestParam("id") long id, Model model)  {
		Persona persona = personaService.buscarPersonaPorId(id);
		PersonaForm personaForm = new PersonaForm();
		BeanUtils.copyProperties(persona, personaForm);
		model.addAttribute("personaForm", personaForm);	
		return "/personas/form";
	}
	
	@RequestMapping(value="/borrar", method = RequestMethod.GET)
	public String borrar(@RequestParam("id") long id, Model model)  {
		personaService.borrarPersona(id);
		return "redirect:/personas/listado.html";
	}

	@RequestMapping(value="/nuevo", method = RequestMethod.GET)
	public String nuevo(Model model) throws Exception{
		
		PersonaForm personaForm = new PersonaForm();
		model.addAttribute("personaForm", personaForm);
		return "/personas/form";
	}

	@RequestMapping(value="/guardar", method = RequestMethod.POST)
	public String guardar(@ModelAttribute("personaForm") @Valid PersonaForm personaForm, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "/personas/form";
		}
		
		long id = personaForm.getId();
		
		Persona persona = null;
		
		if(id == 0) {
			persona = new Persona();
			this.asignarCamposPersona(personaForm, persona);
			id = personaService.guardarNuevaPersona(persona);	
		} else {
			persona = personaService.buscarPersonaPorId(id);
			this.asignarCamposPersona(personaForm, persona);
			personaService.actualizarPersona(persona);
		}
		
		return "redirect:/personas/ver.html?id=" + id;
	}


	private void asignarCamposPersona(PersonaForm personaForm, Persona persona) {
		persona.setNombre(personaForm.getNombre());
		persona.setApellido(personaForm.getApellido());
	}
	
}
