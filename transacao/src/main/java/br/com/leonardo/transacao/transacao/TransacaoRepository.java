package br.com.leonardo.transacao.transacao;

import br.com.leonardo.transacao.cartao.Cartao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, Long > {

   public List<Transacao> findFirst10ByCartaoId(String idCartao);


}
