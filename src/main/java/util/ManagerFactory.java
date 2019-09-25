package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerFactory {
	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("saladbowl");

}
