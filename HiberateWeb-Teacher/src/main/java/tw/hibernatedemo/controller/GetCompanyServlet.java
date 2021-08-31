package tw.hibernatedemo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.bibernatedemo.service.CompanyService;
import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.util.HibernateUtil;




@WebServlet("/GetCompanyServlet")
public class GetCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    SessionFactory factory =HibernateUtil.getSessionFactory();
    Session session=factory.getCurrentSession();
    
    private CompanyService comService;
    
    public void init() {
    	this.comService = new CompanyService(session);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   CompanyBean company = comService.select(1002);
	   System.out.println(company.getCompanyName());
	   request.setAttribute("theCompany", company);
	   request.getRequestDispatcher("company-response.jsp").forward(request, response);
	}

}
