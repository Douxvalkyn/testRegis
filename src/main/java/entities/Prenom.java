//package entities;
//
//import java.util.Objects;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class Prenom {
//
//	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
//	private int id;
//	private String libelle;
//	private int effectif;
//	private int tauxMention;
//	
//	
//	
//	
//	public Prenom() {
//		super();
//	}
//	public String getLibelle() {
//		return libelle;
//	}
//	public void setLibelle(String libelle) {
//		this.libelle = libelle;
//	}
//	public int getEffectif() {
//		return effectif;
//	}
//	public void setEffectif(int effectif) {
//		this.effectif = effectif;
//	}
//	public int getTauxMention() {
//		return tauxMention;
//	}
//	public void setTauxMention(int tauxMention) {
//		this.tauxMention = tauxMention;
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(effectif, libelle, tauxMention);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Prenom other = (Prenom) obj;
//		return effectif == other.effectif && Objects.equals(libelle, other.libelle) && tauxMention == other.tauxMention;
//	}
//	@Override
//	public String toString() {
//		return "Prenom [libelle=" + libelle + ", effectif=" + effectif + ", tauxMention=" + tauxMention + "]";
//	}
//	
//	
//}
