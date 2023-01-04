package br.edu.ifms.dbf2.ProjetoN2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.dbf2.ProjetoN2.model.AreaModel;
import br.edu.ifms.dbf2.ProjetoN2.repository.AreaRepository;

@Service
public class AreaService {
	@Autowired
	private AreaRepository areaRepository;
	
	public List<AreaModel>buscarTodos(){
		return areaRepository.findAll();
	}
	
	public void Salvar(AreaModel areaModel) {
		areaRepository.save(areaModel);
	}
	public AreaModel procurar(Integer id) {
		return areaRepository.getById(id);
	}
	public void deletar(Integer id) {
		areaRepository.deleteById(id);
	}
	
}
