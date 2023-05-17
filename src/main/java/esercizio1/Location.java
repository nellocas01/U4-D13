package esercizio1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "location")
@Getter
@Setter

public class Location {

	@Id
	@GeneratedValue // Obbligatorio usarlo se si vuol fare gestire gli id al db
	// private UUID id;
	private long id;
	private String nome;
	private String città;

	public Location() {
	}

	public Location(String nome, String città) {
		super();
		this.nome = nome;
		this.città = città;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", nome=" + nome + ", città=" + città + "]";
	}

}
