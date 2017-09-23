package EmployeeUI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
public class FullTime extends EmployeeInfo {
    
    double yearlySalary;
    
   public FullTime(int eNumber, String fName, String mName, String lName, String g, double dRate, double aS, double nI) {

        employeeNumber = eNumber;
        firstName = fName;
        middleName = mName;
        lastName = lName;  
        gender = g;
        deductionRate = dRate;
        yearlySalary = aS;
        netIncome = nI;
       
     
    }

   

}
