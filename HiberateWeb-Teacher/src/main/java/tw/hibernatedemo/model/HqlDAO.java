package tw.hibernatedemo.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.hibernatedemo.util.HibernateUtil;

public class HqlDAO {

	public HqlDAO() {
	
	}
	public void hqlSelectAll() {
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session session = factory.getCurrentSession();
    	
    	try {
    		session.beginTransaction();
    		
    		String hql="from Employee"; //== select* from Employee
    		
    		Query<Employee> query1 = session.createQuery(hql,Employee.class);
    		
    		List<Employee> list1 = query1.getResultList();
    		
    		for(Employee oneEmp:list1) {
    			System.out.println(oneEmp);
    		}
    		session.getTransaction().commit();
    		
    	}catch(Exception e) {
    		session.getTransaction().rollback();
    		System.out.println("交易失敗,資料即將返回");
    	}finally {
    		HibernateUtil.closeSessionFactory();
    	}
    }
}
