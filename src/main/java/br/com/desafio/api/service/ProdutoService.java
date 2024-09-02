package br.com.desafio.api.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.api.model.Produto;
import br.com.desafio.api.model.dto.ProdutoDTO;
import br.com.desafio.api.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public void inserir(ProdutoDTO dto) {

		Produto obj = modelMapper.map(dto, Produto.class);
		
		if(obj != null) {
			repository.saveAndFlush(obj);
		}
	}

	public Produto findById(Long idProduto) {
		return repository.findById(idProduto).get();
	}

}
