package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import esercizio1.Persona;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonaDAO {

	private final EntityManager em;

	public PersonaDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Persona prd) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(prd);
		transaction.commit();
		System.out.println("persona salvato");
	}

	public Persona getById(long id) {
		Persona found = em.find(Persona.class, id);
		return found;
	}

	public void delete(long id) {
		Persona found = em.find(Persona.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("persona con id " + id + " eliminato!");
		}
	}

	public void refresh(long id) {
		Persona found = em.find(Persona.class, id);
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);
	}
}
