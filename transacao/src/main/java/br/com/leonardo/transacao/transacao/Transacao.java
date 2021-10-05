package br.com.leonardo.transacao.transacao;

import br.com.leonardo.transacao.cartao.Cartao;
import br.com.leonardo.transacao.estabelecimento.Estabelecimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idMensagem;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    @ManyToOne(cascade = CascadeType.ALL)
    private Estabelecimento estabelecimento;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cartao cartao;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String idMensagem, BigDecimal valor, LocalDateTime efetivadaEm, Estabelecimento estabelecimento, Cartao cartao) {
        this.idMensagem = idMensagem;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    public Long getId() {
        return id;
    }

    public String getIdMensagem() {
        return idMensagem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
