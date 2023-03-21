package uea.pagamentos_api.repositories.lanmento;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
>>>>>>> 4aec7a5 (atividade 5)
import org.springframework.util.ObjectUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
<<<<<<< HEAD
=======
import jakarta.persistence.TypedQuery;
>>>>>>> 4aec7a5 (atividade 5)
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import uea.pagamentos_api.dto.ResumoLancamentoDto;
import uea.pagamentos_api.models.Lancamento;
import uea.pagamentos_api.repositories.filters.LancamentoFilter;

public class LancamentoRepositoryQueryImpl 
implements LancamentoRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
<<<<<<< HEAD
	public List<ResumoLancamentoDto> filtrar(LancamentoFilter lancamentoFilter) {
=======
	public Page<ResumoLancamentoDto> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable) {
>>>>>>> 4aec7a5 (atividade 5)
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<ResumoLancamentoDto> criteria = builder.createQuery(ResumoLancamentoDto.class);
		Root<Lancamento> root = criteria.from(Lancamento.class);
		
		criteria.select(builder.construct(ResumoLancamentoDto.class, root.get("codigo"), root.get("descricao"),
				root.get("dataVencimento"), root.get("dataPagamento"), root.get("valor"), root.get("tipo"),
				root.get("categoria").get("nome"), root.get("pessoa").get("nome")));
		
		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}
		
<<<<<<< HEAD
		List<ResumoLancamentoDto> returnList = manager.createQuery(criteria).getResultList();
		
		return returnList;
	}
	
=======
		TypedQuery<ResumoLancamentoDto> query = manager.createQuery(criteria);
		
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable,
				total(lancamentoFilter));
	}
	
	private Long total(LancamentoFilter lancamentoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Lancamento> root = criteria.from(Lancamento.class);

		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<ResumoLancamentoDto> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistroPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistroPorPagina);
	}

>>>>>>> 4aec7a5 (atividade 5)
	private Predicate[] criarRestricoes(LancamentoFilter lancamentoFilter, CriteriaBuilder builder,
			Root<Lancamento> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!ObjectUtils.isEmpty(lancamentoFilter.getDescricao())) {
			predicates.add(builder.like(builder.lower(root.get("descricao")),
					"%" + lancamentoFilter.getDescricao().toLowerCase() + "%"));
		}

		if (lancamentoFilter.getDataVencimentoDe() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get("dataVencimento"), lancamentoFilter.getDataVencimentoDe()));
		}

		if (lancamentoFilter.getDataVencimentoAte() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get("dataVencimento"), lancamentoFilter.getDataVencimentoAte()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	

}
<<<<<<< HEAD
=======
	


>>>>>>> 4aec7a5 (atividade 5)
