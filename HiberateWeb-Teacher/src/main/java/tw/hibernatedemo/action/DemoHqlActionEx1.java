package tw.hibernatedemo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.hibernatedemo.model.Employee;

import tw.hibernatedemo.util.HibernateUtil;

public class DemoHqlActionEx1 {

	public static void main(String[] args) {

		 DemoHqlActionEx1 demo = new DemoHqlActionEx1();
		
		 demo.hqlSelectQueryBySalaryVacction(100000, 10);
	}
    private void hqlSelectAll() {
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


  private void hqlselectctory() {
	  //找出薪水3萬以上,假期10天以上的人
	  SessionFactory factory = HibernateUtil.getSessionFactory();
  	Session session = factory.getCurrentSession();
  	
  	try {
  		session.beginTransaction();
  		String hql="from Employee e where e.salary > 30000 and e.vacation > 10";
//  	    String hql = "from Employee e where e.salary > 30000 and e.vacation >10";
  		Query<Employee> query2 = session.createQuery(hql,Employee.class);
          List<Employee> list2 = query2.getResultList();
          
          for(Employee emp:list2) {
        	  System.out.println(emp);
          }
  		session.getTransaction().commit();
  		
  	}catch(Exception e) {
  		session.getTransaction().rollback();
  		System.out.println("交易失敗,資料即將返回");
  	}finally {
  		HibernateUtil.closeSessionFactory();
  	}
  }

   private void hqlSelectQueryBySalaryVacction(int salary,int vacation) {
	   SessionFactory factory = HibernateUtil.getSessionFactory();
	  	Session session = factory.getCurrentSession();
	  	
	  	try {
	  		session.beginTransaction();
	  		String hql="from Employee e where e.salary > :salaryNumber and e.vacation > :vacationNumber";
//	  	    String hql = "from Employee e where e.salary > 30000 and e.vacation >10";
	  		Query<Employee> query2 = session.createQuery(hql,Employee.class).setParameter("salaryNumber",salary).setParameter("vacationNumber", vacation);
	          List<Employee> list2 = query2.getResultList();
	          
	          for(Employee emp:list2) {
	        	  System.out.println(emp);
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