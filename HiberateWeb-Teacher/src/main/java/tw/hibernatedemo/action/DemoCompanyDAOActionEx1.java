package tw.hibernatedemo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.model.CompanyDAO;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoCompanyDAOActionEx1 {


	public static void main(String[] args) {
        DemoCompanyDAOActionEx1 daoAction = new DemoCompanyDAOActionEx1();
        daoAction.myDaoAction();
	}

	public void myDaoAction(){
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			 CompanyDAO comDAO = new CompanyDAO(session);
//			 comDAO.insert(new CompanyBean(1003,"SnowFlake"));
			 
//			 comDAO.updateOne(1001, "Doge Coin");
			 
			 comDAO.deleteOne(1002);
			 
			 CompanyBean comBean = comDAO.select(1001);
			 
			 if(comBean!=null) {
				 System.out.println(comBean.getCompanyId()+":"+comBean.getCompanyName());
			 }else {
				 System.out.println("NO RESULT!!!");
			 }
			 
			 List<CompanyBean> selectAll = comDAO.selectAll(); 
			 
			 for(CompanyBean oneBean:selectAll) {
				 System.out.println(oneBean.getCompanyId()+":"+oneBean.getCompanyName());
			 }
			 
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println("Someting wrong and rollback!!");
			
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
