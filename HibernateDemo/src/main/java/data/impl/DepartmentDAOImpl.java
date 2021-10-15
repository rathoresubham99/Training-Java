package data.impl;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import data.DepartmentDAO;
import model.Department;
import model.Employee;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public int add(Department dept) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=(Transaction) session.beginTransaction();
		Employee e1=new Employee("Subham","123454","M");
		Employee e2=new Employee("Subham","123654","M");
		Set<Employee> empSet=new HashSet<Employee>();
		empSet.add(e1);
		empSet.add(e2);
		dept.setEmployees(empSet);
		
		int rowsAdded=(int) session.save(dept);
		tx.commit();
		return rowsAdded;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		if(!session.getTransaction().isActive())
			session.beginTransaction();
		Query<Department> query=session.createQuery("from Department",Department.class);
		List<Department> deptList=query.list();
		for(Department dept:deptList){
			System.out.println("Employee working in dept: " +dept.getDeptName());
			for(Employee emp:dept.getEmployees())
				System.out.println(emp.getEmpName());
		}
		return query.list();
	}

	

}
