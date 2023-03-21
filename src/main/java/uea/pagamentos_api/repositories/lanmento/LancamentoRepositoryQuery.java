package uea.pagamentos_api.repositories.lanmento;

<<<<<<< HEAD
import java.util.List;
=======
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
>>>>>>> 4aec7a5 (atividade 5)

import uea.pagamentos_api.dto.ResumoLancamentoDto;
import uea.pagamentos_api.repositories.filters.LancamentoFilter;

public interface LancamentoRepositoryQuery {

<<<<<<< HEAD
	public List<ResumoLancamentoDto> filtrar(
			LancamentoFilter lancamentoFilter);
=======
	public Page<ResumoLancamentoDto> filtrar(
			LancamentoFilter lancamentoFilter, Pageable pageable);
>>>>>>> 4aec7a5 (atividade 5)

}
