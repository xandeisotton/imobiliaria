package br.com.uniciss.imobiliaria.exception;

import java.io.FileNotFoundException;

public class UsuarioException extends FileNotFoundException {
	
	public UsuarioException(String message){
		super(message);
	}

}