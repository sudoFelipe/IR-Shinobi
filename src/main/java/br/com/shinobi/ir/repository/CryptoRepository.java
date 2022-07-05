package br.com.shinobi.ir.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.shinobi.ir.model.Crypto;

public interface CryptoRepository extends CrudRepository<Crypto, Integer>{

	@Query("SELECT cry FROM Crypto cry JOIN cry.user u WHERE u.username = :username")
	List<Crypto> findAllByUsuario(@Param("username") String username, Pageable paginacao);
}
