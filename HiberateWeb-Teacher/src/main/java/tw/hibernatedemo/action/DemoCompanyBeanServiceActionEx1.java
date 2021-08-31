package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.bibernatedemo.service.CompanyService;
import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoCompanyBeanServiceActionEx1 {

	public static void main(String[] args) {
       
		  SessionFactory factory = HibernateUtil.getSessionFactory();
		  Session session = factory.getCurrentSession();
		  
		  try {
			  session.beginTransaction();
			  
			  CompanyService comSession = new CompanyService(session);
			  comSession.insert(new CompanyBean(3,"慈惠"));
			  CompanyBean oneBean = comSession.select(3);
			  if(oneBean!=null) {
			  System.out.println("ID:"+oneBean.getCompanyId()+" Name:"+oneBean.getCompanyName());
			  }else {
				  System.out.println("沒有這筆資料");
			  }
			  session.getTransaction();
		  }catch(Exception e) {
			  session.getTransaction().rollback();
			  
		  }finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
