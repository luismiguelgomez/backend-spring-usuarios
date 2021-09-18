/**
 * 
 */
package com.co.springBoot.course.cursoBackend.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.springBoot.course.cursoBackend.models.UsuarioModel;
import com.co.springBoot.course.cursoBackend.services.UsuarioServices;

/**
 * @author gomez
 *
 */

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioServices usuarioService;
	
	@GetMapping()
	public ArrayList<UsuarioModel> obtenerUsuario() {
		return usuarioService.obtenerUsuarios();
	}
	
	@PostMapping()
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
		return usuarioService.guardaUsuario(usuario);
	}
	
	/**
	 * La palabra reservada de Optional nos da una gran utilidad<br> 
	 * Ya que nos ayuda a que si no existe el id nos de un null y no un error
	 * @param id
	 * @return
	 */
	@GetMapping( path = "/{id}")
	public Optional<UsuarioModel> obtenerUsuarioPorId (@PathVariable("id") Long id) {
		return this.usuarioService.obtenerPorId(id);
	}
	
	@GetMapping( path = "/buscarPorPrioridad")
	public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad (@RequestParam("prioridad") Integer prioridad) {
		return this.usuarioService.obtenerPorPrioridad(prioridad);
	}
	
	@DeleteMapping( path = "/{id}")
	public String eliminarPorId (@PathVariable("id") Long id) {
		boolean response = this.usuarioService.eliminarUsuarioPorId(id);
		if (response) {
			return "Se eliminó el usuario con id" + id;
		} else {
			return "No se pudo eliminar el usuario con id" + id;
		}
	}
}
