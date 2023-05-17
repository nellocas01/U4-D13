package esercizio1;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import lombok.extern.slf4j.Slf4j;
import utils.JpaUtil;

@Slf4j
public class Main1 {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		EventoDAO ed = new EventoDAO(em);
		LocationDAO ld = new LocationDAO(em);
		PartecipazioneDAO pd = new PartecipazioneDAO(em);
		PersonaDAO prd = new PersonaDAO(em);

		// ************************ SAVE *********************
		Evento one = new Evento("Buon Compleanno", LocalDate.now(), "18esimo compleanno", "disco", 50);
		ed.save(one);
		Location l = new Location("Nello", "Napoli");
		ld.save(l);
		Partecipazione p = new Partecipazione("persona", "18esimo compleanno", "confermata");
		pd.save(p);
		Persona pr = new Persona("Nello", "Casolla", "nellocas0@live.it", LocalDate.now(), "m", "lista");
		prd.save(pr);

		// ************************ FIND BY ID *********************

		System.out.println(ed.getById(0));
		System.out.println(ld.getById(0));
		System.out.println(pd.getById(0));
		System.out.println(prd.getById(0));

		// ************************ DELETE *********************
		ed.delete(0);
		ld.delete(0);
		pd.delete(0);
		prd.delete(0);

		// ************************ REFRESH ********************
		ed.refresh(7);
		ld.refresh(7);
		pd.refresh(7);
		prd.refresh(7);
		em.close();

		emf.close();
	}

}
