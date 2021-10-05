package br.com.leonardo.transacao.transacao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
    List<Transacao> findFirst100ByCartaoId(String id);
}
