package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import util.JPAUtils;
import model.Report;

public class ReportDAO {
	public List<Report> findVideoForReport() {
		EntityManager em = JPAUtils.geEntityManager();
		String jpql = "SELECT new Report(o.video.title, count(o), max(o.likeDate), min(o.likeDate)) FROM Favorite o GROUP BY o.video.title ";
		TypedQuery<Report> query = em.createQuery(jpql, Report.class);
		List<Report> list = query.getResultList();
		return list;
	}

	public List<Report> findVideoForReportSTR(int year) {
		EntityManager em = JPAUtils.geEntityManager();

		String jpql = "SELECT new Report(o.video.title, count(o), max(o.likeDate), min(o.likeDate)) FROM "
				+ "Favorite o WHERE year(o.likeDate)=:year GROUP BY o.video.title ";
		TypedQuery<Report> query = em.createQuery(jpql, Report.class);
		query.setParameter("year", year);
		List<Report> list = query.getResultList();
		return list;
	}
}
