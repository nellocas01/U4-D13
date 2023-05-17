package esercizio1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "partecipazione")
@Getter
@Setter

public class Partecipazione {

	@Id
	@GeneratedValue // Obbligatorio usarlo se si vuol fare gestire gli id al db
	// private UUID id;
	private long id;
	private String persona;
	private String evento;
	private String stato; // confermata o da confermare

	public Partecipazione() {
	}

	public Partecipazione(String persona, String evento, String stato) {
		super();
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Partecipazione [id=" + id + ", persona=" + persona + ", evento=" + evento + ", stato=" + stato + "]";
	}

};
