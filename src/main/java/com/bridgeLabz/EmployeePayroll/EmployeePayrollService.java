package com.bridgeLabz.EmployeePayroll;

import java.util.*;
/**
 * Employee Payroll Service to Read and Write Employee Payroll to a Console
 * @author Sanjana Rao
 * @since 20-09-2021
 */
public class EmployeePayrollService {
	
	public enum IOService
	{
		CONSOLE_IO,
		FILE_IO,
		DB_IO,
		REST_IO
	}
	
	private List<EmployeePayrollData> employeePayrollList;
	
	public EmployeePayrollService()
	{
		System.out.println("Welcome to Employee Payroll Service.");
	}
	/**
     * To create Employee Payroll Class of id, name and Salary
     * @param employeePayrollList list containing id, name and salary
     */
	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList)
	{
		this.employeePayrollList = employeePayrollList;
	}
	/**
     * This method reads the information from the Console
     * @param consoleInputReader is the console input reader
     */
	private void readEmployeePayrollData(Scanner consoleInputReader)
	{
		System.out.println("Enter employee ID: ");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter employee name: ");
		String name = consoleInputReader.next();
		System.out.println("Enter employee salary: ");
		double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}
	/**
     * This method writes the Employee Payroll to the Console or to the file
     */
	public void writeEmployeePayrollData(IOService ioService) 
	{
		if(ioService.equals(IOService.CONSOLE_IO))
        {
            System.out.println("\n Writing Employee Payroll Roaster to Console\n"+ employeePayrollList);   
        }
        else if(ioService.equals(IOService.FILE_IO))
        {
            new EmployeePayrollFileIOService().writeData(employeePayrollList);
        }
	}
	
	public long countEntries(IOService ioService)
	{  
        return new EmployeePayrollFileIOService().countEntries();
    }
	
	 public void printData()
	  {
	      new EmployeePayrollFileIOService().printData();
	  }

	public static void main(String[] args) 
	{
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(consoleInputReader);
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		employeePayrollService.printData();
		System.out.println("The number of entries in the file are: " + employeePayrollService.countEntries(IOService.FILE_IO));
		consoleInputReader.close();
	}
}
