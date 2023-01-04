package br.edu.ifms.dbf2.ProjetoN2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.dbf2.ProjetoN2.model.ProfessorModel;
import br.edu.ifms.dbf2.ProjetoN2.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<ProfessorModel> buscarTodos(){
		return professorRepository.findAll();
	}
	
	public void salvar(ProfessorModel professorModel) {
		professorRepository.save(professorModel);
	}
	
	public ProfessorModel procurar(Integer id) {
		return professorRepository.getById(id);
	}
	public void deletar(Integer id) {
		professorRepository.deleteById(id);
	}
	
}
