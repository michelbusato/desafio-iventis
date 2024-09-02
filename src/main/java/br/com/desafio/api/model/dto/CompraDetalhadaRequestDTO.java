package br.com.desafio.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraDetalhadaRequestDTO {
	
	private ClienteResponseDTO cliente;
	private ProdutoResponseDTO produto;
	private Double valorTotal;
	private Integer quantidade;
	
	

	


}
