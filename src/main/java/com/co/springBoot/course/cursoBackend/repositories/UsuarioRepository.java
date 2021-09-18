/**
 * 
 */
package com.co.springBoot.course.cursoBackend.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.springBoot.course.cursoBackend.models.UsuarioModel;

/**
 * @author gomez
 *
 */
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
	public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}
