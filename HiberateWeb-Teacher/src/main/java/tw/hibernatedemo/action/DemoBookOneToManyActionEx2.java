package tw.hibernatedemo.action;

import java.util.LinkedHashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.BookUsers;
import tw.hibernatedemo.model.Books;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoBookOneToManyActionEx2 {
// 知道書的ID,改書名 comics 為 火隱忍者
	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
	            Session session = factory.getCurrentSession();//連線狀態
	            
	            try {
	                      session.beginTransaction();
	                      Books book1 = session.get(Books.class, 2);
	                      book1.setBooktitle("火隱忍者");
	               
	                      
	                      
	                      
	                      session.getTransaction().commit();
	            }catch(Exception e) {
	            	session.getTransaction().rollback();
	            	System.out.println("交易失敗,資料將退回");
	            }finally {
	            	HibernateUtil.closeSessionFactory();
	            }
	}

}
