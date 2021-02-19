package program;
import entities.Funcionario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Contrato;
import entities.Departamento;
import enums.NivelFunc;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Qual o nome do departamento?");
		String nomeDp = sc.next();

		System.out.println("Dados do trabalhador");

		sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nivel: ");
		String nivel = sc.next();
		System.out.print("Salario Base: ");
		Double salarioBase = sc.nextDouble();

		Funcionario F = new Funcionario(nome, NivelFunc.valueOf(nivel), salarioBase, new Departamento(nomeDp));

		System.out.println(F.toString());
		System.out.println();

		System.out.print("Quantidade contratos? ");
		int numContratos = sc.nextInt();
		
		//Incrementação de contratos
		for (int i = 0; i < numContratos; i++) {
			System.out.println("Contrato #" + (i+1));

			System.out.print("Data de entrada: (DD/MM/YYYY)");
			Date dateContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorHora = sc.nextDouble();
			System.out.print("Duração");
			int duracao = sc.nextInt();

			Contrato c = new Contrato(dateContrato, valorHora, duracao);
			F.addContrato(c);
		}

		System.out.print("Entre com o mes e ano para calcular o ganho: (MM/YYYY)");
		
		String date = sc.next();
		Integer mounth = Integer.parseInt(date.substring(0, 2));
			
		Integer year =  Integer.parseInt(date.substring(3, 7));

		System.out.println(F.toString());
		System.out.println("Valor total ganho neste periodo: " + F.income(mounth, year));


		sc.close();
	}
}
