package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetaill;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneInstructorActionEx3 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//實作雙向對應: 用 Detail 找到 instructor
			int theId =105;
			
			InstructorDetaill detail = session.get(InstructorDetaill.class, theId);
			
			if(detail != null) {
				System.out.println(detail.getInstructor().getName());
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
