package com.bridgeLabz.EmployeePayroll;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;
import com.bridgeLabz.EmployeePayroll.EmployeePayrollService.IOService;
/**
 * Employee Payroll Service Test to check the file outputs
 * @author Sanjana Rao
 * @since 20-09-2021
 */
public class EmployeePayrollServiceTest 
{
	@Test 
    public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() 
	{
        EmployeePayrollData[] arrayOfEmps= {
                new EmployeePayrollData(1," Jeff Bezos",100000.0),
                new EmployeePayrollData(2,"Bill Gates",200000.0),
                new EmployeePayrollData(3,"Mark Zuckerberg",300000.0)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService =new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
        long entries=employeePayrollService.countEntries(IOService.FILE_IO);
        assertEquals(3,entries);
	}
}
