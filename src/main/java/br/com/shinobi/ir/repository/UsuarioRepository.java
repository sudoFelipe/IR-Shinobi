package br.com.shinobi.ir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.shinobi.ir.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	Usuario findByUsername(String usuario);
}
