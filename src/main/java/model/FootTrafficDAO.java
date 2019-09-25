package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import model.dto.AreaDTO;
import model.dto.FootTrafficDTO;
import util.ManagerFactory;

public class FootTrafficDAO {

	// 유동인구 insert
	public static boolean insertFootTraffic(String gender, String day, int times, int ft, AreaDTO area)
			throws Exception {
		EntityManager em = ManagerFactory.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;

		tx.begin();
		try {
			em.persist(new FootTrafficDTO(gender, day, times, ft, area));
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

	// 유동인구 전체 검색
	public static List<FootTrafficDTO> selectAllFoot() throws Exception {
		EntityManager em = ManagerFactory.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<FootTrafficDTO> list = new ArrayList<FootTrafficDTO>();

		tx.begin();
		try {
			list = em.createQuery("select f from AREA_FOOT_TRAFFIC f", FootTrafficDTO.class).getResultList();
			tx.commit();
		} catch (RollbackException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}

		return list;
	}

	// 유동인구 개별 검색
	public static FootTrafficDTO selectTraffic(int id) throws Exception {
		EntityManager em = ManagerFactory.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		FootTrafficDTO traffic = new FootTrafficDTO();

		tx.begin();
		try {
			traffic = em.find(FootTrafficDTO.class, id);
			tx.commit();
		} catch (RollbackException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}

		return traffic;
	}

	// 유동인구 update
	public static boolean updateTraffic(int id, int ft) throws Exception {
		EntityManager em = ManagerFactory.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		FootTrafficDTO area = new FootTrafficDTO();
		boolean result = false;

		tx.begin();
		try {
			area = em.find(FootTrafficDTO.class, id);
			area.setFt(ft);
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

	// 유동인구 지역 PK로 select
	public static List<FootTrafficDTO> selectFromArea(String areaName) throws Exception{
		EntityManager em = ManagerFactory.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<FootTrafficDTO> result = new ArrayList<FootTrafficDTO>();
		tx.begin();


		try {
			TypedQuery<FootTrafficDTO> query = em
					.createQuery("SELECT f FROM AREA_FOOT_TRAFFIC f WHERE f.area = :area", FootTrafficDTO.class)
					.setParameter("area", em.find(AreaDTO.class, areaName));

			result = query.getResultList();
			tx.commit();
		} catch (RollbackException e){
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}

		return result;
	}

	// 유동인구 areaName으로 delete
	public static boolean deleteTraffic(String areaName) throws Exception {
		EntityManager em = ManagerFactory.factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;

		tx.begin();
		try {
			for (FootTrafficDTO a : selectFromArea(areaName)) {
				em.remove(em.contains(a) ? a : em.merge(a));
				result = true;
			}
			tx.commit();

		} catch (RollbackException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return result;
	}

}
