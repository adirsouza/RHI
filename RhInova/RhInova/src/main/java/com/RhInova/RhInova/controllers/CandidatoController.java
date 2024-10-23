package com.RhInova.RhInova.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.RhInova.RhInova.models.Candidatos;
import com.RhInova.RhInova.repository.CandidatosRepository;

@Controller
public class CandidatoController {

	@Autowired
	private CandidatosRepository cr;
	
	//GET que chama o Form para cadastrar Candidatos
	@RequestMapping("/cadastrarCandidatos")
	public String form() {
		return "vagas/formCandidato";
	}
	
	//POST que cadastra Candidato
	@RequestMapping(value = "/cadastrarCandidatos", method = RequestMethod.POST)
	public String form(@Valid Candidatos candidatos, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			attributes.addAttribute("mansagem", "Verifique os campos");
			return "redirect:/cadastrarCandidatos";
		}
		
		cr.save(candidatos);
		attributes.addFlashAttribute("mensagem", "Candidato Cadastrado com Sucesso!");
		return "redirect:/cadastrarCandidatos";
	}
		
	//GET que lista Candidatos
	@RequestMapping("/candidatos")
	public ModelAndView listaCandidatos() {
		ModelAndView mv = new ModelAndView("vagas/listaCandidatos");
		Iterable<Candidatos> candidato = cr.findAll();
		mv.addObject("candidato", candidato);
		return mv;
	}
	
	
//		//GET que Deleta o Candidato da Base
//	@RequestMapping("/deletaCandidato")
//	public String deletaCandidato(long id) {
//		Candidatos candidatos = cr.findById(id);
//		cr.delete(candidatos);
//		return "redirect:/cadastrarCandidato";
//	}
	
	//Metodos que atualizam Candidato
	//GET que chama o FORM de Edição do Candidato
	@RequestMapping("/editarCandidato")
	public ModelAndView editarCandidatos(long id) {
		Optional<Candidatos> candidato = cr.findById(id);
		ModelAndView mv = new ModelAndView("vagas/updateCandidato");
		mv.addObject("candidato", candidato);
		return mv;
	}
	
	//POST que atualiza o Candidato
	@RequestMapping(value = "/editarCandidato", method = RequestMethod.POST)
	public String updateCandidato(@Valid Candidatos candidato, BindingResult result, RedirectAttributes attiAttributes) {
		
		cr.save(candidato);
		attiAttributes.addAttribute("Successs", "Candidato Alterado com sucesso");
		
		long idLong = candidato.getId();
		String id = "" + idLong;
		return "redirect:/detalhesCandidato/" + id;
	}
}
