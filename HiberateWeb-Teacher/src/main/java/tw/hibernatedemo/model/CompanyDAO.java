package tw.hibernatedemo.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class CompanyDAO implements CompanyDAOInterface {
  
	 private Session session;
	 
	 
	public CompanyDAO(Session session) {
		this.session=session;
	}

	public CompanyBean insert(CompanyBean comBean) {
	       CompanyBean companyBean = session.get(CompanyBean.class,comBean.getCompanyId());
	       
	       if(companyBean == null) {
                      session.save(comBean);
                      return comBean;
	       }
	       return null;
	}

	public CompanyBean select(int comId) {
//		CompanyBean companyBean = session.get(CompanyBean.class, comId);
//		return companyBean;
		
		return session.get(CompanyBean.class, comId); //這行=上面兩行
	}

	@Override
	public List<CompanyBean> selectAll() {
		//hql 語法
	     Query<CompanyBean> Query = session.createQuery("from CompanyBean",CompanyBean.class);
		return Query.list();
	}

	@Override
	public CompanyBean updateOne(int comId, String comName) {
		 CompanyBean comBean = session.get(CompanyBean.class, comId);
		 if(comBean != null) { 
			 comBean.setCompanyName(comName);
		 }
		return comBean;
	}

	@Override
	public boolean deleteOne(int comId) {
		 CompanyBean comBean = session.get(CompanyBean.class, comId);
		 if(comBean != null) { 
		    session.delete(comBean);
		    return true;
		 }
		 
		return false;
	}

}
