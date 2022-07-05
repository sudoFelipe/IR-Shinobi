package br.com.shinobi.ir.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.shinobi.ir.model.RendaFixa;

public interface RendaFixaRepository extends CrudRepository<RendaFixa, Integer>{

	@Query("SELECT rf FROM RendaFixa rf JOIN rf.user u WHERE u.username = :username")
	List<RendaFixa> findAllByUsuario(@Param("username") String username, Pageable paginacao);
}
