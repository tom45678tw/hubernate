package tw.hibernatedemo.action;

import java.util.LinkedHashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.BookUsers;
import tw.hibernatedemo.model.Books;
import tw.hibernatedemo.util.HibernateUtil;
//新使用者,借兩本書
public class DemoBookOneToManyActionEx1 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
	            Session session = factory.getCurrentSession();//連線狀態
	            
	            try {
	                      session.beginTransaction();
	                      
	                      //new User1
	                      BookUsers user1 = new BookUsers();
	                      user1.setUsername("john");
	                      //new book1
	                      Books book1 = new Books();
	                      book1.setBooktitle("Learn Java");
	                      book1.setPublicYear("2011 1st");
	                      //new book2
	                      Books book2 = new Books();
	                      book2.setBooktitle("comics");
	                      book2.setPublicYear("2020");
	                      
	                      //關聯 
	                      book1.setBookuser(user1);
	                      book2.setBookuser(user1);
	                      
	                      //先把 books 裝到 set 裡面,在將user 關聯 book
	                      LinkedHashSet<Books> bookset = new LinkedHashSet<Books>();
	                      
	                      bookset.add(book1);
	                      bookset.add(book2);
	                      
	                      user1.setBooks(bookset);
	                      
	                      //將user 轉為 永續狀態(persistent)
	                      //因設置 casecade 連動,所以 book 也會一起改變維 Persistent狀態
	                      session.save(user1);
	                      
	                      session.getTransaction().commit();
	            }catch(Exception e) {
	            	session.getTransaction().rollback();
	            	System.out.println("交易失敗,資料將退回");
	            }finally {
	            	HibernateUtil.closeSessionFactory();
	            }
	}

}
