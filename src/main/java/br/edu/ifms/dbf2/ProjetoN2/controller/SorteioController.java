package br.edu.ifms.dbf2.ProjetoN2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.dbf2.ProjetoN2.model.SorteioModel;
import br.edu.ifms.dbf2.ProjetoN2.service.ProfessorService;
import br.edu.ifms.dbf2.ProjetoN2.service.SorteioService;

@Controller
public class SorteioController {
	
	@Autowired
	private SorteioService sorteioService;
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/sorteio")
	public ModelAndView listar() {
		
		ModelAndView modelAndView = new ModelAndView("ListaDeSorteios");
		modelAndView.addObject("sorteios", sorteioService.buscarTodos());
		modelAndView.addObject(new SorteioModel());
		modelAndView.addObject("professores",professorService.buscarTodos());
		
		return modelAndView;
		
	}
	@PostMapping("/sorteio")
	public String salvar(SorteioModel sorteioModel) {
		sorteioService.salvar(sorteioModel);
		return "redirect:/sorteio";
		
	}
	
	@GetMapping("/sorteio/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("EditaSorteio");
		modelAndView.addObject(sorteioService.procurar(id));
		modelAndView.addObject("professores",professorService.buscarTodos());
		return modelAndView;
	}
	@GetMapping("/sorteio/deletar/{id}")
	public String deletar(@PathVariable("id") Integer id) {
		sorteioService.deletar(id);
		return "redirect:/sorteio";
		
	}
	
	
}
