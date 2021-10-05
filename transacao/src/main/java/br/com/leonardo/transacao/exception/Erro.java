package br.com.leonardo.transacao.exception;

import java.time.LocalDateTime;

public class Erro {
    private final LocalDateTime horario;
    private final Integer codigoErro;
    private final String httpStatus;
    private final String mensagem;

    public Erro(LocalDateTime horario, Integer codigoErro, String httpStatus, String mensagem) {
        this.horario = horario;
        this.codigoErro = codigoErro;
        this.httpStatus = httpStatus;
        this.mensagem = mensagem;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public Integer getCodigoErro() {
        return codigoErro;
    }

    public String getHttpStatus() {
        return httpStatus;
    }


    public String getMensagem() {
        return mensagem;
    }
}
