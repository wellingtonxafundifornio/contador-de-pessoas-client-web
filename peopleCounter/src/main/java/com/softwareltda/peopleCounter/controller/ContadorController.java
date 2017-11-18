package com.softwareltda.peopleCounter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softwareltda.peopleCounter.service.ContadorService;

@Controller
@RequestMapping("/contador")
public class ContadorController {

	private ContadorService service = new ContadorService();

	@RequestMapping("/iniciar")
	public String novo() {

		return "contador/ContadorPessoa";

	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> atualizarContador() {

		return ResponseEntity.ok(service.atualizaContador());

	}

}
