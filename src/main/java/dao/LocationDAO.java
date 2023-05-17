package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import esercizio1.Location;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocationDAO {

	private final EntityManager em;

	public LocationDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Location ld) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(ld);
		transaction.commit();
		System.out.println("location salvato");
	}

	public Location getById(long id) {
		Location found = em.find(Location.class, id);
		return found;
	}

	public void delete(long id) {
		Location found = em.find(Location.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("location con id " + id + " eliminato!");
		}
	}

	public void refresh(long id) {
		Location found = em.find(Location.class, id);
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);
	}
}
