package br.com.shinobi.ir.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.shinobi.ir.model.FII;

public interface FIIRepository extends CrudRepository<FII, Integer>{
	
	@Query("SELECT fi FROM FII fi JOIN fi.user u WHERE u.username = :username")
	
	@Cacheable("fiisUsuario")
	List<FII> findAllByUsuario(@Param("username") String username, Pageable ordenado);
}
