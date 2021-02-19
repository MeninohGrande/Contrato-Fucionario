package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import enums.NivelFunc;

public class Funcionario {

	private String nome;
	private NivelFunc nivel;
	private Double baseSalario;
	private Departamento dp;
	private List<Contrato> contratos = new ArrayList<>();
	
	public Funcionario () {
		
	}

	public Funcionario(String nome, NivelFunc nivel, Double baseSalario, Departamento dp) {
		super();
		this.nome = nome;
		this.nivel = nivel;
		this.baseSalario = baseSalario;
		this.dp = dp;
	}

	public String getNome() {
		return nome;
	}

	public NivelFunc getNivel() {
		return nivel;
	}

	public void setNivel(NivelFunc nivel) {
		this.nivel = nivel;
	}

	public Double getBaseSalario() {
		return baseSalario;
	}

	public Departamento getDp() {
		return this.dp;
	}
	
	public void setDp (Departamento dp) {
		this.dp = dp;
	}
	
	public void addContrato(Contrato contrato) {
		this.contratos.add(contrato);
	}
	
	public void removeContrato(Contrato contrato) {
		this.contratos.remove(contrato);
	}
	
	public void getContrato (int i) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Data de entrada: " + sdf.format(contratos.get(i).getData()));
		System.out.println("Valor por Hora: " + contratos.get(i).getValorHora());
		System.out.println("Horas: " + contratos.get(i).getHora());
	}
	
	public int numContratos() {
		return contratos.size();
	}
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", nivel=" + nivel + ", Salario Base=" + baseSalario + ", Departameneto=" + dp.getNome() + "]";
	}

	public double income(int mes, int ano) {
		Calendar cal = Calendar.getInstance();
		double saldo = 0.0;
		for (Contrato c : contratos) {
			
			cal.setTime(c.getData());
			
			if ( cal.get(Calendar.MONTH) == mes && cal.get(Calendar.YEAR) == ano ) {
				saldo += c.totalGanho();
			}
			
		}
	return saldo + this.baseSalario;
	}
	
	
}
