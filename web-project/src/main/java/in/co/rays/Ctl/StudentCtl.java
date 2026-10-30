package in.co.rays.Ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.StudentBean;
import in.co.rays.model.StudentModel;

@WebServlet("/StudentCtl")
public class StudentCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String mobileNoStr = request.getParameter("mobileNo");
		String subject = request.getParameter("subject");
		String ageStr = request.getParameter("age");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");

		Long mobileNo = Long.parseLong(mobileNoStr);
		int age = Integer.parseInt(ageStr);

		try {
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setMobile(mobileNo);
			bean.setSubject(subject);
			bean.setAge(age);
			bean.setGender(gender);
			bean.setCity(city);

			model.add(bean);
			request.setAttribute("successMsg", "Student record created successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
		rd.forward(request, response);

	}

}
