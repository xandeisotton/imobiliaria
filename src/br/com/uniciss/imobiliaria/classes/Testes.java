package br.com.uniciss.imobiliaria.classes;

public class Testes {

	private void cadastrarCliente() {
		
		Cliente c=new Cliente();
		codCliente++;
		c.setCodigo(codCliente);
		c.cadastrarClientes();
		menu();
	}
}
