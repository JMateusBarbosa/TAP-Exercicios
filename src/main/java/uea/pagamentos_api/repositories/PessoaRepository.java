package uea.pagamentos_api.repositories;

import java.util.List;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.pagamentos_api.models.Pessoa;
=======
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.pagamentos_api.dto.ResumoPessoaDto;
import uea.pagamentos_api.models.Pessoa;
import uea.pagamentos_api.repositories.filters.PessoaFilter;
>>>>>>> 4aec7a5 (atividade 5)

@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Long> {

	List<Pessoa> findByNomeContainingIgnoreCase(String nome);

<<<<<<< HEAD
=======
	

>>>>>>> 4aec7a5 (atividade 5)
}
