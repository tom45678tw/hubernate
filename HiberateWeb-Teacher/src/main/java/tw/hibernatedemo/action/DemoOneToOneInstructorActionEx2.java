package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneInstructorActionEx2 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int theId =3;
			Instructor tempInstructor = session.get(Instructor.class,theId);
			
			System.out.println("拿到的 Insttructor: "+tempInstructor.getName());
			  if(tempInstructor != null) {
				  System.out.println("正要刪除: "+tempInstructor.getName());
				  //也會刪除 detail, 因為有設置連動 casecadeType ALL
				  session.delete(tempInstructor);
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
