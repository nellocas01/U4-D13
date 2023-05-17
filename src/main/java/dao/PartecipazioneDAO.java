package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import esercizio1.Partecipazione;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PartecipazioneDAO {

	private final EntityManager em;

	public PartecipazioneDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Partecipazione pd) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(pd);
		transaction.commit();
		System.out.println("partecipazione salvato");
	}

	public Partecipazione getById(long id) {
		Partecipazione found = em.find(Partecipazione.class, id);
		return found;
	}

	public void delete(long id) {
		Partecipazione found = em.find(Partecipazione.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("partecipazione con id " + id + " eliminato!");
		}
	}

	public void refresh(long id) {
		Partecipazione found = em.find(Partecipazione.class, id);
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);
	}
}
