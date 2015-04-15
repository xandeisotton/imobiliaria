package br.com.uniciss.imobiliaria.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.imobiliaria.classes.Visitas;

public class Agendamento {

	ArrayList<Visitas> listaConsultas = new ArrayList<Visitas>();
	Map<String, Visitas> mapaConsultas = new HashMap<String, Visitas>();
	
	private String nome;
	private String data;
	private String horario;
	private String observações;
	private Scanner s;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getObservações() {
		return observações;
	}
	public void setObservações(String observações) {
		this.observações = observações;
	}
	
	@Override
	public String toString() {
		return "Consulta," + nome + "," + data + "," + horario + ","
				+ observações;
	}

	public void agendarConsulta() throws java.text.ParseException {

		s = new Scanner(System.in);

		System.out.println("Informe o nome de quem deseja agendar a visita: ");
		setNome(s.nextLine());

		verificaData();

		verificaHoras();

		System.out.println("Informações adicionais: ");
		setObservações(s.nextLine());

		GravaTxt g = new GravaTxt();
		g.grava("Visitas.txt", toString());
	}

	@SuppressWarnings("unused")
	public boolean verificaData() {

		String data;

		System.out.println("Informe o dia da visita: ");
		String a = s.nextLine();

		Date hoje = GregorianCalendar.getInstance().getTime();
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
		data = formata.format(hoje);

		Date d = new Date();
		formata = new SimpleDateFormat("dd/MM/yyyy");
		formata.setLenient(false);
		try {
			d = formata.parse(a);

			if ((new Date()).getTime() < d.getTime()) {
				setData(a);

			} else if ((new Date()).getTime() >= d.getTime()) {
				System.out.println("Não é possivel marcar consultas para este dia, informe outra data!");
				System.out.println("");
				verificaData();
			}

		} catch (ParseException e) {
			System.out.println("Você informou uma data inválida!");
			System.out.println("");
			verificaData();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unused")
	public boolean verificaHoras() {

		s = new Scanner(System.in);
		String hora;

		System.out.println("Informe o horário da visita: ");
		String horarioInformado = s.nextLine();
		

		Date hoje = GregorianCalendar.getInstance().getTime();
		SimpleDateFormat formata = new SimpleDateFormat("h:mm - a");
		hora = formata.format(hoje);
		
		

		Date dataAtual = new Date();
		formata = new SimpleDateFormat("HH:mm");
		formata.setLenient(false);

		try {
			dataAtual = formata.parse(horarioInformado);
			Date hora11 = formata.parse("11:00");
			Date hora13 = formata.parse("13:00");
			Date hora18 = formata.parse("18:00");
			Date hora7 = formata.parse("7:00");
			
			if ((new Date()).getTime() < dataAtual.getTime()) {
				setHorario(horarioInformado);

			} else if ((new Date()).getTime() >= dataAtual.getTime() || ((hora11e30).getTime() < dataAtual.getTime()) && ((hora13).getTime() > dataAtual.getTime())){
				System.out.println("Não é possivel marcar consultas neste horário, informe outro horário!");
				System.out.println("");
				verificaHoras();
			}
		} catch (ParseException e) {
			System.out.println("Você informou um horário inválido!");
			System.out.println("");
			verificaHoras();
			return false;
		}
		return true;
	}
	
}
