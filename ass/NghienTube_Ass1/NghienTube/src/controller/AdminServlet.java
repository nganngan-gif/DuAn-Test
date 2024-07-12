package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDAO;
import DAO.VideoDAO;
import model.User;
import model.Video;
import util.JPAUtils;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(urlPatterns = { "/admin/index", "/admin/edit-user/update", "/admin/edit-user/delete",
		"/admin/edit-user/edit", "/admin/edit-user/find", "/admin/edit-video/index", "/admin/edit-video/create",
		"/admin/edit-video/update", "/admin/edit-video/delete", "/admin/edit-video/reset", "/admin/edit-video/edit" })
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	User user = new User();
	UserDAO udao = new UserDAO();
	VideoDAO vdao = new VideoDAO();
	Video video = new Video();
	EntityManager em = JPAUtils.geEntityManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(">>>>>>get" + uri + "====" + uri.contains("/edit-video/edit"));
		if (uri.contains("/admin/index")) {
			showVideoForIndex(request, response);
			request.getRequestDispatcher("/views/home/adminIndex.jsp").forward(request, response);
		} else if (uri.contains("edit-user/update")) {
			this.findAllUser(request, response);
			request.getRequestDispatcher("/views/EditUser/edit.jsp").forward(request, response);
		} else if (uri.contains("edit-user/delete")) {
			this.findAllUser(request, response);
			request.getRequestDispatcher("/views/EditUser/edit.jsp").forward(request, response);
		} else if (uri.contains("edit-user/edit")) {
			System.out.println(">>>>>>get 69");
			this.editUser(request, response);
			this.findAllUser(request, response);
			request.getRequestDispatcher("/views/EditUser/edit.jsp").forward(request, response);
		} else if (uri.contains("edit-user/find")) {
			System.out.println(">>>>>>get 75");
			request.getRequestDispatcher("/views/EditUser/edit.jsp").forward(request, response);
		} else if (uri.contains("edit-video/index")) {
			System.out.println(">>>>>>get 79");
			findAllVideo(request, response);
			request.getRequestDispatcher("/views/EditVideo/edit.jsp").forward(request, response);
		} else if (uri.contains("edit-video/create")) {
			request.getRequestDispatcher("/views/EditVideo/edit.jsp").forward(request, response);
		} else if (uri.contains("edit-video/update")) {
			request.getRequestDispatcher("/views/EditVideo/edit.jsp").forward(request, response);
		} else if (uri.contains("edit-video/delete")) {
			request.getRequestDispatcher("/views/EditVideo/edit.jsp").forward(request, response);
		} else if (uri.contains("edit-video/reset")) {
			request.getRequestDispatcher("/views/EditVideo/edit.jsp").forward(request, response);
		} else if (uri.contains("/edit-video/edit")) {
			System.out.println(">>>>>>get 98");
			this.editVideo(request, response);
			this.findAllVideo(request, response);
			request.getRequestDispatcher("/views/EditVideo/edit.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(">>>>>>post" + uri);
		if (uri.contains("/admin/index")) {
			showVideoForIndex(request, response);
			request.getRequestDispatcher("/views/home/adminIndex.jsp").forward(request, response);
		} else if (uri.contains("edit-user/update")) {
			this.updateUser(request, response);
			this.findAllUser(request, response);
			request.getRequestDispatcher("/views/EditUser/edit.jsp").forward(request, response);
		} else if (uri.contains("edit-user/delete")) {
			try {
				this.deleteUser(request, response);
				findAllUser(request, response);
				request.getRequestDispatcher("/views/EditUser/edit.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
		} else if (uri.contains("edit-video/create")) {
			this.createVideo(request, response);
			this.findAllVideo(request, response);
			request.getRequestDispatcher("/views/EditVideo/edit.jsp").forward(request, response);
		} else if (uri.contains("edit-video/update")) {
			updateVideo(request, response);
			findAllVideo(request, response);
			request.getRequestDispatcher("/views/EditVideo/edit.jsp").forward(request, response);
		} else if (uri.contains("edit-video/delete")) {
			try {
				deleteVideo(request, response);
				findAllVideo(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/views/EditVideo/edit.jsp").forward(request, response);
		} else if (uri.contains("edit-video/reset")) {
			request.getRequestDispatcher("/views/EditVideo/edit.jsp").forward(request, response);
		} else if (uri.contains("/edit-video/edit")) {

			this.editVideo(request, response);
			request.getRequestDispatcher("/views/EditVideo/edit.jsp").forward(request, response);
		}
	}

	// Hàm update user
	protected void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			BeanUtils.populate(user, request.getParameterMap());
			udao.update(user);
			request.setAttribute("message", "Update người dùng thành công!");
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			System.out.println(e);
			request.setAttribute("message", "Update người dùng thất bại!");
		}
	}

	// Hàm lấy dữ liệu đổ ra bảng
	protected void findAllUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> user = udao.findAll();
		request.setAttribute("user", user);

	}

	// Hàm edit
	protected void editUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("id");
		User user = udao.findById(userid);
		request.setAttribute("user1", user);

	}

	// Hàm delete
	protected void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		String userid = request.getParameter("usersID");
		udao.delete(userid);
	}

	// Lấy video cho admin index
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

	// lấy số trang hiện tại
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

	// Hàm craete video
	protected void createVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BeanUtils.populate(video, request.getParameterMap());
			vdao.insert(video);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

	// Hàm find All Video
	protected void findAllVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> video = vdao.findAll();
		request.setAttribute("video", video);
	}

	// Hàm edit video
	protected void editVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idv"));
		System.out.println(id);
		Video video = em.find(Video.class, id);
		System.out.println(video);
		request.setAttribute("video1", video);

	}

	protected void updateVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BeanUtils.populate(video, request.getParameterMap());
			vdao.update(video);
			request.setAttribute("message", "Update người dùng thành công!");
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			System.out.println(e);
			request.setAttribute("message", "Update người dùng thất bại!");
		}
	}

	protected void deleteVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		int videoid = Integer.parseInt(request.getParameter("videoID"));
		vdao.delete(videoid);
	}

	// Edit cant
}
