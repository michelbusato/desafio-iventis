package br.com.desafio.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class ProdutoDTO {
	
	@JsonProperty("codigo")
	private Integer codigo;
	
	@JsonProperty("tipo_vinho")
	private String tipoVinho;
	
	@JsonProperty("preco")
	private Double preco;
	
	@JsonProperty("safra")
	private String safra;
	
	@JsonProperty("ano_compra")
	private String ano;
	


}
