package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReportDAO;
import DAO.UserDAO;
import model.Favorite;
import model.Report;

/**
 * Servlet implementation class FavController
 */
@WebServlet(urlPatterns = { "/favVideo", "/favUser", "/favShare" })
public class FavController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FavController() {
		super();
	}

	ReportDAO rdao = new ReportDAO();
	UserDAO udao = new UserDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if (uri.contains("favVideo")) {
			showFavVideo(request, response);
			request.getRequestDispatcher("/views/ThongKe/FavVideo.jsp").forward(request, response);
		} else if (uri.contains("favUser")) {
			request.getRequestDispatcher("/views/ThongKe/FavUser.jsp").forward(request, response);
		} else if (uri.contains("favShare")) {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("favVideo")) {
			showFavVideo(request, response);
			request.getRequestDispatcher("/views/ThongKe/FavVideo.jsp").forward(request, response);
		} else if (uri.contains("favUser")) {
			showFavUser(request, response);
			request.getRequestDispatcher("/views/ThongKe/FavUser.jsp").forward(request, response);
		} else if (uri.contains("favShare")) {

		}
	}

	// Hàm show của favVideo.jsp
	protected void showFavVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Report> report = rdao.findVideoForReport();
		request.setAttribute("report", report);
		request.getRequestDispatcher("/views/ThongKe/FavVideo.jsp").forward(request, response);
	}

	// Hàm show của favUser.jsp
	protected void showFavUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vid = request.getParameter("vid");
		System.out.println(vid);
		List<Favorite> favUser = udao.findUserFavoriteByVideoID(vid);
		request.setAttribute("favUser", favUser);
		System.out.println(favUser);

	}
}
