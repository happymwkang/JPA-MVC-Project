package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import model.dto.AreaDTO;
import util.ManagerFactory;

public class AreaDAO {

	// 지역정보 insert
	public static boolean insertArea(String areaName, String sigungu) throws Exception {
		EntityManager em = ManagerFactory.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;

		tx.begin();
		try {
			em.persist(new AreaDTO(areaName, sigungu));
			tx.commit();
			result = true;
		} catch (RollbackException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return result;

	}

	// 지역정보 전체 검색
	public static List<AreaDTO> selectAllArea() throws Exception {
		EntityManager em = ManagerFactory.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<AreaDTO> list = new ArrayList<AreaDTO>();

		tx.begin();

		try {
			list = em.createQuery("select e from AreaDTO e", AreaDTO.class).getResultList();
			tx.commit();
		} catch (RollbackException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}

		return list;
	}

	// 지역정보 개별 검색
	public static AreaDTO selectArea(String areaName) throws Exception {
		EntityManager em = ManagerFactory.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		AreaDTO area = new AreaDTO();

		tx.begin();
		try {
			area = em.find(AreaDTO.class, areaName);
			tx.commit();
		} catch (RollbackException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return area;
	}

	// 지역정보 update
	public static boolean updateArea(String areaName, String sigungu) throws Exception {
		EntityManager em = ManagerFactory.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		AreaDTO area = new AreaDTO();
		boolean result = false;

		tx.begin();
		try {
			area = em.find(AreaDTO.class, areaName);
			area.setSigungu(sigungu);
			em.persist(area);
			tx.commit();
			result = true;
		} catch (RollbackException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return result;
	}

	// 지역정보 구이름으로 select
	public static List<AreaDTO> selectFromGu(String sigungu) throws Exception{
		EntityManager em = ManagerFactory.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<AreaDTO> result = new ArrayList<AreaDTO>();

		tx.begin();
		try {
			TypedQuery<AreaDTO> query = em
					.createQuery("SELECT a FROM AreaDTO a WHERE a.sigungu = :sigungu", AreaDTO.class)
					.setParameter("sigungu", sigungu);

			result = query.getResultList();
			tx.commit();
		} catch (RollbackException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}

		return result;
	}

	// 지역정보 구 이름으로 delete
	public static boolean deleteArea(String areaName) throws Exception {
		EntityManager em = ManagerFactory.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		AreaDTO area = new AreaDTO();
		boolean result = false;

		tx.begin();
		try {
			area = em.find(AreaDTO.class, areaName);
			em.remove(area);
			tx.commit();
			result = true;
		} catch (RollbackException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return result;
	}
}
