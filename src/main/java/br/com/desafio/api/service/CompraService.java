package br.com.desafio.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.api.model.Cliente;
import br.com.desafio.api.model.Compra;
import br.com.desafio.api.model.Produto;
import br.com.desafio.api.model.dto.ClienteFielResponseDTO;
import br.com.desafio.api.model.dto.ClienteRecomendacaoResponseDTO;
import br.com.desafio.api.model.dto.ClienteResponseDTO;
import br.com.desafio.api.model.dto.CompraDetalhadaRequestDTO;
import br.com.desafio.api.model.dto.ProdutoResponseDTO;
import br.com.desafio.api.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	CompraRepository repository;

	@Autowired 
	ClienteService clienteService;

	@Autowired
	ProdutoService produtoService;

	@Autowired
	private ModelMapper modelMapper;

	public Compra inserir(Compra compra) {
		return repository.saveAndFlush(compra);

	}

	public List<CompraDetalhadaRequestDTO> getAll() {
		List<CompraDetalhadaRequestDTO> retorno = new ArrayList<>();
		List<Compra> compras = repository.findAll();

		for(Compra item:compras) {

			CompraDetalhadaRequestDTO dto = new CompraDetalhadaRequestDTO();
			Cliente cliente = clienteService.findById(item.getCliente().getId());
			dto.setCliente(modelMapper.map(cliente, ClienteResponseDTO.class));

			Produto produto = produtoService.findById(item.getProduto().getId());
			dto.setProduto(modelMapper.map(produto, ProdutoResponseDTO.class));

			dto.setValorTotal(item.getQuantidade() * produto.getPreco());
			dto.setQuantidade(item.getQuantidade());

			retorno.add(dto);

		}

		Collections.sort(retorno, Comparator.comparingDouble(CompraDetalhadaRequestDTO::getValorTotal));

		return retorno;



	}

	public List<CompraDetalhadaRequestDTO> getMaiorCompra(String ano) {
		List<CompraDetalhadaRequestDTO> retorno = new ArrayList<>();
		List<Compra> compras = repository.findAllByProduto_Ano(ano);

		for(Compra item:compras) {
			CompraDetalhadaRequestDTO dto = new CompraDetalhadaRequestDTO();
			dto.setProduto(modelMapper.map(item.getProduto(), ProdutoResponseDTO.class));
			Cliente cliente = clienteService.findById(item.getCliente().getId());
			dto.setCliente(modelMapper.map(cliente, ClienteResponseDTO.class));
			dto.setValorTotal(item.getQuantidade() * item.getProduto().getPreco());
			dto.setQuantidade(item.getQuantidade());
			retorno.add(dto);
		}
		
		Collections.sort(retorno, Comparator.comparingDouble(CompraDetalhadaRequestDTO::getValorTotal).reversed());
		return retorno.subList(0, 1);

	}

	public List<ClienteFielResponseDTO> getClienteFieis() {
		List<Object[]> lista = repository.getClienteFieis();
		List<ClienteFielResponseDTO> retorno = new ArrayList<>();
		
		for(Object[] item:lista) {
			
			ClienteFielResponseDTO dto = ClienteFielResponseDTO.builder()
			.cpf(item[1].toString())
			.nome(item[2].toString())
			.total(Integer.parseInt(item[3].toString()))			
			.valor(Double.parseDouble(item[4].toString())).build();
			
			retorno.add(dto);
			
			
		}
		Collections.sort(retorno, Comparator.comparingDouble(ClienteFielResponseDTO::getValor).reversed());
		return retorno;
	}
	
	
	public List<ClienteRecomendacaoResponseDTO> getClienteRecomendacao() {
		List<Object[]> lista = repository.getClienteRecomendacao();
		List<ClienteRecomendacaoResponseDTO> retorno = new ArrayList<>();
		
		for(Object[] item:lista) {
			
			ClienteRecomendacaoResponseDTO dto = ClienteRecomendacaoResponseDTO.builder()
			.cpf(item[1].toString())
			.nome(item[2].toString())
			.tipoVinho(item[3].toString())
			.quantidade(Integer.parseInt(item[4].toString()))
			.build();
			
			retorno.add(dto);
		}
		
		Collections.sort(retorno, Comparator.comparing(ClienteRecomendacaoResponseDTO::getNome));
		
		return retorno;
	}




}
