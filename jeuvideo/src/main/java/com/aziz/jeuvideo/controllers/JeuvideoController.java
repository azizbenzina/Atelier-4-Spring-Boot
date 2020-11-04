package com.aziz.jeuvideo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aziz.jeuvideo.entities.Jeuvideo;
import com.aziz.jeuvideo.service.JeuvideoService;
@Controller
public class JeuvideoController {
@Autowired
JeuvideoService jeuvideoService;

@RequestMapping("/showCreate")
public String showCreate()
{
	return "createJeuvideo";
}

@RequestMapping("/saveJeuvideo")
public String saveJeuvideo(@ModelAttribute("jeuvideo") Jeuvideo jeuvideo,ModelMap modelMap)
{
	Jeuvideo saveJeuvideo = jeuvideoService.saveJeuvideo(jeuvideo);
	 String msg ="jeuvideo enregistré avec Id "+saveJeuvideo.getIdjeu();
	 modelMap.addAttribute("msg", msg);
return "createJeuvideo";
}

@RequestMapping("/ListeJeuvideo")
public String listeJeuvideo(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
Page<Jeuvideo> prods = jeuvideoService.getAllJeuvideosParPage(page, size);
modelMap.addAttribute("jeuvideos", prods);
 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeJeuvideo";
}


@RequestMapping("/supprimerJeuvideo")
public String supprimerProduit(@RequestParam("id") Long id,
		ModelMap modelMap,
		@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "2") int size)
{
	jeuvideoService.deleteJeuvideoById(id);
	Page<Jeuvideo> prods = jeuvideoService.getAllJeuvideosParPage(page,size);
	modelMap.addAttribute("jeuvideos", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
return "listeJeuvideo";
}

@RequestMapping("/modifierJeuvideo")
public String editerJeuvideo(@RequestParam("id") Long id,ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "2") int size)
{
Jeuvideo p= jeuvideoService.getJeuvideo(id);
modelMap.addAttribute("jeuvideo", p);
return "editerJeuvideo";
}

@RequestMapping("/updateJeuvideo")
public String updateJeuvideo(@ModelAttribute("jeuvideo") Jeuvideo jeuvideo,ModelMap modelMap)
{
	jeuvideoService.updateJeuvideo(jeuvideo);
	  List<Jeuvideo> prods = jeuvideoService.getAllJeuvideos();
	  modelMap.addAttribute("jeuvideos", prods);
return "listeJeuvideo";
}
}
