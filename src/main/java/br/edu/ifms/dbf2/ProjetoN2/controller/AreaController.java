package br.edu.ifms.dbf2.ProjetoN2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.dbf2.ProjetoN2.model.AreaModel;
import br.edu.ifms.dbf2.ProjetoN2.service.AreaService;

@Controller

public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	@GetMapping("/")
	public ModelAndView listar() {
		
		ModelAndView modelAndView = new ModelAndView("ListaDeAreas");
		modelAndView.addObject("areas", areaService.buscarTodos());
		modelAndView.addObject(new AreaModel());
		return modelAndView;
		
	}
	
	@PostMapping("/")
	public String Salvar(AreaModel areaModel) {
		areaService.Salvar(areaModel);
		return "redirect:/";
	}
	
	@GetMapping("/area/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("EditaArea");
		modelAndView.addObject(areaService.procurar(id));
		return modelAndView;
		
	}
	@GetMapping("/area/deletar/{id}")
	public String deletar(@PathVariable("id") Integer id) {
		areaService.deletar(id);
		return "redirect:/";
	}
}
