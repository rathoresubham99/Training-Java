package org.impelsys.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import model.BankAccount;

public class BankAccountDAOImpl {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveOrUpdate(BankAccount bankAccount){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(bankAccount);
		tx.commit();
		session.close();
		
	}
	
	public boolean delete(BankAccount bankAccount){
		return true;
	}
	
	public List<BankAccount> getAllBankAccounts(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query<BankAccount> query = session.createQuery("from BankAccount",BankAccount.class);
		List<BankAccount> listAccounts = query.list();
		return listAccounts;
		
	}
}
