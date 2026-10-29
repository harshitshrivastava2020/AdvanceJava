package in.co.rays.Ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String op = request.getParameter("operation");
		
		if(op !=null) {
			HttpSession session = request.getSession();
			session.invalidate(); // destroy session
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String login = request.getParameter("login");
		String password = request.getParameter("password");

//		System.out.println(login + "\n" + password + "\n");

		try {
			HttpSession session = request.getSession();
			bean = model.authenticate(login, password);

			if (bean != null) {
				System.out.println("user successfully login");
				session.setAttribute("user", bean);
				response.sendRedirect("WelcomeCtl");
				return;
			} else {
				System.out.println("Invalid Creadentials");
				request.setAttribute("errorMsg", "Invalid Creadentials");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
		rd.forward(request, response);
	}

}
