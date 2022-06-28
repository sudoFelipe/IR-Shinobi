package br.com.shinobi.ir.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import br.com.shinobi.ir.model.Usuario;
import br.com.shinobi.ir.repository.UsuarioRepository;

//@Controller
public class LayoutController {

	/*
	 * @Autowired private UsuarioRepository userRepo;
	 * 
	 * public String layout(Model modelo, Principal principal) {
	 * 
	 * String username = principal.getName();
	 * 
	 * Usuario usuario = userRepo.findByUsername(username);
	 * 
	 * modelo.addAttribute("usuario", usuario);
	 * 
	 * return "layout"; }
	 */
}
