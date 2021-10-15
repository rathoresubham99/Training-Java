package dao;


import org.springframework.stereotype.Repository;

import com.mysql.cj.xdevapi.SessionFactory;

import dao.EmployeeDao;
import model.Employee;

@Repository("hibernateDao")
public class HibernateEmployeeDaoImpl implements EmployeeDao {
	
	public boolean add(Employee e){
		//factory pattern
		//jdbc code
		//driverName,username,pwd,portnum,dbname
		SessionFactory sf=
		save(e);//insert employee record in db
		return false;
	}
	

}