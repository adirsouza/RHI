package com.RhInova.RhInova.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.RhInova.RhInova.models.Candidatos;
import com.RhInova.RhInova.models.Vaga;
import com.RhInova.RhInova.repository.CandidatosRepository;
import com.RhInova.RhInova.repository.CandidatosRepository;
import com.RhInova.RhInova.repository.VagaRepository;

@Controller
public class VagaController {

	@Autowired
	private VagaRepository vr;
	
	@Autowired
	private CandidatosRepository cr;

	// GET que chama o FORM que cadastra vaga
	@RequestMapping("/cadastrarVaga")
	public String form() {
		return "vagas/formCandidato";
	}

	// POST que cadastra a vaga
	@RequestMapping(value = "/cadastrarVaga", method = RequestMethod.POST)
	public String form(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos...");
			return "redirect:/cadastrarVaga";
		}

		vr.save(vaga);
		attributes.addFlashAttribute("mensagem", "Vaga cadastrada com sucesso!");
		return "redirect:/cadastrarVaga";
	}

	// GET que lista as vagas
	@RequestMapping("/vagas")
	public ModelAndView listaVagas() {
		ModelAndView mv = new ModelAndView("vagas/listaVagas");
		Iterable<Vaga> vagas = vr.findAll();
		mv.addObject("vagas", vagas);
		return mv;
	}

	// GET que mostra os detalhes da vaga e os candidatos
	@RequestMapping("/vagas/{codigo}")
	public ModelAndView detalhesVaga(@PathVariable("codigo") long codigo) {
		Vaga vagas = vr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("vagas/detalhesVaga");
		mv.addObject("vagas", vagas);

//		Iterable<Candidatos> canditados = (Iterable<Candidatos>) cr.findByVagas(vagas);
//		mv.addObject("candidatos", canditados);

		return mv;

	}

	// GET que deleta a vaga
	@RequestMapping("/deletarVaga")
	public String deletarVaga(long codigo) {
		Vaga vaga = vr.findByCodigo(codigo);
		vr.delete(vaga);
		return "redirect:/vagas";
	}

	// POST que adiciona candidato a vaga
	@RequestMapping(value = "/vagas/{codigo}", method = RequestMethod.POST)
	public String detalhesVagaPost(@PathVariable("codigo") long codigo, @Valid Candidatos candidatos,
			BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/vagas/{codigo}";
		}

//		// rg duplicado
//		if (cr.findByCPF(candidatos.getRg()) != null) {
//			attributes.addFlashAttribute("mensagem_erro", "RG duplicado");
//			return "redirect:/vagas/{codigo}";
//		}

		Vaga vaga = vr.findByCodigo(codigo);
		candidatos.setVaga(vaga);
		cr.save(candidatos);
		attributes.addFlashAttribute("mensagem", "Candidato adionado com sucesso!");
		return "redirect:/vagas/{codigo}";
	}

//	// GET que deleta o candidato pelo RG
//	@RequestMapping("/deletarCandidato")
//	public String deletarCandidato(String cpf) {
//		Candidatos candidatos = cr.findByCPF(cpf);
//	   Vaga vaga = candidatos.getVaga();
//		String codigo = "" + vaga.getCodigo();
//
//		cr.delete(candidatos);
//
//		return "redirect:/vagas/" + codigo;
//
//	}

	// Métodos que atualizam vaga
	// GET que chama o formulário de edição da vaga
	@RequestMapping("/editar-vaga")
	public ModelAndView editarVaga(long codigo) {
		Vaga vaga = vr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("vagas/updateVaga");
		mv.addObject("vaga", vaga);
		return mv;
	}

	// POST do FORM que atualiza a vaga
	@RequestMapping(value = "/editar-vaga", method = RequestMethod.POST)
	public String updateVaga(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes) {
		vr.save(vaga);
		attributes.addFlashAttribute("success", "Vaga alterada com sucesso!");

		long codigoLong = vaga.getCodigo();
		String codigo = "" + codigoLong;
		return "redirect:/vagas/" + codigo;
	}

}
