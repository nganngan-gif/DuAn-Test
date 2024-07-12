package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import util.JPAUtils;
import model.Video;

public class VideoDAO {
	public List<Video> findAllVideo(int page, int size) {
		EntityManager em = JPAUtils.geEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Video.findAll", Video.class);
		query.setFirstResult(page * size);
		query.setMaxResults(size);
		List<Video> list = query.getResultList();
		return list;
	}

	public List<Video> findVideoFavoriteByUserName(String username) {
		EntityManager em = JPAUtils.geEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Video.findVideoFavoriteByUserName", Video.class);
		query.setParameter("username", username);
		return query.getResultList();
	}

	public Video findOneVideo(int id) {
		EntityManager em = JPAUtils.geEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Video.findOne", Video.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public List<Video> Random10Video() {
		EntityManager em = JPAUtils.geEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Video.random10", Video.class);
		List<Video> list = query.getResultList();
		System.out.println(list);
		return list;
	}

	public List<Video> findAll() {
		EntityManager em = JPAUtils.geEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Video.findAll", Video.class);
		List<Video> list = query.getResultList();
		// System.out.println(list);
		return list;
	}

	public void insert(Video video) {
		EntityManager em = JPAUtils.geEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();// bắt đầu thay đổi dữ liệu
			em.persist(video);// lưu thong tin từ đối tượng vào csdl
			trans.commit();// hoàng thành thay đổi
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();// nếu có vấn đề sẽ khôi phuc lại lúc đầu
			throw e;
		} finally {
			em.close();
		}
	}

	public void update(Video video) {
		EntityManager em = JPAUtils.geEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();// bắt đầu thay đổi dữ liệu
			em.merge(video);// thực hiên câp nhật user
			trans.commit();// hoàng thành thay đổi
			System.out.println("update ok");
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();// nếu có vấn đề sẽ khôi phuc lại lúc đầu
			throw e;
		} finally {
			em.close();
		}
	}

	public void delete(int videoid) throws Exception {
		EntityManager em = JPAUtils.geEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();// bắt đầu thay đổi dữ liệu
			Video entity = em.find(Video.class, videoid);
			if (entity != null) {
				em.remove(entity);// xóa user
			} else {
				throw new Exception("Không tìm thấy thông tin user");
			}
			trans.commit();// hoàng thành thay đổi
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();// nếu có vấn đề sẽ khôi phuc lại lúc đầu
			throw e;
		} finally {
			em.close();
		}
	}
}
