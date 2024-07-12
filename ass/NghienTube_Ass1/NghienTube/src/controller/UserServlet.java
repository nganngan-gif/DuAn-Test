package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import DAO.VideoDAO;
import model.User;
import model.Video;
import util.CookiesUtils;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(urlPatterns = { "/user/index", "/user/likedVideo", "/user/chitiet" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	User user = new User();
	UserDAO udao = new UserDAO();
	VideoDAO vdao = new VideoDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("user/index")) {
			this.showVideoForIndex(request, response);
			request.getRequestDispatcher("/views/home/index.jsp").forward(request, response);
		} else if (uri.contains("user/likedVideo")) {
			showVideoForLiked(request, response);
			request.getRequestDispatcher("/views/videos/LikedVideo.jsp").forward(request, response);
		} else if (uri.contains("user/chitiet")) {
			this.showVideoForChitiet(request, response);
			request.getRequestDispatcher("/views/videos/Trangchitiet.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("user/index")) {
			this.showVideoForIndex(request, response);
			request.getRequestDispatcher("/views/home/index.jsp").forward(request, response);
		} else if (uri.contains("user/likedVideo")) {
			showVideoForLiked(request, response);
			request.getRequestDispatcher("/views/videos/LikedVideo.jsp").forward(request, response);
		} else if (uri.contains("user/chitiet")) {
			this.showVideoForChitiet(request, response);
			request.getRequestDispatcher("/views/videos/Trangchitiet.jsp").forward(request, response);
		}
	}

	// Hàm lấy video cho trang chủ
	protected void showVideoForIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = getPageForIndex(request, response);

		int size = 9;
		List<Video> video = vdao.findAllVideo(page, size);
		int s = Math.round(video.size() / size);
		request.setAttribute("page", page);
		request.setAttribute("s", s);
		System.out.println(video);
		request.setAttribute("video", video);
	}

	// Hàm GetPage
	protected int getPageForIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page;
		int size = 9;
		String getPage = request.getParameter("page");
		if (getPage.equals("")) {
			page = 0;
		} else {
			page = Integer.parseInt(getPage);
		}
		List<Video> video = vdao.findAllVideo(page, size);
		if (page < 0) {
			page = 0;
		}
		if (page >= Math.round(video.size() / size)) {
			page = (int) Math.round(video.size() / size) + 1;
		}
		return page;
	}

	// Hàm show video đã like
	protected void showVideoForLiked(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = CookiesUtils.get("username", request);
		User user = udao.findById(username);
		List<Video> video = vdao.findVideoFavoriteByUserName(user.getUsersID());
		request.setAttribute("video", video);
		System.out.println(video);
	}

	// Hàm show video cho trang chi tiết
	protected void showVideoForChitiet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idVideo"));
		Video video = vdao.findOneVideo(id);
		request.setAttribute("video", video);
		System.out.println(video);
		List<Video> videoRD = vdao.Random10Video();
		request.setAttribute("videoRD", videoRD);
		System.out.println(videoRD);
	}
}
