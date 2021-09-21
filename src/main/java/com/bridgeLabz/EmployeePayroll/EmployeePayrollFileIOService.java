package com.bridgeLabz.EmployeePayroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
/**
 * Employee Payroll File IO Service to Read and Write Employee Payroll to a File
 * @author Sanjana Rao
 * @since 20-09-2021
 */
public class EmployeePayrollFileIOService 
{
	public static final String PAYROLL_FILE_NAME="C:\\Users\\sanjana.rao_ymediala\\eclipse-workspace\\EmployeePayroll\\src\\main\\java\\com\\bridgeLabz\\EmployeePayroll\\payroll-file.txt";
    public void writeData(List<EmployeePayrollData> employeePayrollList) 
    {
        StringBuffer empBuffer=new StringBuffer();
        employeePayrollList.forEach(employee->{
            String employeeDataString=employee.toString().concat("\n");
            empBuffer.append(employeeDataString);     
        });
        try 
        {
            Files.write(Paths.get(PAYROLL_FILE_NAME),empBuffer.toString().getBytes());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public long countEntries() 
    {
        long entries=0;
        try 
        {
            entries=Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return entries;
    }
}