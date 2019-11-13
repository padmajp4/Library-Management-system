package com.adjava;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class LoginModel {
	
	SessionFactory factory;
	
	public LoginModel()
	{
		Configuration config=new Configuration().configure();
		factory=config.buildSessionFactory();
	}
	
	
	public String check(Login obj)
	{
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		Query<Login> q=s.createQuery("select name,pwd from Login where name=?0 and pwd=?1 ");
		q.setParameter(0,obj.name);
		q.setParameter(1,obj.pwd);
		List<Login> li=q.list();
		if(li.size()>0)
		{
			if((obj.name.equals("admin"))&& (obj.pwd.equals("admin")))
			{
				return "adminbook";
			}
			else
			{
				return"login";
			}
		}
		else
			return "login";
		
	}
	
	public void insertValues(Login r) {
		Session sess=factory.openSession();
		System.out.println(r.getName());
		Transaction tx=sess.beginTransaction();
		sess.save(r);
		tx.commit();
		sess.close();
	}
	public void insertBook(Book b)
	{
		Session sess=factory.openSession();
		System.out.println(b.getBookname());
		Transaction tx=sess.beginTransaction();
		sess.save(b);
		tx.commit();
		sess.close();	
	}
	
	public void deleteBook(Book b)
	{
		Session sess=factory.openSession();
		System.out.println(b.getBookname());
		Transaction tx=sess.beginTransaction();
		Query<Book>q=sess.createQuery("delete from Book where bookname=:a");
		q.setParameter("a", b.getBookname());
		q.executeUpdate();
		//sess.delete(c);
		tx.commit();
		sess.close();
	}
	
	public List<Book>bookdetails(Book d)
	{
		Session sess=factory.openSession();
		Transaction tx=sess.beginTransaction();
		Query<Book>qq=sess.createQuery("from Book");
		List<Book>lii=qq.list();
		return lii;
	}
	
	public List<Book>userbookdetails(Book d)
	{
		Session sess=factory.openSession();
		Transaction tx=sess.beginTransaction();
		Query<Book>qq=sess.createQuery("from Book");
		List<Book>liii=qq.list();
		return liii;
	}
	
	public String searchbook(Book b)
	{
		/*String msg;*/
		Session sess=factory.openSession();
		Transaction tx=sess.beginTransaction();
		Query<Book>q=sess.createQuery("from Book where bookname=:a");
		q.setParameter("a",b.getBookname());
		List<Book>li=q.getResultList();
		System.out.println(li.size());
		if(li.size()>0)
		{
			return "available";
		}
		else
		{
		/*msg="available";*/
			/*return msg;*/
			return "unavailable";
			
		}
	}
	
}
