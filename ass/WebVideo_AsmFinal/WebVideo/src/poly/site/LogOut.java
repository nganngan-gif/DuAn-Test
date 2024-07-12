package poly.site;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.common.CookieUtils;
import poly.common.PageInfo;
import poly.common.PageType;
import poly.common.SessionUtils;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class LogOut extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CookieUtils.add("username", null, 0, response);
		SessionUtils.invalidate(request);
		request.setAttribute("isLogin", false);
		PageInfo.prepareAndForward(request, response, PageType.SITE_LOGIN_PAGE);
	}

}
