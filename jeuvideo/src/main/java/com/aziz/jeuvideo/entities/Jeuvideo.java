package com.aziz.jeuvideo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Jeuvideo {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Long idjeu;
	private String titre;
	private Double prix;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@ManyToOne
	private Categorie categorie;

	public Long getIdjeu() {
		return idjeu;
	}

	public void setIdjeu(Long idjeu) {
		this.idjeu = idjeu;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Jeuvideo() {
		super();

	}

	public Jeuvideo(String titre, Double prix, Date date) {
		super();
		this.titre = titre;
		this.prix = prix;
		this.date = date;
	}

	@Override
	public String toString() {
		return "jeuvideo [idjeu=" + idjeu + ", titre=" + titre + ", prix=" + prix + ", date=" + date + "]";
	}

}
