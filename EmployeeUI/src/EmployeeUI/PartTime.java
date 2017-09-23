package EmployeeUI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
public class PartTime extends EmployeeInfo {

    double hourlyWage;
    float hrsPerWeek;
    int weeksPerYear;

    public PartTime(int eNumber, String fName,String mName, String lName, String g, double dRate, double hW, float hPW, int wPY, double nI) {

        employeeNumber = eNumber;
        firstName = fName;
        middleName = mName;
        lastName = lName;
        gender = g;
        deductionRate = dRate;
        hourlyWage = hW;
        hrsPerWeek = hPW;
        weeksPerYear = wPY;
        netIncome = nI;

    }

    

}
