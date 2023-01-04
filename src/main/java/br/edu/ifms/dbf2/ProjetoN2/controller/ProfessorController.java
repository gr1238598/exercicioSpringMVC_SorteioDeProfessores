package br.edu.ifms.dbf2.ProjetoN2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.dbf2.ProjetoN2.model.ProfessorModel;
import br.edu.ifms.dbf2.ProjetoN2.service.AreaService;
import br.edu.ifms.dbf2.ProjetoN2.service.ProfessorService;

@Controller
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	@Autowired
	private AreaService areaService;
	
	@GetMapping("/professor")
	public ModelAndView listar() {
		
		ModelAndView modelAndView = new ModelAndView("ListaDeProfessores");
		modelAndView.addObject("professores", professorService.buscarTodos());
		modelAndView.addObject(new ProfessorModel());
		modelAndView.addObject("areas", areaService.buscarTodos());

		return modelAndView;
		
	}
	
	@PostMapping("/professor")
	public String salvar(ProfessorModel professorModel) {
		professorService.salvar(professorModel);
		return "redirect:/professor";
		
	}
	@GetMapping("/professor/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("EditaProfessor");
		modelAndView.addObject(professorService.procurar(id));
		modelAndView.addObject("areas", areaService.buscarTodos());
		return modelAndView;
		
	}
	@GetMapping("/professor/deletar/{id}")
	public String deletar(@PathVariable("id") Integer id) {
		professorService.deletar(id);
		return "redirect:/professor";
		
	}
	
	
}
