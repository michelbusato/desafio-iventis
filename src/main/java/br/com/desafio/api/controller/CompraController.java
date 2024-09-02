package br.com.desafio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.api.model.dto.ClienteFielResponseDTO;
import br.com.desafio.api.model.dto.ClienteRecomendacaoResponseDTO;
import br.com.desafio.api.model.dto.CompraDetalhadaRequestDTO;
import br.com.desafio.api.service.CompraService;

@RestController
@RequestMapping()
public class CompraController {

    @Autowired
    CompraService compraService;
    

    @GetMapping("/compras")
    public ResponseEntity<List<CompraDetalhadaRequestDTO>> getAll() {
        List<CompraDetalhadaRequestDTO> allCustomers = compraService.getAll();
        return ResponseEntity.ok(allCustomers);
    }
  
    @GetMapping("/maior-compra/{ano}")
    public ResponseEntity<List<CompraDetalhadaRequestDTO>> getAllCustomerByAnoNew(@PathVariable(name = "ano") String ano) {
        List<CompraDetalhadaRequestDTO> allCustomers = compraService.getMaiorCompra(ano);
        return ResponseEntity.ok(allCustomers);
    }
    
    @GetMapping("/clientes-fieis")
    public ResponseEntity<List<ClienteFielResponseDTO>> getClienteFieis() {
        List<ClienteFielResponseDTO> allCustomers = compraService.getClienteFieis();
        return ResponseEntity.ok(allCustomers);
    }
    
    
    @GetMapping("/recomendacao/cliente/tipo")
    public ResponseEntity<List<ClienteRecomendacaoResponseDTO>> getClienteRecomendacao() {
        List<ClienteRecomendacaoResponseDTO> allCustomers = compraService.getClienteRecomendacao();
        return ResponseEntity.ok(allCustomers);
    }
    

   }
