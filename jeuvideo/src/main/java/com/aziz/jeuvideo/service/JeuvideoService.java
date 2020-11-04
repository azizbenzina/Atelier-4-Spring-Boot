package com.aziz.jeuvideo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aziz.jeuvideo.entities.Categorie;
import com.aziz.jeuvideo.entities.Jeuvideo;

public interface JeuvideoService {
	
	Jeuvideo saveJeuvideo(Jeuvideo p);
	Jeuvideo updateJeuvideo(Jeuvideo p);
	void deleteJeuvideo(Jeuvideo p);
	 void deleteJeuvideoById(Long id);
	 Jeuvideo getJeuvideo(Long id);
	 List<Jeuvideo> getAllJeuvideos();
	 List<Jeuvideo> findByNomJeuvideo(String nom);
	 List<Jeuvideo> findByNomJeuvideoLike(String nom);
	 List<Jeuvideo> findByNomPrix (String nom, Double prix);
	 List<Jeuvideo> findByCategorie (Categorie categorie);
	 List<Jeuvideo> findByCategorieIdCat(Long id);
	 List<Jeuvideo> findByOrderByNomJeuvideoAsc();
	 List<Jeuvideo> trierJeuvideosNomsPrix();
	 Page<Jeuvideo> getAllJeuvideosParPage(int page, int size);
}
