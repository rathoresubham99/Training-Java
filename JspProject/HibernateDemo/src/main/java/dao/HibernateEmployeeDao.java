package dao;

import org.springframework.stereotype.Repository;

import model.Employee;

@Repository("/hibernateDao")
public class HibernateEmployeeDao implements EmployeeDao{
	
	public boolean add(Employee e){
		return false;
	}

}
