package run.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.dto.AreaDTO;
import model.dto.FootTrafficDTO;

public class TestDrive {
	
	static void logic(EntityManager em) {
		AreaDTO area = new AreaDTO();
		area.setAreaName("가재울6길");
		area.setSigungu("서대문구");
		em.persist(area);
		
		FootTrafficDTO ft = new FootTrafficDTO();
		ft.setGender("M");
		ft.setDay("FRI");
		ft.setTimes(4);
		ft.setFt(234324);
		ft.setArea(area);
		em.persist(ft);
		
		area.getTraffic().add(ft);
		
		FootTrafficDTO ft2 = new FootTrafficDTO();
		ft2.setGender("M");
		ft2.setDay("FRI");
		ft2.setTimes(3);
		ft2.setFt(123425);
		ft2.setArea(area);
		em.persist(ft2);
		
		area.getTraffic().add(ft2);
		
		
		
//		em.flush();
//		em.clear();
//		
		AreaDTO findM = em.find(AreaDTO.class, area.getAreaName());
		System.out.println(findM);
		
		FootTrafficDTO fintF = em.find(FootTrafficDTO.class, ft2.getId());
		System.out.println(fintF);
		System.out.println(fintF.getArea().getSigungu());
	}

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("saladbowl");
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			logic(em);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			factory.close();
		}
		
	}

}
