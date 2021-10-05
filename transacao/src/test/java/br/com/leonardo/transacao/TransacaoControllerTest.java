package br.com.leonardo.transacao;

import br.com.leonardo.transacao.cartao.Cartao;
import br.com.leonardo.transacao.cartao.CartaoRepository;
import br.com.leonardo.transacao.estabelecimento.Estabelecimento;
import br.com.leonardo.transacao.transacao.Transacao;
import br.com.leonardo.transacao.transacao.TransacaoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
public class TransacaoControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected TransacaoRepository transacaoRepository;

    @Autowired
    protected CartaoRepository cartaoRepository;


    @Test
    public void deveriaRetornarListaDeTransacoesDto() throws Exception {
        Estabelecimento estabelecimento = new Estabelecimento("Casa de carnes JK", "Anápolis", "Rua Ipê");
        Cartao cartao = new Cartao("02123456789112", "leonardo@teste.com");
        Transacao transacao = new Transacao("1234", new BigDecimal(25000), LocalDateTime.now(), estabelecimento, cartao);
        transacao = transacaoRepository.save(transacao);

        mockMvc.perform(MockMvcRequestBuilders.get(  "/transacoes/" + transacao.getCartao().getId().toString()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deveriaLancarExcecaoAoBuscarCartaoQueNaoExiste() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/transacoes/cartaonaocriado"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
