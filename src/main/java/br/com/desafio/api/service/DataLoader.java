package br.com.desafio.api.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.desafio.api.model.Cliente;
import br.com.desafio.api.model.Compra;
import br.com.desafio.api.model.Produto;
import br.com.desafio.api.model.dto.ClienteDTO;
import br.com.desafio.api.model.dto.ClienteResponseDTO;
import br.com.desafio.api.model.dto.CompraDTO;
import br.com.desafio.api.model.dto.ProdutoDTO;
import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

	public static final String URL_PRODUTO = "https://rgr3viiqdl8sikgv.public.blob.vercel-storage.com/produtos-mnboX5IPl6VgG390FECTKqHsD9SkLS.json";
	public static final String URL_COMPRA = "https://rgr3viiqdl8sikgv.public.blob.vercel-storage.com/clientes-Vz1U6aR3GTsjb3W8BRJhcNKmA81pVh.json";

	@Autowired
	ProdutoService produtoService;

	@Autowired
	ClienteService clienteService;

	@Autowired
	CompraService compraService;

	
	@PostConstruct
	public void init() {
		popularBaseProdutos();
		popularBaseCompras();
	}

	private void popularBaseCompras() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ClienteDTO[]> response = restTemplate.getForEntity(URL_COMPRA, ClienteDTO[].class);
		List<ClienteDTO> lista = Arrays.asList(response.getBody());

		if(!lista.isEmpty()) {
			lista.forEach(c -> {
				preencherCompras(c);
			});				
		}
	}

	
	private void preencherCompras(ClienteDTO dto) {
		
		ClienteResponseDTO request = new ClienteResponseDTO();
		request.setCpf(dto.getCpf());
		request.setNome(dto.getNome());
		
		if(!request.getCpf().isEmpty() && !request.getNome().isEmpty()) {
			Cliente  cliente = clienteService.create(request);
			
			if(cliente != null) {
				
				if(!dto.getCompras().isEmpty()) {
					for(CompraDTO item: dto.getCompras()) {
						
						Produto produto = produtoService.findById(Long.parseLong(item.getCodigo()));
						
						Compra compra = new Compra();
						compra.setCliente(cliente);
						compra.setProduto(produto);
						compra.setQuantidade(item.getQuantidade());
						compraService.inserir(compra);
					}
				}
				
			}
			
		}
		
		
		
	}

	private void popularBaseProdutos() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<ProdutoDTO[]> response = restTemplate.getForEntity(URL_PRODUTO, ProdutoDTO[].class);

		List<ProdutoDTO> lista = Arrays.asList(response.getBody());

		if(!lista.isEmpty()) {
			lista.forEach(p -> {
				produtoService.inserir(p);
			});
		}
	}




}
