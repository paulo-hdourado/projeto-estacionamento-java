package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.time.Duration;

public class Patio {
	private Map<String, Ticket> vagasOcupadas;
	private double precoPorHora;

	public Patio() {
		this.vagasOcupadas = new HashMap<>();
		this.precoPorHora = 5;
	}

	public Map<String, Ticket> getVagasOcupadas() {
		return vagasOcupadas;
	}

	public void setVagasOcupadas(Map<String, Ticket> vagasOcupadas) {
		this.vagasOcupadas = vagasOcupadas;
	}

	public double getPrecoPorHora() {
		return precoPorHora;
	}

	public void setPrecoPorHora(double precoPorHora) {
		this.precoPorHora = precoPorHora;
	}

	// ---------------------------------------------------------------------------------------------------------------

	// Método Para registrar a entrada do veículo
	public void registrarEntrada(Veiculo veiculo) {

		// Pega a placa do veículo
		String placa = veiculo.getPlaca();

		// Caso o a busca usando a placa seja diferente de null, ou seja já a um veiculo
		// com a mesma placa no pátio
		if (vagasOcupadas.get(placa) != null) {
			System.out.println("O veículo já encontra-se registrado no pátio. \n");
			//System.out.println(vagasOcupadas.get(placa));
			return;
		}

		// Se a placa passada como chave no map retornar null
		// Cria-se um novo objeto Ticket passando veiculo como argumento
		Ticket tkt = new Ticket(veiculo);

		// Registra o veiculo no pátio
		vagasOcupadas.put(placa, tkt);

		System.out
				.println("Entrada registrada par o Veículo: " + veiculo.getModelo() + " Placa: " + veiculo.getPlaca());
	}

	// ---------------------------------------------------------------------------------------------------------------

	public double registrarSaida(String placa) {
		
		if(vagasOcupadas.get(placa) == null) {
			System.out.println("Veículo com a placa: " + placa + " não localizado.");
			return 0;
		}
		
		Ticket tkt = vagasOcupadas.get(placa);
		tkt.setHoraSaida(LocalDateTime.now());
		
		
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
		
		LocalDateTime horarioEntrada = tkt.getHoraEntrada(); 
		LocalDateTime horarioSaida = tkt.getHoraSaida();
		
		
		System.out.println("Entrada: " + horarioEntrada.format(formatoData) + " às " + horarioEntrada.format(formatoHora));
		System.out.println("Saida: " + horarioSaida.format(formatoData) + " às " + horarioSaida.format(formatoHora));
		
		Duration duracao = Duration.between(horarioEntrada, horarioSaida);
		
		long horas = duracao.toHours();		
		long min = duracao.toMinutes();
		long minRestantes = min % 60;
		
		System.out.println(horas + "h " + minRestantes + "min \n");
		
		
		double horasEmMinutos = ((horas * 60) + minRestantes);
		double minEmHoras = (horasEmMinutos / 60);
		
		vagasOcupadas.remove(placa);
		
		
		return Math.ceil(minEmHoras) * this.precoPorHora ;
	}

}
