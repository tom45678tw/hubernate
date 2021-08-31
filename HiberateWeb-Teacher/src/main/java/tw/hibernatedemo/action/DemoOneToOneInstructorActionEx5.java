package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetaill;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneInstructorActionEx5 {
 //Jery 回學校了 要把 detail加回去
	public static void main(String[] args) {
		
	
     SessionFactory factory = HibernateUtil.getSessionFactory();
	   Session session = factory.getCurrentSession();
	   
	   try {
		   session.beginTransaction();
           
		   //找到 instructor物件
		   int theInstructorId =3;
		   Instructor tempInstructor = session.get(Instructor.class, theInstructorId);
		   
		    //new Detail
		   InstructorDetaill detail = new InstructorDetaill();
		   detail.setEmail("jerry@gmail.com");
		   detail.setPhone("454646546");
		   session.save(detail);
		   
		   //instructor setting detail
		   tempInstructor.setInsturctorDetail(detail);
		   
		   session.getTransaction().commit();
	   }catch(Exception e) {
		   session.getTransaction().rollback();
		   System.out.println("交易失敗,資料已返回");
		 
	   }finally {
		HibernateUtil.closeSessionFactory();
	}
	}

}
