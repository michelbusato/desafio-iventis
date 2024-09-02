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
public class CompraDTO {
	
	@JsonProperty("codigo")
	private String codigo;
	
	@JsonProperty("quantidade")
	private Integer quantidade;
	

	


}
