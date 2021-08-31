package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetaill;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneInstructorActionEx4 {
   public static void main(String[] args) {
	


     SessionFactory factory = HibernateUtil.getSessionFactory();
	   Session session = factory.getCurrentSession();
	   
	   try {
		   session.beginTransaction();
           
		   int theInstructorId=2;
		   Instructor tempInstructor = session.get(Instructor.class,theInstructorId);
		   InstructorDetaill detail = tempInstructor.getInsturctorDetail();
		   tempInstructor.setInsturctorDetail(null);//把fk設成null(解除關聯) 這樣就不會影響到對應的表格了
		   session.delete(detail);
		   session.getTransaction().commit();
	   }catch(Exception e) {
		   session.getTransaction().rollback();
		   System.out.println("交易失敗,資料已返回");
		 
	   }finally {
		HibernateUtil.closeSessionFactory();
	}
	
   }
}
