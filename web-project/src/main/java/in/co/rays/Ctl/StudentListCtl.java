package in.co.rays.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.StudentBean;
import in.co.rays.model.StudentModel;

@WebServlet("/StudentListCtl")
public class StudentListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();

		int pageNo = 1;
		int pageSize = 5;

		try {
			List<StudentBean> list = model.search(bean, pageNo, pageSize);
			request.setAttribute("studentList", list);
			request.setAttribute("pageNo", pageNo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("StudentListView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		System.out.println("op = " + op);

		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();
		System.out.println("pageNo from view: " + request.getParameter("pageNo"));
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		System.out.println("pageNo after parse: " + pageNo);
		int pageSize = 5;

		if (op.equals("delete")) {
			String[] ids = request.getParameterValues("ids");
			if (ids != null && ids.length > 0) {
				for (String id : ids) {
					try {
						model.delete(Integer.parseInt(id));
						request.setAttribute("successMsg", "record deleted successfully");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}else {
				request.setAttribute("errorMsg", "select atleast one record to delete");

			}
		}

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
			List<StudentBean> list = model.search(bean, pageNo, pageSize);
			request.setAttribute("studentList", list);
			request.setAttribute("pageNo", pageNo);
			System.out.println(pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("StudentListView.jsp");
		rd.forward(request, response);
	}

}
