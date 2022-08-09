package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter contract data: ");
		System.out.print("Number:");
		Integer number = ler.nextInt();
		System.out.print("Date (dd/MM/yyyy) : ");
		Date date = sdf.parse(ler.next());
		System.out.print("Contract value: ");
		double totalValue = ler.nextDouble();

		Contract contract = new Contract(number, date, totalValue);

		System.out.print("Enter number of installments: ");
		int months = ler.nextInt();
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, months);
		
		System.out.println("INSTALLMENTS");
		for(Installment it : contract.getInstallments()) {
			System.out.println(it);
		}
		System.out.println();
		ler.close();
	}

}
