package com.github.im2back.Order.Api.infra.teste.exception;

public class DataBaseException extends RuntimeException {
static final long serialVersionUID = 1L;
	
	public DataBaseException (Object id) {
		super ("Exclusão falhou, usuário de Id:"+id+ " dependente de outros objetos.");
	}

}
