package br.com.uniciss.imobiliaria.classes;


public abstract class Funcionario extends Pessoa {

		protected Login login;
		protected String tipo;
		
		public Login getLogin(){
			return this.login;
		}
		
		public String getTipo(){
			return this.tipo;
		}
		
		public String loginToString(){
			return this.login.getLogin() + " " + this.login.getSenha();
		}
		
		@Override
		public String toString() {
			return "Funcionário [tipo=" + this.tipo + ", login="
					+ this.login.getLogin() + ", senha=" + this.login.getSenha()
					+ ", nome=" + nome  +  " cpf=" + cpf + ", telefone=" + telefone + "]";
		}
		
		
	}