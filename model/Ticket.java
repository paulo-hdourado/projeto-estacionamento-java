package model;

import java.time.LocalDateTime;

public class Ticket {
	private Veiculo veiculo; //modelo E placa
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSaida;

	public Ticket(Veiculo veiculo) {
		this.veiculo = veiculo;
		this.horaEntrada = LocalDateTime.now();
		this.horaSaida = null;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalDateTime getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalDateTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	@Override
	public String toString() {
		return "Ticket [veiculo = " + veiculo + ", horaEntrada = " + horaEntrada + ", horaSaida = " + horaSaida + "]";
	}
		
}
