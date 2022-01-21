package com.sunflower.ecommerce.model;

public enum Setor {
	
	
	 RESIDENCIAL ("residencial"),
	 INDUSTRIAL ("industrial");
	
	private String descricao;
	Setor(String descricao){
		this.descricao = descricao;
	}
		public String getDescricao() {
			
			return descricao;
		}
	
}

	
