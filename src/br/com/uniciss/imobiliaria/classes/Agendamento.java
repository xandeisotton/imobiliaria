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
		return "Visita," + nome + "," + data + "," + horario + ","
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
		LerBanco lb = new LerBanco();
		lb.leituraVisitas(mapaVisitas);

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
				System.out
						.println("Não é possivel marcar consultas para este dia, informe outra data!");
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

		LerBanco lb = new LerBanco();
		lb.leituraVisitas(mapaVisitas);

		s = new Scanner(System.in);
		String hora;

		System.out.println("Informe o horário da visita: ");
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

			if (((hora11).getTime() < horaInformada.getTime())
					&& ((hora13).getTime() > horaInformada.getTime())
					|| ((hora7).getTime() > horaInformada.getTime() && (hora0)
							.getTime() <= horaInformada.getTime())
					|| (hora20).getTime() < horaInformada.getTime()
					&& ((hora23).getTime() >= horaInformada.getTime())) {
				System.out
						.println("Não é possivel marcar consultas neste horário, informe outro horário!");
				System.out.println("");
				verificaHoras();
			} else {
				setHorario(horarioInformado);
			}

			if (mapaVisitas.containsKey(getData() + "" + getHorario())) {
				System.out
						.println("Já há uma visita agendada para este horário, por favor informe outro horario!");
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
