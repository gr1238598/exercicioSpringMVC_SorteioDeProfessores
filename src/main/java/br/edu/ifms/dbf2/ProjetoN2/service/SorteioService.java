package br.edu.ifms.dbf2.ProjetoN2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.dbf2.ProjetoN2.model.SorteioModel;
import br.edu.ifms.dbf2.ProjetoN2.repository.SorteioRepository;

@Service
public class SorteioService {
		@Autowired
		private SorteioRepository sorteioRepository;
		
		public List<SorteioModel> buscarTodos() {
			
			return sorteioRepository.findAll();
			
		}
		
		public void salvar(SorteioModel sorteioModel) {
			sorteioRepository.save(sorteioModel);
		}
		
		public SorteioModel procurar(Integer id) {
			
			return sorteioRepository.getById(id);
		}
		public void deletar(Integer id) {
			sorteioRepository.deleteById(id);
		}
		
		
}
