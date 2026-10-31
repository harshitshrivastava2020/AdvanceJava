package in.co.rays.Ctl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.MarkSheetBean;
import in.co.rays.bean.UserBean;
import in.co.rays.model.MarkSheetModel;
import in.co.rays.model.UserModel;

@WebServlet("/MarkSheetListCtl")
public class MarkSheetListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MarkSheetModel model = new MarkSheetModel();
		MarkSheetBean bean = new MarkSheetBean();
		int pageNo = 1;
		int pageSize = 5;

		try {
			List<MarkSheetBean> list = model.search(bean, pageNo, pageSize);
			request.setAttribute("marksheetList", list);
			request.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("MarkSheetListView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		System.out.println("op = " + op);

		MarkSheetModel model = new MarkSheetModel();
		MarkSheetBean bean = new MarkSheetBean();
		System.out.println("pageNo from view: " + request.getParameter("pageNo"));
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		System.out.println("pageNo after parse: " + pageNo);
		int pageSize = 5;

		if (op.equals("previous")) {
			System.out.println("in previous");
			pageNo--;
			System.out.println("pageNo: " + pageNo);
		}
		
		if (op.equals("next")) {
			System.out.println("in next");
			pageNo++;
			System.out.println("pageNo: " + pageNo);
		}
		
		try {
			List<MarkSheetBean> list = model.search(bean, pageNo, pageSize);
			request.setAttribute("marksheetList", list);
			request.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("MarkSheetListView.jsp");
		rd.forward(request, response);
	}

}
