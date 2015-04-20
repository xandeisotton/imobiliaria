package br.com.uniciss.imobiliaria.exception;

import java.io.FileNotFoundException;

@SuppressWarnings("serial")
public class UsuarioException extends FileNotFoundException {
//	
	public UsuarioException(String message){
		super(message); 
	}

}