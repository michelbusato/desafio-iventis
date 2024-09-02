package br.com.desafio.api.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.api.model.Cliente;
import br.com.desafio.api.model.dto.ClienteResponseDTO;
import br.com.desafio.api.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public Cliente create(ClienteResponseDTO request) {	
		Cliente cliente = modelMapper.map(request, Cliente.class);
		return repository.saveAndFlush(cliente);
		
	}

	public Cliente findById(Long idCliente) {
		return repository.findById(idCliente).get();
	}

	

}
