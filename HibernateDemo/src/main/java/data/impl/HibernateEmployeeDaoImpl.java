package data.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import data.EmployeeDao;
import model.Employee;
import model.Project;
import util.HibernateUtil;

@Repository("hibernateDao")
public class HibernateEmployeeDaoImpl implements EmployeeDao{
	
	private static final List<Employee> ArrayList = null;


	@Autowired
	SessionFactory sessionFactory;
	
	public void assignEmployeeProjects(){
		List<Employee> empList=getEmployeeList();
		List<Project> projectsList=new ArrayList();
		
		for(int i=1;i<3;i++){
			Project p=new Project();
			p.setProjectName("Project: "+i);
			p.setProjectLead("projectLead :" +i ); 
			projectsList.add(p);
		}
		
		
		Session session =sessionFactory.openSession();
		Transaction tx=null;
		if(!session.getTransaction().isActive()){
			tx=session.beginTransaction();
			System.out.println("Transaction Begin....");
		}
		
		if(empList!=null){
			System.out.println("At Assign Project!");
			for(Employee emp:empList){
				emp.setProjectsList(projectsList);
				session.saveOrUpdate(emp);
			}
			if(tx!=null && tx.isActive()){
				System.out.println("At Commit...");
				tx.commit();
			}
			session.close();
		}
		//tx.commit();
		
	}
//	
//	public void assignEmployeeProjects(){
//		List<Employee> empList= getEmployeeList();
//		List<Project> projectsList=new ArrayList();
//		for(int i=1;i<3;i++){
//			Project p=new Project();
//			p.setProjectName("Project: "+i);
//			projectsList.add(p);
//		}
//		
		
//		Session session =sessionFactory.openSession();
//		Transaction tx=session.beginTransaction();
//		
//		if(empList!=null){
//			for(Employee emp:empList){
//				emp.setProjectsList(projectsList);
//				session.save(emp);
//			}
//		}
//		tx.commit();
//		session.close();
//	}
	
	Transaction tx=null;
	
	public int addEmployee(Employee emp){
	
		System.out.println("Adding employee (in HibernateDao!!)");
		Session session=null;
		Integer id;
		Transaction tx=null;
		try{
			
		//SessionFactory sf=HibernateUtil.getSessionFactory();
			
		session =sessionFactory.openSession();
		tx=session.beginTransaction();
		
		id = (Integer)session.save(emp);  //insert an employee record in db,emp is in persistent state
		//session.save(emp);
		tx.commit(); //only the changes are persisted to database
		session.close();
		return id;
	}catch (Exception e){
		tx.rollback();
		return 0;
	}
		finally{
			if(session!=null)
			session.close();//emp is detached
		}
		
	}
	
	@Override
	public boolean delete(Employee e) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.delete(e);
		tx.commit();
		session.close();
		return false;
	}
	
	@Override
	public int updateEmployeeDepartment(Employee emp) {
		//Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		//session.beginTransaction();
		Query<Employee> query = session.createQuery("update Employee set dept=:d where empId=:i");
		//query.setParameter("d",emp.getDept().getDeptId());
		query.setParameter("d",emp.getDept());
		query.setParameter("i",emp.getEmpId());
		int status = query.executeUpdate();
		//session.getTransaction().commit();
		return status;
	}
	
//------------------------To Fetch Details-----------make changes-----------//
	@Override
	public List<Employee> getEmployees(int empId) {
		
		// TODO Auto-generated method stub
		List <Employee> empList = new ArrayList();
		
		Session session = sessionFactory.openSession(); //Session is not thread safe
	
		Employee emp = session.get(Employee.class,new Integer(empId));
		empList.add(emp);
		
		session.close();
		
		return empList;
	}
 
	

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		//return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		
		Session session = sessionFactory.getCurrentSession();
		//Criteria API
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		
		session.getTransaction().commit();
		return criteria.list();
		
		
	}
	
	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		//return EmployeeDao.super.getEmployeeList();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//if(!session.getTransaction().isActive())
		//session.beginTransaction();
		//Query query = session.createQuery("from Employee");// table name
		//query.setFirstResult(5);//start from the 5th row of the table
		//query.setMaxResults(5);//results from the 5th row and other 5 rows result
		
		//New JPA Criteria API which is used to be used instead of deprecated Hibernate Criteria API
		CriteriaBuilder cb=session.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<Employee> cQuery=(javax.persistence.criteria.CriteriaQuery) cb.createQuery(Employee.class);
		Root<Employee> root=cQuery.from(Employee.class);
		cQuery.select(root);
		TypedQuery<Employee> qry=session.createQuery(cQuery);
		List<Employee> empList = qry.getResultList();
		
		//String totalCountQuery = "Select count(e.empId) from Employee e";//Not the table name and the col name
		//Query qry = session.createQuery(totalCountQuery);
		System.out.println("EmpList.........");
		//session.get(Employee.class);
		//List<Employee> empList = query.list();
		//List<Employee> empList = session.get(Employee.class);
		//int resultCount = (int) qry.uniqueResult();	
		return empList;
	}

	@Override
	public List<Integer> getAllDistinctSalary() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		//Criteria API
		Criteria criteria = session.createCriteria(Employee.class);
		
		criteria.add(Restrictions.gt("salary", 15000));
		//List totalSal = criteria.list();
		
		
		//criteria.add(Restrictions.between("salary",20000,30000)); //21000, 24000, 25000
		criteria.setProjection(Projections.distinct(Projections.property("salary")));
		//criteria.setProjection(Projections.sum("salary"));
		return criteria.list();
	}

	@Override
	public Long getEmployeesCount() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String totalCountQuery="Select count(e.empId) from Employee e";//not the table name...class name
		Query qry=session.createQuery(totalCountQuery);
		List<Employee> empList=qry.list();
		Long resultCount=(Long)qry.uniqueResult();
		return (long) resultCount.intValue() ;
	}

	@Override
	public List<Employee> getAllEmployees(int from,int noOfRows){
		Session session = sessionFactory.getCurrentSession();
		if(!session.getTransaction().isActive())
		session.beginTransaction();
		Query<Employee> query=session.createQuery("from Employee",Employee.class);
		/*ScrollableResults scrollableResultSet=query.scroll();
		 scrollableResultSet.first();*/
		query.setFirstResult(from);
		query.setMaxResults(noOfRows);
		System.out.println("Fetching records from :"+from);
		List<Employee> empList=query.list();
		return empList;
		
	}

	

	@Override
	public int update(Employee emp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if(!session.getTransaction().isActive())
		   session.beginTransaction();
			Query query = session.createQuery("update Employee set empName=:n, empPhoneNum=:p where empId=:i");
			query.setParameter("n","Nitesh");
			query.setParameter("p", "34567890");
			query.setParameter("i",1);
			int status = query.executeUpdate();
			session.getTransaction().commit();
			return status;
	
	}

	
}
