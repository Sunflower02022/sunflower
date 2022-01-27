package com.sunflower.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo nome não pode ser vazio")
	@Size(min = 5, max = 100, message = "O atributo nome deve conter no min 5 e no max 100 caracteres")
	private String nome_categoria;
	
	@NotBlank(message = "O atributo descricao não pode ser vazio")
	@Size(min = 5, max = 100, message = "O atributo descricao deve conter no min 5 e no max 100 caracteres")
	private String descricaoCategoria;
	
	@NotBlank(message = "O atributo setor não pode ser vazio")
	@Enumerated(value = EnumType.STRING)
	private Setor setor;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome_categoria() {
		return nome_categoria;
	}

	public void setNome_categoria(String nome_categoria) {
		this.nome_categoria = nome_categoria;
	}


	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	
	

}
