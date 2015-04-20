package br.com.uniciss.imobiliaria.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Agendamento {

	ArrayList<Agendamento> listaVisitas = new ArrayList<Agendamento>();
	Map<String, Agendamento> mapaVisitas = new HashMap<String, Agendamento>();
	
	ArrayList<Imovel> listaImovel = new ArrayList<Imovel>();
	Map<Integer, Imovel> mapaImovel = new HashMap<Integer, Imovel>();
	
	ArrayList<Corretor> listaCorretor = new ArrayList<Corretor>();
	Map<Integer, Corretor> mapaCorretor = new HashMap<Integer, Corretor>();

	private String nome;
	private String data;
	private String horario;
	private String observa��es;
	private int imovel;
	private int corretor;
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

	public String getObserva��es() {
		return observa��es;
	}

	public void setObserva��es(String observa��es) {
		this.observa��es = observa��es;
	}

	public int getImovel() {
		return imovel;
	}

	public void setImovel(int imovel) {
		this.imovel = imovel;
	}

	public int getCorretor() {
		return corretor;
	}

	public void setCorretor(int corretor) {
		this.corretor = corretor;
	}

	@Override
	public String toString() {
		return "Visita," + nome + "," + data + "," + horario + "," + imovel + "," + corretor + "," + observa��es;
	}

	public void agendarVisita() throws java.text.ParseException {

		LerBanco ler = new LerBanco();
		ler.leituraCorretor(mapaCorretor);
		ler.leituraImovel(mapaImovel);
		
		s = new Scanner(System.in);

		System.out.println("Informe o nome de quem deseja agendar a visita: ");
		setNome(s.nextLine());

		verificaData();

		verificaHoras();
		
		verificaImovel();
		
		verificaCorretor();
		
		System.out.println("Informa��es adicionais: ");
		setObserva��es(s.nextLine());
		
		setObserva��es(s.nextLine());

		GravaTxt g = new GravaTxt();
		g.grava("Visitas.txt", toString());
	}

	private void verificaImovel() throws ParseException {
		System.out.println("Informe o c�digo do im�vel, onde ser� feita a visita: ");
		int codigo = s.nextInt();
		verificaTudo();
		
		if(mapaImovel.containsKey(codigo)){
			setImovel(codigo);
		}else{
			System.out.println("Im�vel informado n�o existe");
			verificaImovel();
		}
		
		
	}

	private void verificaCorretor() throws ParseException {
		System.out.println("Informe o c�digo do corretor, que ir� fazer a visita: ");
		int codigo = s.nextInt();
		verificaTudo();
		
		if(mapaCorretor.containsKey(codigo)){
			setCorretor(codigo);
		}else{
			System.out.println("Corretor informado n�o existe");
			verificaCorretor();
		}
		
	}
	
	public boolean verificaTudo() throws ParseException{
		
		for (Agendamento a : listaVisitas) {
			
			if (a.getHorario().equals(getHorario()) && a.getData().equals(getData()) && a.getCorretor() == getCorretor()) {
				System.out.println("J� h� uma visita agendada para este Corretor, por favor informe outro Corretor!");
				System.out.println("");
				agendarVisita();
			}
			
			if(a.getHorario().equals(getHorario()) && a.getData().equals(getData()) && a.getImovel() == getImovel()){
				System.out.println("J� h� uma visita agendada para este Im�vel, por favor informe outro Im�vel!");
				System.out.println("");
				agendarVisita();
			}
		}
		
		return true;
	}

	@SuppressWarnings("unused")
	public boolean verificaData() {
		LerBanco lb = new LerBanco();
		

		String data;

		System.out.println("Informe o dia da visita: ");
		String dataInformadaString = s.nextLine();

		Date hoje = GregorianCalendar.getInstance().getTime();
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
		data = formata.format(hoje);

		Date dataInformada = new Date();
		formata = new SimpleDateFormat("dd/MM/yyyy");
		formata.setLenient(false);

		try {
			dataInformada = formata.parse(dataInformadaString);

			if ((new Date()).getTime() < dataInformada.getTime()) {
				setData(dataInformadaString);

			} else if ((new Date()).getTime() >= dataInformada.getTime()) {
				System.out.println("N�o � possivel marcar consultas para este dia, informe outra data!");
				System.out.println("");
				verificaData();
			}

		} catch (ParseException e) {
			System.out.println("Voc� informou uma data inv�lida!");
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

		System.out.println("Informe o hor�rio da visita: ");
		String horarioInformado = s.nextLine();

		Date agora = GregorianCalendar.getInstance().getTime();
		SimpleDateFormat formata = new SimpleDateFormat("h:mm - a");
		hora = formata.format(agora);

		Date horaInformada = new Date();
		formata = new SimpleDateFormat("HH:mm");
		formata.setLenient(false);

		try {
			horaInformada = formata.parse(horarioInformado);
			Date hora11 = formata.parse("11:00");
			Date hora13 = formata.parse("13:00");
			Date hora0 = formata.parse("0:00");
			Date hora7 = formata.parse("7:00");
			Date hora23 = formata.parse("23:59");
			Date hora20 = formata.parse("20:00");

			if (((hora11).getTime() < horaInformada.getTime()) && ((hora13).getTime() > horaInformada.getTime()) || ((hora7).getTime() > horaInformada.getTime() && (hora0).getTime() <= horaInformada.getTime()) || (hora20).getTime() < horaInformada.getTime() && ((hora23).getTime() >= horaInformada.getTime())) {
				System.out.println("N�o � possivel marcar consultas neste hor�rio, informe outro hor�rio!");
				System.out.println("");
				verificaHoras();
			} else {
				setHorario(horarioInformado);
			}
			

		} catch (ParseException e) {
			System.out.println("Voc� informou um hor�rio inv�lido!");
			System.out.println("");
			verificaHoras();
			return false;
		}
		return true;
	}

}
