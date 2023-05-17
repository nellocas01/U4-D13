package esercizio1;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Getter
@Setter

public class Persona {

	@Id
	@GeneratedValue // Obbligatorio usarlo se si vuol fare gestire gli id al db
	// private UUID id;
	private long id;
	private String nome;
	private String cognome;
	private String email; // [pubblico, privato]
	private LocalDate dataNascita;
	private String sesso;
	private String listaPartecipanti;

	public Persona() {
	}

	public Persona(String nome, String cognome, String email, LocalDate dataNascita, String sesso,
			String listaPartecipanti) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
		this.listaPartecipanti = listaPartecipanti;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", dataNascita="
				+ dataNascita + ", sesso=" + sesso + ", listaPartecipanti=" + listaPartecipanti + "]";
	}

}
