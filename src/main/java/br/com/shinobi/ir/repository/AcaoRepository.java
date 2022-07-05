package br.com.shinobi.ir.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.shinobi.ir.model.Acao;

public interface AcaoRepository extends CrudRepository<Acao, Integer>{

	@Query("SELECT ac FROM Acao ac JOIN ac.user u WHERE u.username = :username")
	List<Acao> findAllByUsuario(@Param("username") String username, Pageable paginacao);
}
