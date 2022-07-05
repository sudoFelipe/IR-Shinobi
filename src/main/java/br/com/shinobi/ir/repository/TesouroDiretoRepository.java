package br.com.shinobi.ir.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.shinobi.ir.model.TesouroDireto;

public interface TesouroDiretoRepository extends CrudRepository<TesouroDireto, Integer>{

	@Query("SELECT td FROM TesouroDireto td JOIN td.user u WHERE u.username = :username")
	List<TesouroDireto> findAllByUsuario(@Param("username") String username, Pageable paginacao);
}
