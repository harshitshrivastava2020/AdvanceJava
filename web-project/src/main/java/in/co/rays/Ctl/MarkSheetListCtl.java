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
import in.co.rays.model.MarkSheetModel;

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
		}catch(Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("MarkSheetListView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("MarkSheetListView.jsp");
		rd.forward(request, response);
	}

}
