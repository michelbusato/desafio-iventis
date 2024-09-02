package br.com.desafio.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteRecomendacaoResponseDTO {
	
	private String nome;	
	private String cpf;
	private String tipoVinho;
	private Integer quantidade;
}
