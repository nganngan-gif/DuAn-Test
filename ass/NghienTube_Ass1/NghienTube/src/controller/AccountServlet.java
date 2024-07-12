package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDAO;
import util.CookiesUtils;
import model.User;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet({ "/account/sign-in", "/account/sign-up", "/account/sign-out", "/account/forgot-password",
		"/account/change-password", "/account/edit-profile", "/account/change-pass" })

public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AccountServlet() {
		super();
	}

	UserDAO udao = new UserDAO();

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		if (uri.contains("sign-in")) {
			this.doSignIn(req, resp);
		} else if (uri.contains("sign-up")) {
			this.doSignUp(req, resp);
		} else if (uri.contains("edit-profile")) {
			this.doEditProfile(req, resp);
		} else if (uri.contains("sign-out")) {
			try {
				this.doSignOut(req, resp);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		} else if (uri.contains("change-pass")) {
			try {
				this.dochangepass(req, resp);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	// success
	private void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		try {
			if (uname.equals("") && pass.equals("")) {
				req.setAttribute("message", "Sign In Fall");
				req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
			} else if (method.equalsIgnoreCase("POST")) {
				User u = udao.checkLogin(uname, pass);
				req.getSession().setAttribute("user", u);
				int hours = 30 * 24;
				CookiesUtils.add("username", u.getUsersID(), hours, resp);
				CookiesUtils.add("password", u.getPass(), hours, resp);
				if (u.getAdmin()) {
					req.getRequestDispatcher("/admin/index?page=0").forward(req, resp);
				} else {
					req.getRequestDispatcher("/user/index?page=0").forward(req, resp);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
			req.setAttribute("message", "Sign In Fall");
			req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
		}

	}

	// success
	private void doSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pass = req.getParameter("pass");
		String cfpass = req.getParameter("confirm-password");
		String method = req.getMethod();
		Clear(req, resp, "user");
		if (pass.equals(cfpass)) {
			try {
				User user = new User();
				BeanUtils.populate(user, req.getParameterMap());
				if (this.checknullsignup(user)) {
					if (this.checkuserid(user.getUsersID())) {
						if (method.equalsIgnoreCase("POST")) {
							udao.insert(user);
							req.setAttribute("user", user);
							req.setAttribute("message", "Sign Up success");
						}
					} else {
						req.setAttribute("message", "Tên đăng nhập đã tồn tại");
						req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
					}
				} else {
					req.setAttribute("message", "Vui Lòng Nhập Đủ Thông Tin");
					req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
				}
				req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("message", "Sign Up Fall");
				req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("message", "Xác nhận mật khẩu sai");
			req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
		}
	}

	private void doEditProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		String method = req.getMethod();
		try {
			if (method.equalsIgnoreCase("POST")) {
				BeanUtils.populate(user, req.getParameterMap());
				udao.update(user);
				req.setAttribute("user", user);
				req.setAttribute("message", "Edit success");
			}
			req.getRequestDispatcher("/views/edit.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("message", "Edit Fall");
			req.getRequestDispatcher("/views/edit.jsp").forward(req, resp);
		}
	}

	private void Clear(HttpServletRequest req, HttpServletResponse resp, String user)
			throws ServletException, IOException {
		User entity = new User();
		req.setAttribute(user, entity);
	}

	private void doSignOut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		User user = new User();
		BeanUtils.populate(user, req.getParameterMap());
		try {
			req.getSession().setAttribute("user", user);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);

		} catch (Exception e) {
			req.setAttribute("user", user);
			req.setAttribute("message", "Sign Out Fall");
			req.getRequestDispatcher("/views/sign-up.jsp").forward(req, resp);
		}
	}

	private void dochangepass(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
		String method = req.getMethod();
		try {
			if (method.equalsIgnoreCase("POST")) {
				String uname = req.getParameter("username");
				String pass = req.getParameter("curent-password");
				try {
					User u = udao.checkLogin(uname, pass);
					if (req.getParameter("new-password").equals(req.getParameter("confirm-password"))) {
						u.setPass(req.getParameter("new-password"));
						udao.update(u);
						req.setAttribute("message", "Cập nhật mật khẩu thành công");
						req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
					} else {
						req.setAttribute("message", "Xác nhận mật khẩu mới không trùng khớp");
						req.getRequestDispatcher("/views/user/changePassword.jsp").forward(req, resp);
					}
				} catch (Exception e) {
					req.setAttribute("message", "Vui lòng nhập đúng tài khoản và mật khẩu");
					req.getRequestDispatcher("/views/user/changePassword.jsp").forward(req, resp);
				}
			}

		} catch (Exception e) {
			req.getRequestDispatcher("/views/sign-up.jsp").forward(req, resp);
		}
	}

	private boolean checknullsignup(User user) {
		if (user.getUsersID().equals("") || user.getPass().equals("") || user.getFullName().equals("")) {
			return false;
		}
		return true;
	}

	private boolean checkuserid(String user) {
		User u = udao.findById(user);
		if (u == null) {
			return true;
		}
		return false;

	}
}