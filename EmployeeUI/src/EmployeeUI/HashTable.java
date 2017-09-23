package EmployeeUI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class HashTable {

    int k;
    ArrayList<EmployeeInfo> buckets[];
    
    @SuppressWarnings("unchecked")
    public HashTable(int k) {

        this.k = k;
        buckets = new ArrayList[k];

        for (int l = 0; l < k; l++) {

            buckets[l] = new ArrayList<>();

        }

    }
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   //adds the employee to the hashtable 
    void add(EmployeeInfo employee) {

        buckets[(employee.employeeNumber) % k].add(employee);

    }
// Searches for the employee in the hashtable/db
    EmployeeInfo search(int eN) {

        boolean found = false;
        int index = eN % k;
        int bucketSize = buckets[index].size();
        for (int g = 0; g < bucketSize; g++) {

            if (eN == buckets[index].get(g).employeeNumber) {
                found = true;
                return buckets[index].get(g);
            }

        }
        if (found == false) {

            return null;
        }
        return null;

    }    
//------------------------------------------------------------------------------------------------------------------------------------------------
  // Deletes the specified employee from the hashtable/db
    EmployeeInfo delete(int eN) {

        int index = eN % k;
        int bucketSize = buckets[index].size();
        for (int g = 0; g < bucketSize; g++) {

            if (eN == buckets[index].get(g).employeeNumber) {

                System.out.println((buckets[index].get(g)).firstName + " " + buckets[index].get(g).lastName + ")  removed.");

                return (buckets[index].remove(g));
            }
        }
        return null;
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  //loads hashtable from database
    void open(String fileName) throws IOException {
        try (Scanner db = new Scanner(new File(fileName))) {
            while (db.hasNextLine()) {
                String row = db.next();   
                if (row.equals("1")) {  
                        int eNumber = Integer.parseInt(db.next());
                        String firstName = db.next();
                        String middleName = db.next();
                        String lastName = db.next();
                        String gender = db.next();
                        Double deductionRate = Double.parseDouble(db.next());
                        Float hoursPerWeek = Float.parseFloat(db.next());
                        Double hourlyWage = Double.parseDouble(db.next());
                        int weeksPerYear = Integer.parseInt (db.next());
                        Double netIncome = Double.parseDouble(db.next());
                        PartTime tempEmployee = new PartTime(eNumber, firstName, middleName, lastName, gender, deductionRate, hourlyWage, hoursPerWeek ,weeksPerYear,  netIncome);                      
                        add(tempEmployee);                                    
                } else {
                    if (row.equals("2")) {                                           
                        int eNumber = Integer.parseInt(db.next());
                        String firstName = db.next();
                        String middleName = db.next();
                        String lastName = db.next();
                        String gender = db.next();
                        Double deductionRate = Double.parseDouble(db.next());
                        Double yearlySalary = Double.parseDouble(db.next());
                        Double netIncome = Double.parseDouble(db.next());
                        FullTime tempEmployee = new FullTime(eNumber, firstName,middleName, lastName, gender, deductionRate, yearlySalary, netIncome);                      
                        add(tempEmployee);                                             
                    }
                }
            }
        } catch (java.util.NoSuchElementException ex){
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  // Saves the hashtable to the database
    void save(String fileName) throws IOException {
        try (PrintWriter db = new PrintWriter(fileName, "UTF-8")) {
            for (int i = 0; i < k; i++) {
                int bucketSize = buckets[i].size();
                for (int g = 0; g < bucketSize; g++) {
                    if (buckets[i].get(g) instanceof PartTime) {
                        PartTime ptEmp;
                        ptEmp = (PartTime) buckets[i].get(g);
                        db.println("1 " + (Integer.toString(ptEmp.employeeNumber)) + " " + ptEmp.firstName+ " " + ptEmp.middleName + " " + ptEmp.lastName + " " + ptEmp.gender + " " + Double.toString(ptEmp.deductionRate) +  " " + Double.toString(ptEmp.hourlyWage) + " "  + Double.toString(ptEmp.hrsPerWeek)  + " " + Integer.toString(ptEmp.weeksPerYear)+ " " + Double.toString(ptEmp.netIncome) );
                    } else {
                        if (buckets[i].get(g) instanceof FullTime) {
                            FullTime ftEmp;
                            ftEmp = (FullTime) buckets[i].get(g);
                            db.println("2 " + (Integer.toString(ftEmp.employeeNumber)) + " " + ftEmp.firstName + " " + ftEmp.middleName +  " " + ftEmp.lastName + " " + ftEmp.gender + " " + Double.toString(ftEmp.deductionRate) + " " + Double.toString(ftEmp.yearlySalary)+ " " + Double.toString(ftEmp.netIncome));
                        }
                    }
                }
            }
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 

}
