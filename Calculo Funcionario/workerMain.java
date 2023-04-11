import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Department;
import Entities.HourContract;
import Entities.Worker;
import EntitiesEnums.WorkerLevel;

public class workerMain{

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName,WorkerLevel.valueOf(workerLevel),baseSalary, new Department(departmentName));
		
		System.out.println("How Many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract #" + i + " date:");
			System.out.print("Date (DD/MM/YYYY) ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double vlPerHour = sc.nextDouble();
			System.out.print("Durantion (hours): ");
			int hour = sc.nextInt();
			HourContract contract = new HourContract(contractDate, vlPerHour, hour);
			worker.addContract(contract);
		}
		
		System.out.print("Enter month and the year to calculate income (MM/YYYY): ");
		String monthYear = sc.next();
		int month = Integer.parseInt(monthYear.substring(0,2));
		int year = Integer.parseInt(monthYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
		
		
	}
}
