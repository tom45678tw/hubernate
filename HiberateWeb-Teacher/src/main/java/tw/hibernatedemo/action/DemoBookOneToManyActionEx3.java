package tw.hibernatedemo.action;

import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.BookUsers;
import tw.hibernatedemo.model.Books;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoBookOneToManyActionEx3 {
// 知道借書者的ID, 不知道書的ID 改書名   火隱忍者 為 NinJa
	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
	            Session session = factory.getCurrentSession();//連線狀態
	            
	            try {
	                      session.beginTransaction();
	                    BookUsers bookUsers = session.get(BookUsers.class, 1);
	                    
	                    Set<Books> books = bookUsers.getBooks();  
	                    for(Books book:books) {
	                    	if(book.getBooktitle().equals("火隱忍者")) {
	                    		book.setBooktitle("NinJa");
	                    	}
	                    }
	                      
	                      session.getTransaction().commit();
	            }catch(Exception e) {
	            	session.getTransaction().rollback();
	            	System.out.println("交易失敗,資料將退回");
	            }finally {
	            	HibernateUtil.closeSessionFactory();
	            }
	}

}
