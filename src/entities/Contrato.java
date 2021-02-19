package entities;
import java.util.Date;

public class Contrato {

	private Date data;
	private Double valorHora;
	private int hora;
	
	public Contrato() {
		
	}

	public Contrato(Date data, Double valorHora, int hora) {
		super();
		this.data = data;
		this.valorHora = valorHora;
		this.hora = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}
	
	public double totalGanho() {
		return valorHora * hora;
	}
	

	
}
