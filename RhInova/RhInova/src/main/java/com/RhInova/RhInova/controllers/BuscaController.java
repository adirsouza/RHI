package com.RhInova.RhInova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.RhInova.RhInova.models.Candidatos;
import com.RhInova.RhInova.models.Dependente;
import com.RhInova.RhInova.models.Funcionario;
import com.RhInova.RhInova.models.Vaga;

import com.RhInova.RhInova.repository.FuncionarioRepository;
import com.RhInova.RhInova.repository.VagaRepository;
import com.RhInova.RhInova.repository.DependenteRepository;
import com.RhInova.RhInova.repository.CandidatosRepository;

@Controller
public class BuscaController {
	
	@Autowired
	private FuncionarioRepository fr;
	
	@Autowired
	private VagaRepository vr;
	
	@Autowired
	private DependenteRepository dr;
	
	@Autowired
	private CandidatosRepository cr;
	
	//GET
	@RequestMapping("/")
	public ModelAndView abrirIndex() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	//POST
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView buscarIndex(@RequestParam("buscar") String buscar, @RequestParam("nome") String nome) {
		
		ModelAndView mv = new ModelAndView("index");
		String mensagem = "Resultados da busca por " + buscar;
		
		if(nome.equals("nomefuncionario")) {
			mv.addObject("funcionarios", fr.findByNomes(buscar));
			
		}else if(nome.equals("nomedependente")) {
			mv.addObject("dependentes", dr.findByNomesDependentes(buscar));
			
//		}else if(nome.equals("nomecandidato")) {
//			mv.addObject("candidatos", cr.findByCandidatos(buscar));
			
		}else if(nome.equals("titulovaga")) {
			mv.addObject("vagas", vr.findByNomesVaga(buscar));
			
		}else {
			mv.addObject("funcionarios", fr.findByNomes(buscar));
			mv.addObject("dependentes", dr.findByNomesDependentes(buscar));
//			mv.addObject("candidatos", cr.findByCandidatos(buscar));
			mv.addObject("vagas", vr.findByNomesVaga(buscar));
		}
		
		mv.addObject("mensagem", mensagem);
		
		return mv;
	}

}
