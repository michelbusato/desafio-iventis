package br.com.desafio.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.desafio.api.model.Compra;
import br.com.desafio.api.model.dto.ClienteFielResponseDTO;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>, JpaSpecificationExecutor<Compra> {

	List<Compra> findAllByProduto_Ano(String ano);

	@Query(value=" select id_cliente, cl.cpf, cl.nome, max(c.quantidade) as total,  p.preco as valor  from compra c  "
			+ " join produto p ON c.id_produto = p.id "
			+ " join cliente cl on c.id_cliente = cl.id "
			+ " group by id_cliente, cl.cpf, cl.nome, p.preco order by total desc "
			+ " limit 3", nativeQuery = true)
	List<Object[]> getClienteFieis();
	
	@Query(value=" Select distinct c.id_cliente, cl.cpf , cl.nome, p.tipo_vinho, c.quantidade from compra c "
			+ " join produto p ON c.id_produto = p.id "
			+ " join cliente cl ON c.id_cliente = cl.id "
			+ " where c.quantidade = (select max(quantidade) from compra c2 where c2.id_cliente = c.id_cliente)"
			+ " order by c.id_cliente "
			, nativeQuery = true)
	List<Object[]> getClienteRecomendacao();


}
