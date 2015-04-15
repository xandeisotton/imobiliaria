package br.com.uniciss.imobiliaria.classes;

public class Usuario {
	protected String login;
	protected String senha;
	protected String tipo;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String palavras) {
		this.login = palavras;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String palavras) {
		this.tipo = palavras;
	}
	
	
}
