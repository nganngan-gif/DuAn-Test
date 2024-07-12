package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Favorite;
import model.User;
import util.JPAUtils;

public class UserDAO {

	@Override
	protected void finalize() throws Throwable {
		EntityManager em = JPAUtils.geEntityManager();
		em.close();
		super.finalize();
	}// hĂ m dá»�n rĂ¡c

	public void insert(User user) {
		EntityManager em = JPAUtils.geEntityManager();
		EntityTransaction trans = em.getTransaction();
		if (checknull(user)) {

			if (user != null) {
				try {
					trans.begin();// báº¯t Ä‘áº§u thay Ä‘á»•i dá»¯ liá»‡u
					em.persist(user);// lÆ°u thong tin tá»« Ä‘á»‘i tÆ°á»£ng vĂ o csdl
					trans.commit();// hoĂ ng thĂ nh thay Ä‘á»•i
				} catch (Exception e) {
					e.printStackTrace();
					trans.rollback();// náº¿u cĂ³ váº¥n Ä‘á»� sáº½ khĂ´i phuc láº¡i lĂºc Ä‘áº§u
					throw e;
				} finally {
					em.close();
				}
			} else {
				System.out.println("Insert false");
			}
		} else {
			System.out.println("Insert false");
		}

	}

	public void update(User user) {
		EntityManager em = JPAUtils.geEntityManager();
		EntityTransaction trans = em.getTransaction();
		if (checknull(user)) {

			try {
				trans.begin();// báº¯t Ä‘áº§u thay Ä‘á»•i dá»¯ liá»‡u
				em.merge(user);// thá»±c hiĂªn cĂ¢p nháº­t user
				trans.commit();// hoĂ ng thĂ nh thay Ä‘á»•i
				System.out.println("update ok");
			} catch (Exception e) {
				e.printStackTrace();
				trans.rollback();// náº¿u cĂ³ váº¥n Ä‘á»� sáº½ khĂ´i phuc láº¡i lĂºc Ä‘áº§u
				throw e;
			} finally {
				em.close();
			}
		} else {
			System.out.println("Update false");
		}
	}

	public void delete(String userid) throws Exception {
		EntityManager em = JPAUtils.geEntityManager();
		EntityTransaction trans = em.getTransaction();
		User entity = em.find(User.class, userid);
		
		try {
			trans.begin();// báº¯t Ä‘áº§u thay Ä‘á»•i dá»¯ liá»‡u

			if (entity != null) {
				em.remove(entity);// xĂ³a user
			} else {
				throw new Exception("KhĂ´ng tĂ¬m tháº¥y thĂ´ng tin user");
			}
			trans.commit();// hoĂ ng thĂ nh thay Ä‘á»•i
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();// náº¿u cĂ³ váº¥n Ä‘á»� sáº½ khĂ´i phuc láº¡i lĂºc Ä‘áº§u
			throw e;
		} finally {
			em.close();
		}
		
	}

	public List<User> findAll() {
		EntityManager em = JPAUtils.geEntityManager();
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	public User findById(String userid) {
		EntityManager em = JPAUtils.geEntityManager();
		User entity = em.find(User.class, userid);
		return entity;

	}

	public User checkLogin(String id, String password) {
		EntityManager em = JPAUtils.geEntityManager();
		String jqpl = "select u from User u where u.usersID = :id and u.pass = :password";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		query.setParameter("id", id);
		query.setParameter("password", password);
		return query.getSingleResult();
	}

	public boolean checkLoginTrue(String id, String password) {
		EntityManager em = JPAUtils.geEntityManager();
		String jqpl = "select u from User u where u.usersID = :id and u.pass = :password";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		query.setParameter("id", id);
		query.setParameter("password", password);
		try {
			User u = query.getSingleResult();
			if (u.getUsersID().equals(id) && u.getPass().equals(password)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checknull(User user) {
		boolean t;
		if (user != null) {
			boolean temp = user.getUsersID().equals("") && user.getPass().equals("") && user.getFullName().equals("")
					&& user.getEmail().equals("");

			t = temp;
		} else {
			t = false;
		}
		return t;

	}

	public List<User> findAll(int page, int pageSize) {
		EntityManager em = JPAUtils.geEntityManager();
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		query.setFirstResult(page * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	public List<User> findByKeyWord(String fullname, String email) {
		EntityManager em = JPAUtils.geEntityManager();
		String japl = "select u from User u where u.fullname like :fullname or u.email like :email";
		TypedQuery<User> query = em.createQuery(japl, User.class);
		query.setParameter("fullname", "" + fullname + "%");
		query.setParameter("email", "" + email + "%");
		return query.getResultList();
	}

	public List<User> findByRole(boolean ad) {
		EntityManager em = JPAUtils.geEntityManager();
		int admin = 0;
		if (ad == true) {
			admin = 1;
		}
		String japl = "select u from User u where u.admin = :admin";
		TypedQuery<User> query = em.createNamedQuery(japl, User.class);
		query.setParameter("admin", admin);
		return query.getResultList();
	}

	public List<Favorite> findUserFavoriteByVideoID(String vid) {
		EntityManager em = JPAUtils.geEntityManager();
		// Táº¡o Ä‘á»‘i tÆ°á»£ng truy váº¥n
		String jpql = "SELECT NEW model.Favorite(o.user.usersID, o.user.fullName, o.user.email, o.likeDate) FROM Favorite o WHERE o.video.title=:vid";
		TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
		query.setParameter("vid", "%" + vid + "%");
		return query.getResultList();
	}
}
