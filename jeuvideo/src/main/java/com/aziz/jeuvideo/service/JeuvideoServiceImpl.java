package com.aziz.jeuvideo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aziz.jeuvideo.entities.Categorie;
import com.aziz.jeuvideo.entities.Jeuvideo;
import com.aziz.jeuvideo.repos.JeuvideoRepository;

@Service
public class JeuvideoServiceImpl implements JeuvideoService{
	
	@Autowired
	JeuvideoRepository jeuvideoRepository;

	@Override
	public Jeuvideo saveJeuvideo(Jeuvideo p) {
		// TODO Auto-generated method stub
		return jeuvideoRepository.save(p);
	}

	@Override
	public Jeuvideo updateJeuvideo(Jeuvideo p) {
		// TODO Auto-generated method stub
		return jeuvideoRepository.save(p);
	}

	@Override
	public void deleteJeuvideo(Jeuvideo p) {
		// TODO Auto-generated method stub
		jeuvideoRepository.delete(p);
	}

	@Override
	public void deleteJeuvideoById(Long id) {
		// TODO Auto-generated method stub
		jeuvideoRepository.deleteById(id);
	}

	@Override
	public Jeuvideo getJeuvideo(Long id) {
		// TODO Auto-generated method stub
		return jeuvideoRepository.findById(id).get();
	}

	@Override
	public List<Jeuvideo> getAllJeuvideos() {
		return jeuvideoRepository.findAll();
	}

	

	@Override
	public List<Jeuvideo> findByNomJeuvideo(String nom) {
		return jeuvideoRepository.findByNomJeuvideo(nom);
	}

	@Override
	public List<Jeuvideo> findByNomJeuvideoLike(String nom) {
		return jeuvideoRepository.findByNomJeuvideoLike(nom);
	}

	@Override
	public List<Jeuvideo> findByNomPrix(String nom, Double prix) {
		return jeuvideoRepository.findByNomPrix(nom, prix);
	}
	
	@Override
	public List<Jeuvideo> findByCategorie(Categorie categorie) {
		return jeuvideoRepository.findByCategorie(categorie);
	}

	@Override
	public List<Jeuvideo> findByCategorieIdCat(Long id) {
		return jeuvideoRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<Jeuvideo> findByOrderByNomJeuvideoAsc() {
		return jeuvideoRepository.findByOrderByNomJeuvideoAsc();
	}

	@Override
	public List<Jeuvideo> trierJeuvideosNomsPrix() {
		return jeuvideoRepository.trierJeuvideosNomsPrix();
	}

	@Override
	public Page<Jeuvideo> getAllJeuvideosParPage(int page, int size) {
		
		return jeuvideoRepository.findAll(PageRequest.of(page, size));
	}
}
