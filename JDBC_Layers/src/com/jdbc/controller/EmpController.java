package com.jdbc.controller;

import java.util.ArrayList;

import com.jdbc.model.Emp;
import com.jdbc.model.EmpOper;

public class EmpController
{

	public static boolean addEmployee(int eno,String nam,String job,float sal,int dno)
	{
		Emp e=new Emp(eno,nam,job,sal,dno);
		if(EmpOper.addEmployee(e))
			return true;
		else
			return false;
		
	}
	public static boolean deleteByEmpno(int empno) {
		if(EmpOper.deleteByEmpno(empno)) {
			return true;
		}
		else {
			return false;
		}
			
	}
	public static boolean updateBySalEmpno(int empno, float newsal)
	{
		Emp emp = new Emp();
		emp.setEmpno(empno);
		emp.setSal(newsal);
		if(EmpOper.updateSalByEmpno(emp))
			return true;
		else
			return false;
	}
	public static ArrayList<Emp> showByEmpno(int eno)
	{
		ArrayList<Emp> arrayList = new ArrayList<Emp>();
		arrayList = EmpOper.showByEmpno(eno);
		return arrayList;
	}
	public static ArrayList<Emp> showAllEmployees()
	{
		ArrayList<Emp> arr=new ArrayList<Emp>();
		arr=EmpOper.showAllEmployees();
		return arr;
		
	}
}
