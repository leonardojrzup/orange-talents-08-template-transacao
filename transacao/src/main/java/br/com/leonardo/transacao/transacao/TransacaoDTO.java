package br.com.leonardo.transacao.transacao;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDTO {
    private LocalDateTime efetivada;
    private String endereco;
    private String nome;
    private BigDecimal valor;

    public TransacaoDTO(LocalDateTime efetivada, String endereco, String nome, BigDecimal valor) {
        this.efetivada = efetivada;
        this.endereco = endereco;
        this.nome = nome;
        this.valor = valor;
    }

    public TransacaoDTO(Transacao transacao) {
        this.efetivada = transacao.getEfetivadaEm();
        this.endereco = transacao.getEstabelecimento().getEndereco();
        this.nome = transacao.getEstabelecimento().getNome();
        this.valor = transacao.getValor();
    }

    public LocalDateTime getEfetivada() {
        return efetivada;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
