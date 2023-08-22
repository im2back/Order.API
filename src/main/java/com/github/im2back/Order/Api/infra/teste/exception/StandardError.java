package com.github.im2back.Order.Api.infra.teste.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class StandardError implements Serializable {
private static final long serialVersionUID = 1L;

	private Integer status;
	private String error;
	private String message;
	private String path;

}
