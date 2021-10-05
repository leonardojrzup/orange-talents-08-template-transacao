package br.com.leonardo.transacao.cartao;

import br.com.leonardo.transacao.cartao.Cartao;
import org.springframework.data.repository.CrudRepository;

public interface CartaoRepository extends CrudRepository<Cartao, String> {


}
