package com.aziz.jeuvideo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aziz.jeuvideo.entities.Categorie;
import com.aziz.jeuvideo.entities.Jeuvideo;

public interface JeuvideoRepository extends JpaRepository<Jeuvideo, Long> {
	List<Jeuvideo> findByNomJeuvideo(String nom);
	List<Jeuvideo> findByNomJeuvideoLike(String nom);
	List<Jeuvideo> findByNomJeuvideoContains(String nom); 
	
	@Query("select p from Jeuvideo p where p.titre like %:nom and p.prix > :prix")
	List<Jeuvideo> findByNomPrix (@Param("titre") String nom,@Param("prix") Double prix);
	
	@Query("select p from Jeuvideo p where p.categorie = ?1")
	List<Jeuvideo> findByCategorie (Categorie categorie);
	
	List<Jeuvideo> findByCategorieIdCat(Long id);
	
	List<Jeuvideo> findByOrderByNomJeuvideoAsc();
	
	@Query("select p from Jeuvideo p order by p.titre ASC, p.prix DESC")
	List<Jeuvideo> trierJeuvideosNomsPrix ();

}
