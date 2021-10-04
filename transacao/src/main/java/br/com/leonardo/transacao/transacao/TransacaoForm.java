package br.com.leonardo.transacao.transacao;

import br.com.leonardo.transacao.cartao.Cartao;
import br.com.leonardo.transacao.estabelecimento.Estabelecimento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoForm {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private Estabelecimento estabelecimento;
    private Cartao cartao;

    public TransacaoForm(String id, BigDecimal valor, LocalDateTime efetivadaEm, Estabelecimento estabelecimento, Cartao cartao) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    @Deprecated
    public TransacaoForm() {
    }

    public Transacao toModel(){
        return new Transacao(this.id, this.valor, this.efetivadaEm,
                this.estabelecimento, this.cartao);
    }


    public String getId() {
        return id;
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
