package org.impelsys.data.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.impelsys.data.EmployeeDao;
import org.impelsys.data.model.Employee;
import org.impelsys.data.model.Project;

@Component("hibernateDao")
@Transactional
//@Repository("hibernateDao")
public class HibernateEmployeeDaoImpl implements EmployeeDao{
	
	private static final List<Employee> ArrayList = null;


	@Autowired
	SessionFactory sessionFactory;
	Transaction tx=null;
	
	public void assignEmployeeProjects()
	{
		List<Employee> empList = getEmployeeList();
		List<Project> projectsList = new ArrayList();
		for(int i=1;i<3 ;i++)
		{
			Project p = new Project();
			p.setProjectName("Projects" + i);
			p.setProjectLead("ProjectLead"+i);
			projectsList.add(p);
		}
		//Session session =sessionFactory.getCurrentSession();
		Session session =sessionFactory.openSession();
		//transaction tx = null;
		if(!session.getTransaction().isActive()){
			tx=session.beginTransaction();
			System.out.println("Transaction begin");
		}
		if(empList!=null){
			System.out.println("At Assign projects");
			for(Employee emp : empList){
				emp.setProjectsList(projectsList);
				session.saveOrUpdate(emp); 
			}
		}
		if(tx!=null && tx.isActive()){
			System.out.println("At commit in assignEmployeeProject");
		tx.commit();
		}
		session.close();
	}

	public int addEmployee(Employee emp)//emp is in TRANSIENT state
	{  
		System.out.println("Adding employee (in HibernateDao)");
		Session session=null;
		Integer id;
		try
		{	
			//SessionFactory sf=HibernateUtil.getSessionFactory();	
			session =sessionFactory.openSession();
			tx=session.beginTransaction();
			id = (Integer)session.save(emp);  //insert an employee record in db //emp is in PERSISTENT state
			tx.commit(); //only the changes are persisted to database
			return id;
		
		}
		catch (Exception e)
		{
			tx.rollback();
			return 0;
		}
		finally
		{
			if(session!=null)
				session.close();           //emp is in DETACHED state
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(emp);
			session.getTransaction().commit();
			session.close();
		}
		
	}
	
	@Override
	public boolean delete(Employee emp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx=null;
		tx=session.beginTransaction();
		//session.delete(arg0);
		return EmployeeDao.super.delete(emp);
	}
	
	

	@Override
	public int updateEmployeeDepartment(Employee emp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
//		Query query = session.createQuery("update Employee where empId=:i");
//		Query<Employee> query = session.createQuery("update Employee set department=:d where empId=:i");
////		query.setParameter("d",emp.getDepartment().getDeptId());
//		query.setParameter("d",emp.getDepartment());
//		query.setParameter("i", emp.getEmpId());
//		int status = query.executeUpdate();
		session.getTransaction().commit();
		return 0;
	}

	@Override
	public Employee getEmployees(int empId) {
		Session session = sessionFactory.openSession();  //session is not thread safe object
		
		Employee emp = session.get(Employee.class,new Integer(empId));            //PERSISTENT state
		//empList.add(emp);
		System.out.println("Employee get() called");
		System.out.println("Employee ID: "+ emp.getEmpId());
		System.out.println("Employee details : "+ emp);
		
		Employee emp1 = session.load(Employee.class,new Integer(3));            //PERSISTENT state
		//empList.add(emp);
		System.out.println("Employee load() called");
		System.out.println("Employee ID: "+ emp1.getEmpId());
		System.out.println("Employee details : "+ emp1);
		session.close();
		return emp;
	}

	@Override
	public Long getEmployeesCount() 
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String totalCountQuery = "Select count(e.empId) from Employee e";
		Query qry = session.createQuery(totalCountQuery);
		List<Employee> empList = qry.list();
		Long resultCount = (Long)qry.uniqueResult();
		return resultCount.longValue();
	}
	
	@Override
	public List<Employee> getEmployeeList(int from,int noOfRows) 
	{
		Session session = sessionFactory.getCurrentSession();
		if(!session.beginTransaction().isActive());
		Query<Employee> query = session.createQuery("from Employee",Employee.class);
		query.setFirstResult(from);
		query.setMaxResults(noOfRows);
		List<Employee> empList = query.list();
		return empList;
		
	}
	@Override
	public List<Employee> getEmployeeList() 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
			//if(!session.getTransaction().isActive())
		session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cQuery = cb.createQuery(Employee.class);
		
		Root <Employee> root =  cQuery.from(Employee.class);
		cQuery.select(root); //
		TypedQuery<Employee> qry = session.createQuery(cQuery);
		List<Employee> empList =  qry.getResultList();
		session.getTransaction().commit();
		//session.getTransaction().commit();
		return empList;
	}

	
	
	@Override
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//CRITERAI API
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.gt("salary",5000));
		session.getTransaction().commit();
		return criteria.list();
		
	}

	@Override
	public List<Integer> getDistinctSalary() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		
		criteria.add(Restrictions.between("salary",5000,30000));
		criteria.setProjection(Projections.distinct(Projections.property("salary")));
		return criteria.list();
		//return EmployeeDao.super.getDistinctSalary();
	}


}
