package com.aziz.jeuvideo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import com.aziz.jeuvideo.service.JeuvideoService;
import com.aziz.jeuvideo.entities.Categorie;
import com.aziz.jeuvideo.entities.Jeuvideo;
import com.aziz.jeuvideo.repos.JeuvideoRepository;

@SpringBootTest
class JeuvideoApplicationTests {

	@Autowired
	private JeuvideoRepository jeuvideoRepository;
	@Autowired
	private JeuvideoService jeuvideoService;
	
	@Test
	public void testCreateJeu() {
	Jeuvideo jeu = new Jeuvideo();
	jeu.setTitre("Fallout 5");
	jeu.setPrix(20.0);
	jeuvideoRepository.save(jeu);
	}
	
	@Test
	public void testFindJeuvideo()
	{
	Jeuvideo p = jeuvideoRepository.findById(1L).orElse(null);
	System.out.println(p);
	}
	@Test
	public void testUpdateJeuvideo()
	{
	Jeuvideo p = jeuvideoRepository.findById(1L).orElse(null);
	p.setPrix(80.0);
	jeuvideoRepository.save(p);
	}
	@Test
	public void testDeleteJeuvideo()
	{
	jeuvideoRepository.deleteById(1L);;
	}

	@Test
	public void testListerJeuvideo()
	{
	List<Jeuvideo> jeu = jeuvideoRepository.findAll();
	for (Jeuvideo p : jeu)
	{
	System.out.println(p);
	}
	}
	
	
	@Test
	public void testFindByNomJeuvideo()
	{
	List<Jeuvideo> prods = jeuvideoRepository.findByNomJeuvideo("FIFA 20");
	for (Jeuvideo p : prods)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testFindByNomJeuvideoLike()
	 {
		List<Jeuvideo>  prods = jeuvideoRepository.findByNomJeuvideoLike("FIFA 20");
			for (Jeuvideo p : prods)
			{
				System.out.println(p);
			}
		
	 }
	
	@Test
	public void testFindByNomJeuvideoContains ()
	{
		Page<Jeuvideo>  prods = jeuvideoService.getAllJeuvideosParPage(0,2);
		System.out.println(prods.getSize());
		System.out.println(prods.getTotalElements());
		System.out.println(prods.getTotalPages());
		
		prods.getContent().forEach(p -> {System.out.println(p.toString());
		                                 }); 
	}


	@Test
	public void testfindByNomPrix()
	 {
		List<Jeuvideo>  prods = jeuvideoRepository.findByNomPrix("FALLOUT", 20.0);
			for (Jeuvideo p : prods)
			{
				System.out.println(p);
			}
		
	 }
	 
	@Test
	public void testfindByCategorie()
	 {
		Categorie cat = new Categorie();
		cat.setIdCat(1L);			
		List<Jeuvideo>  prods = jeuvideoRepository.findByCategorie(cat);
			for (Jeuvideo p : prods)
			{
				System.out.println(p);
			}
	 }
	
	@Test
	public void findByCategorieIdCat()
	 {			
		List<Jeuvideo>  prods = jeuvideoRepository.findByCategorieIdCat(1L);
			for (Jeuvideo p : prods)
			{
				System.out.println(p);
			}
	 }

	
	@Test
	public void testfindByOrderByNomJeuvideoAsc()
	 {
		List<Jeuvideo>  prods = jeuvideoRepository.findByOrderByNomJeuvideoAsc();	 
			for (Jeuvideo p : prods)
			{
				System.out.println(p);
			}
	 }
	
	@Test
	public void testTrierJeuvideosNomsPrix()
	 {
		List<Jeuvideo>  prods = jeuvideoRepository.trierJeuvideosNomsPrix();	 
			for (Jeuvideo p : prods)
			{
				System.out.println(p);
			}
	 }
}
