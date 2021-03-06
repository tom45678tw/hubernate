package tw.hibernatedemo.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet Filter implementation class OpenSessionViewFitter
 */
@WebFilter("/OpenSessionViewFitter")
public class OpenSessionViewFitter implements Filter {

    
    

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	         SessionFactory factory = HibernateUtil.getSessionFactory();
		            Session session = factory.getCurrentSession();
		            
		            try {
		            	
		            	session.beginTransaction();
		            	System.out.println("Transaction begin!!");
		            	chain.doFilter(request, response);
                          
		            	session.getTransaction().commit();
		            	System.out.println("Transaction commit OK");
		            }catch(Exception e){
		            	
		            	session.getTransaction().rollback();
		            	System.out.println("交易失敗, 資料即將返回");
		            	e.printStackTrace();
		            }finally {
		            	System.out.println("Session close!");
		            }
	       }


}
