package br.edu.ifms.dbf2.ProjetoN2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.dbf2.ProjetoN2.model.SorteioModel;
import br.edu.ifms.dbf2.ProjetoN2.repository.SorteadoRepository;

@Service
public class SorteadoService {
	
	@Autowired
	private SorteadoRepository sorteioRepository;
	
	public List<SorteioModel> buscarTodos(){
		return sorteioRepository.findAll();
	}
	
}
