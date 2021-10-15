package com.jdbc.model;

import java.util.ArrayList;

import com.jdbc.dao.EmpDAO;

public class EmpOper 
{
	public static boolean updateSalByEmpno(Emp obj)
	{
		if(EmpDAO.updateSalByEmpno(obj))
			return true;
		else
			return false;
	}
	public static boolean deleteByEmpno(int empno) {
		if(EmpDAO.deleteByEmpno(empno))
			return true;
		else
			return false;
	}
	public static boolean addEmployee(Emp obj)
	{
		if(EmpDAO.addEmployee(obj))
			return true;
		else 
			return false;
		
	}
	public static ArrayList<Emp> showAllEmployees()
	{
		ArrayList<Emp> arr= EmpDAO.showAllEmployees();
		return arr;
	}
	public static ArrayList<Emp> showByEmpno(int empno)
	{
		ArrayList<Emp> arrayList = EmpDAO.showByEmpno(empno);
		return arrayList;
	}
}
