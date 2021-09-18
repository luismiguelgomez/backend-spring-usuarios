/**
 * 
 */
package com.co.springBoot.course.cursoBackend.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.springBoot.course.cursoBackend.models.UsuarioModel;
import com.co.springBoot.course.cursoBackend.repositories.UsuarioRepository;

/**
 * @author gomez
 *
 */
@Service
public class UsuarioServices {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public ArrayList<UsuarioModel> obtenerUsuarios() {
		return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
	}
	
	public UsuarioModel guardaUsuario (UsuarioModel usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Optional<UsuarioModel> obtenerPorId (Long id) {
		return usuarioRepository.findById(id);
	}
	
	public ArrayList<UsuarioModel> obtenerPorPrioridad (Integer prioridad) {
		return usuarioRepository.findByPrioridad(prioridad);
	}
	
	public boolean eliminarUsuarioPorId (Long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
