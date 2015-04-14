package br.com.uniciss.imobiliaria.classes;

public abstract class Cliente extends Pessoa {

	protected String banco;
	protected String numConta;
	
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getNumConta() {
		return numConta;
	}
	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}
	
	
}
