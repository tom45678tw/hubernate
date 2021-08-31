package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetaill;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneInstructorActionEx1 {

	public static void main(String[] args) {
      SessionFactory factory = HibernateUtil.getSessionFactory();
          Session session = factory.getCurrentSession();
          
          try {
        	  
        	  
        	  Instructor ins1 = new Instructor();
        	  
        	  ins1.setName("jack");
        	  
        	  InstructorDetaill derail1 = new InstructorDetaill();
        	  derail1.setEmail("jack@gmail.com");
        	  derail1.setPhone("389");
        	  
        	  ins1.setInsturctorDetail(derail1); //將這兩個連起來
        	  session.beginTransaction();
        	  
   
        	  //以下save 也會使 detail 到永續狀態,因為有設置 CasecadeType.ALL
        	  session.save(ins1);
        	  session.getTransaction().commit();
          }catch(Exception e) {
        	  session.getTransaction().rollback();
        	  System.out.println("交易失敗 資料即將返回");
          }finally {
			HibernateUtil.closeSessionFactory();
		}
          
	}

}
