package tw.hibernatedemo.action;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoDepartmentActionEx4 {

	public static void main(String[] args) {
	         SessionFactory factory   = HibernateUtil.getSessionFactory();
                Session session = factory.getCurrentSession();
                
                
                try {
                	session.beginTransaction();
                	
                	Department tempDept = session.get(Department.class, 51);
                	
                	if(tempDept != null) {
                		
                		System.out.println("ID: "+tempDept.getDepartmentId()+"Name:　"+tempDept.getDepartmentName());
                	}
                	session.getTransaction().commit();
                	
                }catch(Exception e) {
                	session.getTransaction().rollback();
                	System.out.println("Something Wrong and ROLLBACK!!");
                }finally {
                	HibernateUtil.closeSessionFactory();
                }
	}

}
