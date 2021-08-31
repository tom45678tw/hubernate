package tw.bibernatedemo.service;

import java.util.List;

import org.hibernate.Session;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.model.CompanyDAO;

public class CompanyService implements CompanyServiceInterface {

	private CompanyDAO comDAO;

	public CompanyService(Session session) {
	 this.comDAO = new CompanyDAO(session);
	}

	@Override
	public CompanyBean select(int comId) {
		 CompanyBean comBean = comDAO.select(comId);
//		 comBean.setCompanyName("優質公司");  //DAO 盡量乾淨 要寫什麼在這裡寫
		return comBean;
	}

	@Override
	public List<CompanyBean> selectAll() {
		List<CompanyBean> theComs = comDAO.selectAll();
		return theComs;
	}

	@Override
	public CompanyBean insert(CompanyBean comBean) {
		 CompanyBean oneCompany = comDAO.insert(comBean);
		return oneCompany;
	}

	@Override
	public CompanyBean updateOne(int ComId, String comName) {
		CompanyBean oneCom = comDAO.updateOne(ComId, comName);
		return oneCom;
	}

	@Override
	public boolean delete(int comid) {
		boolean boo = comDAO.deleteOne(comid);
		return boo;
	}

}
