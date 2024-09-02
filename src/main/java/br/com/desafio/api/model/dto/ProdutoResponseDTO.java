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
public class ProdutoResponseDTO {
	
	private String codigo;
	private String tipoVinho;
	private String preco;
	private String safra;
	private String ano;
	


}
