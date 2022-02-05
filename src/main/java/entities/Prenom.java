package entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Prenom {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String libelle;
	private int effectif;
	
	
	
	
	public Prenom() {
		super();
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getEffectif() {
		return effectif;
	}
	public void setEffectif(int effectif) {
		this.effectif = effectif;
	}



	@Override
	public int hashCode() {
		return Objects.hash(effectif, id, libelle);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prenom other = (Prenom) obj;
		return effectif == other.effectif && id == other.id && Objects.equals(libelle, other.libelle);
	}
	@Override
	public String toString() {
		return "Prenom [id=" + id + ", libelle=" + libelle + ", effectif=" + effectif + "]";
	}
	
	
}
