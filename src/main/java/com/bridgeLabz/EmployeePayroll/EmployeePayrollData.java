package com.bridgeLabz.EmployeePayroll;
/**
 * Employee Payroll Data to get the employee's details
 * @param id takes in Employee ID Number in int format
 * @param name takes in Employee Name
 * @param salary takes Employee's Salary
 * @author Sanjana Rao
 * @since 20-09-2021
 */
public class EmployeePayrollData 
{
	private int id;
	private String name;
	private double salary;
	
	//Constructor
	public EmployeePayrollData(int id, String name, double salary)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	//Display method
	public String toString()
	{
		return id+","+name+","+salary;
	}
}
