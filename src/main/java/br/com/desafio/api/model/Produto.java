package br.com.desafio.api.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "produto")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "codigo")
	private Integer codigo;
	
	@Column(name = "TIPO_VINHO")
	private String tipoVinho;
	
	@Column(name = "preco")
	private Double preco;
	
	@Column(name = "safra")
	private String safra;
	
	@Column(name = "ano")
	private String ano;
	
	
}
