package in.co.rays.Ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.st_marksheetBean;
import in.co.rays.model.st_marksheetModel;

@WebServlet("/st_marksheetCtl")
public class st_marksheetCtl extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("st_marksheetView.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		st_marksheetBean bean = new st_marksheetBean();
		st_marksheetModel model = new st_marksheetModel();
		
		String name = request.getParameter("name");
		String rollNoStr = request.getParameter("rollNo");
		String physicsStr = request.getParameter("physics");
		String chemistryStr = request.getParameter("chemistry");
		String mathsStr = request.getParameter("maths");
		
	    	int rollNo = Integer.parseInt(rollNoStr);
		    int physics = Integer.parseInt(physicsStr);
		    int chemistry = Integer.parseInt(chemistryStr);
		    int maths = Integer.parseInt(mathsStr);
		
		
		try {
			bean.setName(name);
			bean.setRollNo(rollNo);
			bean.setPhysics(physics);
			bean.setChemistry(chemistry);
			bean.setMaths(maths);
			
			model.add(bean);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("st_marksheetView.jsp");
		rd.forward(request, response);
		
	}
	
	

}
