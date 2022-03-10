package com.sunflower.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunflower.ecommerce.model.Carrinho;
import com.sunflower.ecommerce.repository.CarrinhoRepository;


@RestController
@RequestMapping("/carrinho")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarrinhoController {
	
		@Autowired // Injeção de dependência
		private CarrinhoRepository carrinhoRepository;

		// Busca todas as requisições ao /carrinho
		@GetMapping
		public ResponseEntity<List<Carrinho>> getAll() {
			return ResponseEntity.ok(carrinhoRepository.findAll());
		}

		// Busca por ID
		@GetMapping("/{id}")
		public ResponseEntity<Carrinho> getById(@PathVariable long id) {
			return carrinhoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.notFound().build());
		}

		// Cria uma nova postagem
		@PostMapping
		public ResponseEntity<Carrinho> postCarrinho (@Valid @RequestBody Carrinho nome) {
			return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoRepository.save(nome));
		}
		
		// Deleta algo criado pelo ID
		@DeleteMapping
		public void deleteAll() {
			carrinhoRepository.deleteAll();
		
		}

		// Deleta algo criado pelo ID
		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteCarrinho(@PathVariable long id) {

			return carrinhoRepository.findById(id).map(resposta -> {
				carrinhoRepository.deleteById(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}).orElse(ResponseEntity.notFound().build());
		}

}
