package br.com.shinobi.ir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.shinobi.ir.model.FII;

public interface FIIRepository extends CrudRepository<FII, Integer>{
	
	@Query("SELECT fi FROM FII fi "
		 + "JOIN fi.user u WHERE u.username = :username")
	
//	@Query(name = "SELECT * FROM fii WHERE user_username = :username", 
//		   nativeQuery = true)
	List<FII> findAllByUsuario(@Param("username") String username);
}
