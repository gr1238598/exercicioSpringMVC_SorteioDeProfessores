package br.edu.ifms.dbf2.ProjetoN2.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.dbf2.ProjetoN2.model.SorteioModel;
import br.edu.ifms.dbf2.ProjetoN2.service.SorteadoService;

@Controller
public class SorteadoController {
	
	@Autowired
	private SorteadoService sorteadoService;
	
	@GetMapping("/sorteados")
	public ModelAndView listar() {
		
		ModelAndView modelAndView = new ModelAndView("ListaSorteados");
		modelAndView.addObject("sorteado",pegaElemento(sorteadoService.buscarTodos(), sorteadoService.buscarTodos().size()));
		
		modelAndView.addObject(new SorteioModel());
		return modelAndView;
		
		
	}
	
	public List<SorteioModel> pegaElemento(List<SorteioModel>lista, int total){
		
		List<SorteioModel> novaLista = new ArrayList<>();
		Collections.shuffle(lista);
		
		for(int i=0;i<total;i++) {
			
			novaLista.add(lista.get(i));
			
		}
		return novaLista;
	}

}
