package br.com.desafio.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "COMPRA")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Compra {
	
	
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JsonIgnore
	@ToString.Exclude
	@JoinColumn(name="id_produto", referencedColumnName = "id", nullable=false)
	private Produto produto;
	
	@ManyToOne
	@JsonIgnore
	@ToString.Exclude
	@JoinColumn(name="id_cliente", referencedColumnName = "id", nullable=false)
	private Cliente cliente;
	
	@Column(name = "quantidade")
	private Integer quantidade;

}
